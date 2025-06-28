package DP;
import java.util.*;
public class houseRobber2 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        return Math.max(robLinear(nums, 0, n - 2), robLinear(nums, 1, n - 1));
    }
    private int robLinear(int[] nums, int start, int end) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return helper(nums, end, start, memo);
    }
    private int helper(int[] nums, int i, int start, int[] memo) {
        if (i < start) return 0;
        if (memo[i] != -1) return memo[i];

        memo[i] = Math.max(
            helper(nums, i - 1, start, memo),
            nums[i] + helper(nums, i - 2, start, memo)
        );
        return memo[i];
    }
}