class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        int ans = 0;
        hash.put(0,1);
        int sum = 0;
        for(int i =0;i<nums.length;i++){
            sum+=nums[i];
            if(hash.containsKey(sum-k)){
                int value = hash.get(sum-k);
                ans+=value;
            }
            hash.put(sum, hash.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}