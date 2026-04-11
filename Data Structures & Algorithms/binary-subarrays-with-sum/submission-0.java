class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        int sum = 0;
        int ans = 0;
        hash.put(0,1);
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            if(hash.containsKey(sum-goal)){
                ans+=hash.get(sum-goal);
            }
            hash.put(sum,hash.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}