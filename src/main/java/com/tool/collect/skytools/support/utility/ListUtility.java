package com.tool.collect.skytools.support.utility;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

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
}
