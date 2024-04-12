package org.harald.leetcodeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
Given 2 sorted arrays nums1 and num2 of size m and n, return the median (center number) of the 2 sorted arrays.
The time complexity should be O(log (m+n).

Example 1:
Input: nums1 = [1,3] nums2 = [2] -> Output = 2.00000
(Merged array  [1,2,3] and median is 2).

Example 2:
[1,2] & [3,4] -> 2.5
*/
public class MedianOfTwoSortedArrays {

    // solution using arrays:
    public double findMedianSortedArray(int[] nums1, int[] nums2) {
        int totalArrayLength = nums1.length + nums2.length;
        int[] combinedArray = new int[totalArrayLength];

        int i = 0;
        int j = 0;

        // Check if already > half of the combinedArray, if so you dont need to continue merging, since you only need the one of two middle ones for the median.
        while (i < nums1.length && j < nums2.length && i+j < 0.5* totalArrayLength + 1 ) {

            if (nums1[i] <= nums2[j]) {
                combinedArray[i + j] = nums1[i];
                i++;
            } else {
                combinedArray[i + j] = nums2[j];
                j++;
            }
        }

        while (i + j < 0.5 * totalArrayLength + 1) {


            // remaining
            while (i < nums1.length) {
                combinedArray[i + j] = nums1[i];
                i++;
            }

            while (j < nums2.length) {
                combinedArray[i + j] = nums2[j];
                j++;
            }
        }

        System.out.println("i= " + i + " j= " + j);
        // combinedArray = Arrays.stream(combinedArray).sorted().toArray();

        System.out.println(Arrays.toString(combinedArray));

        if (totalArrayLength % 2 == 0) {
            // even number, so get two middle ones and average.
            double first = combinedArray[totalArrayLength / 2 - 1];
            double second = combinedArray[totalArrayLength / 2];
            return (first + second) / 2;
        } else {
            return combinedArray[(totalArrayLength - 1) / 2];
        }


    }


    // easy solution with arrayLists
    public double findMedianSortedArray_Arraylists(int[] nums1, int[] nums2) {
        ArrayList<Integer> merged = new ArrayList<>();
        for (int num : nums1) {
            merged.add(num);
        }
        for (int num : nums2) {
            merged.add(num);
        }

        merged.sort(Comparator.comparingInt(n -> n));

        if (merged.size() % 2 == 0) {
            // even number, so get two middle ones and average?
            double first = (double) merged.get(merged.size() / 2 - 1);
            double second = (double) merged.get(merged.size() / 2);
            return (first + second) / 2;
        } else {
            return (double) merged.get((merged.size() - 1) / 2);
        }
    }

}
