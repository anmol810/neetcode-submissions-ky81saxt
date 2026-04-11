class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        int sum = 0;
        hash.put(0,-1);
        for(int i =0; i<nums.length; i++){
            sum+=nums[i];
            int rem = sum%k;
            if(hash.containsKey(rem)){
                if(i-hash.get(rem)>=2){
                    return true;
                }
            }else{
                hash.put(rem,i);
            }
        }
        return false;
    }
}