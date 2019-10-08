package com.tool.collect.skytools.support.http;

import org.apache.http.conn.HttpClientConnectionManager;

/**
 * 关闭过期连接
 *
 * @author Gnoll
 * @create 2017-06-23 9:44
 **/
public class IdelConnectionMonitorThread extends Thread {

    private final HttpClientConnectionManager connectionManager;
    private volatile boolean shutdown;


    public IdelConnectionMonitorThread(HttpClientConnectionManager connectionManager) {
        super();
        this.connectionManager = connectionManager;
    }

    @Override
    public void run() {
        try {
            while (!shutdown) {
                synchronized (this) {
                    wait(5000);
                    if (null != connectionManager) {
                        connectionManager.closeExpiredConnections();
//                    connectionManager.closeIdleConnections(30, TimeUnit.SECONDS);
                    }
                }
            }
        } catch (InterruptedException e) {
        }
    }

    public void shutDown() {
        shutdown = true;
        synchronized (this) {
            notifyAll();
        }
    }
}
