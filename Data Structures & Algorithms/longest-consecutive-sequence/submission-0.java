class Solution {
    public int longestConsecutive(int[] nums) {
        int len = 1;
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        int itr = 0;
        while(itr<nums.length){
           set.add(nums[itr]);
           itr++;
        }
        for(int i =0;i<nums.length;i++){
            int value = nums[i];
            while(set.contains(value-1)){
                len++;
                value-=1;
            }
            ans = Math.max(ans,len);
            len = 1;
        }
        return ans;
    }
}
