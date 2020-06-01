package com.kishan.java.leetcode.juneChallenges;

import com.kishan.java.leetcode.juneChallenges.TreeNode;

public class InvertTree {

    public static TreeNode invertTree(TreeNode treeNode) {
        if (treeNode == null) {
            return treeNode;
        }
        TreeNode tree = swapTree(treeNode);
        tree.setLeft(invertTree(tree.getLeft()));
        tree.setRight(invertTree(tree.getRight()));
        return tree;
    }

    public static TreeNode swapTree(TreeNode tree) {
        TreeNode temp = tree.getLeft();
        TreeNode left = tree.getRight();
        TreeNode right = temp;
        tree.setRight(right);
        tree.setLeft(left);
        return tree;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));

        System.out.println("Before Inverting");
        System.out.println("root: " + treeNode.getValue());
        System.out.println("root.left: " + treeNode.getLeft().getValue());
        System.out.println("root.left.left: " + treeNode.getLeft().getLeft().getValue());
        System.out.println("root.left.right: " + treeNode.getLeft().getRight().getValue());
        System.out.println("root.right: " + treeNode.getRight().getValue());
        System.out.println("root.right.left: " + treeNode.getRight().getLeft().getValue());
        System.out.println("root.right.right: " + treeNode.getRight().getRight().getValue());

        invertTree(treeNode);

        System.out.println("\nAfter Inverting");
        System.out.println("root: " + treeNode.getValue());
        System.out.println("root.left: " + treeNode.getLeft().getValue());
        System.out.println("root.left.left " + treeNode.getLeft().getLeft().getValue());
        System.out.println("root.left.right " + treeNode.getLeft().getRight().getValue());
        System.out.println("root.right " + treeNode.getRight().getValue());
        System.out.println("root.right.left: " + treeNode.getRight().getLeft().getValue());
        System.out.println("root.right.right: " + treeNode.getRight().getRight().getValue());


        TreeNode swap = new TreeNode(4, new TreeNode(1), new TreeNode(3));

        System.out.println("\nBefore Swapping");
        System.out.println("root: " + swap.getValue());
        System.out.println("left: " + swap.getLeft().getValue());
        System.out.println("right: " + swap.getRight().getValue());

        System.out.println("\nAfter Swapping");

        swapTree(swap);
        System.out.println("root: " + swap.getValue());
        System.out.println("left: " + swap.getLeft().getValue());
        System.out.println("right: " + swap.getRight().getValue());

    }
}
