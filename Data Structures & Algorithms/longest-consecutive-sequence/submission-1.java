class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;

        Set<Integer> set = new HashSet<>();
        int itr = 0;

        while (itr < nums.length) {
            set.add(nums[itr]);
            itr++;
        }

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];

            // ✅ ONLY start if it's beginning of sequence
            if (!set.contains(value - 1)) {
                int len = 1;

                // ✅ go forward (not backward)
                while (set.contains(value + 1)) {
                    value += 1;
                    len++;
                }

                ans = Math.max(ans, len);
            }
        }

        return ans;
    }
}