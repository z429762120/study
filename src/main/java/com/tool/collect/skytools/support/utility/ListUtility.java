package com.tool.collect.skytools.support.utility;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Descriiption
 * @Author bo
 * @Date 2019/9/10 下午5:45
 **/
@UtilityClass
public class ListUtility {

    /**
     * 拆分list,将数据量非常大的list拆分为N个小的list
     *
     * @param list
     * @param splitSize  希望拆分为多少个集合，如果不能被整除，则会拆分为splitSize+1个集合
     * @return
     * @throws Exception
     */
    public  <T> List<List<T>> splitList(List<T> list, int splitSize) {
        int originSize = list.size();
        int remainder = originSize / splitSize;               //取余  子list允许的最大长度
        int mod = originSize % splitSize;                     //取模  如果不能整除，则增加一个集合保存多余的数据
        int resultSize = originSize < splitSize ? 1 : (mod > 0 ? splitSize + 1 : splitSize);
        int resultSubSize = originSize < splitSize ? originSize : remainder;

        List<List<T>> resultList = new ArrayList<>();
        for (int i = 0; i < resultSize; i++) {
            List<T> subList;
            if (i == resultSize - 1) {
                subList = list.subList(i * resultSubSize, originSize);
            } else {
                subList = list.subList(i * resultSubSize, (i+1) * resultSubSize);
            }
            resultList.add(subList);
        }
        return resultList;
    }


    /**
     * 拆分大集合为指定大小的小集合的集合
     * @param list
     * @param subListSize
     * @param <T>
     * @return
     */
    public static  <T> List<List<T>> splitListFixSize(List<T> list, int subListSize) {
        int originSize = list.size();
        int qumo = originSize % subListSize;
        int quyu = originSize / subListSize;
        int size = qumo > 0 ? quyu + 1 : quyu;
        List<List<T>> resultList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<T> subList;
            if (i == size - 1) {
                subList = list.subList(i * subListSize, originSize);
            } else {
                subList = list.subList(i * subListSize, (i+1) * subListSize);
            }
            resultList.add(subList);
        }
        return resultList;
    }

    /**
     * 将一个数随机拆分成n个数
     * @param totalNum
     * @param count
     * @return
     */
    public static List<Integer> random(int totalNum, int count) {
// 创建一个长度的红包数组
        List redList = new ArrayList<>();
//2. 进行随机分配
        Random rand = new Random();
        int leftMoney = totalNum; // 剩余金额
        int leftCount = count; // 剩余份数
// 随机分配公式：1 + rand.nextInt(leftMoney / leftCount * 2);
        for (int i = 0; i < count - 1; i++) {
            int money_ = 0;
            if (leftMoney > 0) {
                if ((leftMoney / leftCount * 2) < 1) {
                    money_ = leftMoney;
                } else {
                    money_ = 1 + rand.nextInt(leftMoney / leftCount * 2);
                }
            } else {
                money_ = 0;
            }
            redList.add(money_);
            if (money_ > 0) {
                leftMoney -= money_;
                leftCount--;
            }
        }
// 把剩余的最后一个放到最后一个包里
        redList.add(leftMoney);
        return redList;
    }

}
