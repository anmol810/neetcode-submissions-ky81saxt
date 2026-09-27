class Solution {
    int[] dp;

    public int solve(int[] nums, int start) {
        if (start >= nums.length) return 0;

        if (dp[start] != -1) return dp[start];

        dp[start] = Math.max(
            solve(nums, start + 1),
            nums[start] + solve(nums, start + 2)
        );

        return dp[start];
    }

    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return solve(nums, 0);
    }
}