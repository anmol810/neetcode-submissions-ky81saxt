
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        // t ka frequency
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> window = new HashMap<>();

        int l = 0;
        int count = t.length(); // kitne chars abhi bhi chahiye

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);

            // add in window
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            // useful char mila
            if (need.containsKey(ch) && window.get(ch) <= need.get(ch)) {
                count--;
            }

            // jab sab mil gaya
            while (count == 0) {
                // answer update
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }

                char leftChar = s.charAt(l);

                // remove from window
                window.put(leftChar, window.get(leftChar) - 1);

                if (need.containsKey(leftChar) &&
                    window.get(leftChar) < need.get(leftChar)) {
                    count++;
                }

                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}