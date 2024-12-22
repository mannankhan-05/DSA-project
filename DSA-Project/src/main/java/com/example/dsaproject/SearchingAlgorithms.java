package com.example.dsaproject;

import java.util.LinkedList;

public class SearchingAlgorithms {
    public int linearSearch(LinkedList<Integer> list, int target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == target) {
                return i; // Target found at index i
            }
        }
        return -1;
    }

    public int binarySearch(LinkedList<Integer> list, int target) {
            int low = 0, high = list.size() - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int midValue = list.get(mid);

                if (midValue == target) {
                    return mid;
                } else if (midValue < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1; // Not found
    }
}
