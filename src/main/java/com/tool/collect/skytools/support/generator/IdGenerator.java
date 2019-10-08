package com.tool.collect.skytools.support.generator;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Twitter Snowflake 64位自增ID算法
 * <p>
 * 时间戳42位 + 主机IP地址后2个域共 16位 + 毫秒自增 6位 = 64位
 *
 * @author Gnoll
 * @create 2017-07-03 10:05
 **/
public class IdGenerator {
    /**
     * 主机地址
     */
    private long hostId;
    /**
     * 毫秒自增值
     */
    private long sequence = 0L;
    /**
     * 起始时间 2017-07-01 12:00:00
     */
    private long twepoch = 1498838400000L;
    /**
     * 主机值占位
     */
    private long hostIdBits = 16L;
    /**
     * 毫秒自增占位,该参数决定1毫秒之内并发数量
     */
    private long sequenceBits = 6L;
    /**
     * 主机值偏移位
     */
    private long hostIdShift = sequenceBits;
    /**
     * 时间戳偏移位
     */
    private long timestampShift = sequenceBits + hostIdBits;
    /**
     * HostId 最大值
     */
    private long maxHostId = -1L ^ (-1L << hostIdBits);
    /**
     * 毫秒自增最大值
     */
    private long maxSequence = -1L ^ (-1L << sequenceBits);
    /**
     * 最后请求时间
     */
    private long lastTimestamp = 0L;

    private Lock lock = new ReentrantLock();

    public IdGenerator(long hostId) {
        if (hostId > maxHostId || maxHostId < 0)
            throw new IllegalArgumentException(String.format("host Id can't be greater than %d or less than 0", maxHostId));
        this.hostId = hostId;
    }

    public long nextId() {
        lock.lock();
        try {
            long timestamp = timeGen();

            if (timestamp < lastTimestamp) {
                throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
            }

            if (lastTimestamp == timestamp) {
                sequence = (sequence + 1) & maxSequence;
                if (sequence == 0) {
                    timestamp = tilNextMillis(lastTimestamp);
                }
            } else {
                sequence = 0L;
            }
            lastTimestamp = timestamp;
            return ((timestamp - twepoch) << timestampShift) | (hostId << hostIdShift) | sequence;
        } finally {
            lock.unlock();
        }
    }

    public String nextIdString() {
        return String.valueOf(nextId());
    }

    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }
}
