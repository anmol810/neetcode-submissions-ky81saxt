class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        int l = 0;
        int ans = 0;

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);

            // If duplicate found → move left pointer
            while (map.containsKey(ch)) {
                map.remove(s.charAt(l));
                l++;
            }

            map.put(ch, 1);
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}