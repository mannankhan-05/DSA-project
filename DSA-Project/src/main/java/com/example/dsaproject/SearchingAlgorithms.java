package com.example.dsaproject;

import java.util.LinkedList;

public class SearchingAlgorithms {

    public int linearSearch(LinkedList<Integer> list, int target) {
        // Loop through the LinkedList to find the target value
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == target) {
                return i; // Target found at index i
            }
        }
        return -1; // Not found
    }

    public int binarySearch(LinkedList<Integer> list, int target) {
        // Binary search requires the list to be sorted
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midValue = list.get(mid);

            if (midValue == target) {
                return mid; // Target found at mid
            } else if (midValue < target) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }
        return -1; // Not found
    }
}
