package leetcodeProblems;

import org.harald.leetcodeProblems.MedianOfTwoSortedArrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianOfTwoSortedArraysTests {

    MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();

    @Test
    void MedianOfTwoSortedArrays_Successful_odd() {
        int[] num1 = {1, 3};
        int[] num2 = {2};

        double result = medianOfTwoSortedArrays.findMedianSortedArray(num1, num2);

        assertEquals(2.0, result);
    }

    @Test
    void MedianOfTwoSortedArrays_Successful_even() {
        int[] num1 = {1, 2};
        int[] num2 = {3, 4};

        double result = medianOfTwoSortedArrays.findMedianSortedArray(num1, num2);

        assertEquals(2.5, result);
    }

    @Test
    void MedianOfTwoSortedArrays_Successful_odd2() {
        int[] num1 = {1, 3, 5, 9};
        int[] num2 = {2, 5, 8};
 // 1 2 3 5 5 8 9
        double result = medianOfTwoSortedArrays.findMedianSortedArray(num1, num2);

        assertEquals(5.0, result);
    }

    @Test
    void MedianOfTwoSortedArrays_Successful_even2() {
        int[] num1 = {1, 3, 5, 9};
        int[] num2 = {2, 6, 8, 10};
        // 1 2 3 5 6 8 9 10

        double result = medianOfTwoSortedArrays.findMedianSortedArray(num1, num2);

        assertEquals(5.5, result);
    }



}
