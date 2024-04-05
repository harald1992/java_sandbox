package org.harald.leetcodeProblems;

// array of integers and integer rarget, return the indices of the two numbers such that they add up to target
// may not use the same element twie.

import java.util.HashMap;
import java.util.Objects;

public class TwoSum {

    /* This is not a efficient one, big O complexity */
    public int[] twoSumSlow(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length;
                 j++) { // if i is 0, compare with 1,2,3. After finishing the loop you don't need to do j=1 anymore, since it is already done.
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /* A lot quicker, big O constant time */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numbersMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer indexOfFittingNumber = numbersMap.get(nums[i]);

            if (!Objects.isNull(indexOfFittingNumber)) {
                return new int[]{indexOfFittingNumber, i};
            } else {
                numbersMap.put(target - nums[i], i); // put <needed accumulation to reach target, index>
            }
        }

        return null;
    }

}


