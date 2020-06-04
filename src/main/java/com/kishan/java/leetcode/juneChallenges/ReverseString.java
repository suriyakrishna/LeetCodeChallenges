package com.kishan.java.leetcode.juneChallenges;

/*
 * Two pointer approach
 *
 * */

import java.util.Arrays;

public class ReverseString {
    public static void reverseString(char[] array) {
        int head = 0;
        int tail = array.length - 1;
        while (head < tail) {
            char temp = array[head];
            array[head++] = array[tail];
            array[tail--] = temp;
        }
    }

    public static void main(String[] args) {
        char example1[] = {'h', 'e', 'l', 'l', 'o'};
        String result1 = "olleh";
        System.out.println("Test 1");
        System.out.println("Before: " + Arrays.toString(example1).replace("[", "").replace("]", "").replace(", ", ""));
        reverseString(example1);
        System.out.println("After: " + Arrays.toString(example1).replace("[", "").replace("]", "").replace(", ", ""));
        System.out.println("Result: " + result1.equals(Arrays.toString(example1).replace("[", "").replace("]", "").replace(", ", "")));

        char example2[] = {'H', 'a', 'n', 'n', 'a', 'h'};
        String result2 = "hannaH";
        System.out.println("Test 2");
        System.out.println("Before: " + Arrays.toString(example2).replace("[", "").replace("]", "").replace(", ", ""));
        reverseString(example2);
        System.out.println("After: " + Arrays.toString(example2).replace("[", "").replace("]", "").replace(", ", ""));
        System.out.println("Result: " + result2.equals(Arrays.toString(example2).replace("[", "").replace("]", "").replace(", ", "")));
    }
}
