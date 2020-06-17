package com.kishan.java.leetcode.juneChallenges;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

    /**
     * Initialize your data structure here.
     */
    private Map<Integer, Integer> valueMap;
    private Map<Integer, Integer> indexMap;
    private Random random = new Random();

    public RandomizedSet() {
        valueMap = new HashMap<Integer, Integer>();
        indexMap = new HashMap<Integer, Integer>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (valueMap.containsKey(val)) {
            return false;
        }
        valueMap.put(val, valueMap.size());
        indexMap.put(indexMap.size(), val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (valueMap.containsKey(val)) {
            int index = valueMap.get(val);
            valueMap.remove(val);
            indexMap.remove(index);
            Integer tailElem = indexMap.get(indexMap.size());
            if (tailElem != null) {
                indexMap.put(index, tailElem);
                valueMap.put(tailElem, index);
                indexMap.remove(indexMap.size()-1);
            }
            return true;
        }
        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        if (valueMap.size() == 0) {
            return -1;
        }
        if (valueMap.size() == 1) {
            return indexMap.get(0);
        }
        int index = random.nextInt(valueMap.size());
        return indexMap.get(index);
    }
}
