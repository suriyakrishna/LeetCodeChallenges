package com.kishan.java.leetcode.juneChallenges;

import sun.reflect.generics.tree.Tree;

public class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int value) {
        this();
        this.value = value;
    }

    public TreeNode(int value, TreeNode left) {
        this(value);
        this.left = left;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this(value, left);
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }
}
