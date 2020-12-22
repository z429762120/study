package com.tool.collect.skytools.leetcode;

import lombok.Data;

/**
 * @Descriiption
 * @Author bo
 * @Date 2020/9/7 上午11:54
 **/
public class leetcodeDemo {
    static TreeNode root1 = null;
    static TreeNode root2 = null;
    static Integer addValue = 0;
    static {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.setLeft(treeNode3);
        treeNode1.setRight(treeNode2);
        treeNode3.setLeft(treeNode5);
        root1 = treeNode1;

        TreeNode treeNode11 = new TreeNode(1);
        TreeNode treeNode22 = new TreeNode(2);
        TreeNode treeNode33 = new TreeNode(3);
        TreeNode treeNode44 = new TreeNode(4);
        TreeNode treeNode77 = new TreeNode(7);
        treeNode22.setLeft(treeNode11);
        treeNode22.setRight(treeNode33);
        treeNode11.setRight(treeNode44);
        treeNode33.setRight(treeNode77);
        root2 = treeNode22;
    }

    public static void main(String[] args) {


        System.out.println(merge(root1,root2));
    }

    private static TreeNode merge(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode mergeNode = new TreeNode(t1.val + t2.val);
        mergeNode.setLeft(merge(t1.getLeft(), t2.getLeft()));
        mergeNode.setRight(merge(t1.getRight(),t2.getLeft()));
        return mergeNode;
    }


    @Data
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }


}
