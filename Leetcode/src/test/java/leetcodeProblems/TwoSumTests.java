package leetcodeProblems;

import org.harald.leetcodeProblems.TwoSum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoSumTests {

    TwoSum twoSum = new TwoSum();

    @Test
    public void successFull_1() {
        int[] nums = {2, 7, 11, 15};
        var target = 9;

        int[] result = twoSum.twoSum(nums, target);
        int total = nums[result[0]] + nums[result[1]];

        assertEquals(target, total);
    }

    @Test
    public void successFull_2() {
        int[] nums = {5, 2, 4};
        var target = 6;

        int[] result = twoSum.twoSum(nums, target);
        int total = nums[result[0]] + nums[result[1]];

        assertEquals(target, total);
    }


}
