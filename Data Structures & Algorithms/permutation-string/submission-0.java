class Solution {
     public boolean checkInclusion(String s1, String s2) {
    int[] count = new int[26];

    // Step 1: store freq of s1
    for (char c : s1.toCharArray()) {
        count[c - 'a']++;
    }

    int k = s1.length();

    for (int i = 0; i < s2.length(); i++) {
        // include new char
        count[s2.charAt(i) - 'a']--;

        // remove old char if window exceeds
        if (i >= k) {
            count[s2.charAt(i - k) - 'a']++;
        }

        // check match
        if (allZero(count)) return true;
    }

    return false;
}

private boolean allZero(int[] count) {
    for (int x : count) {
        if (x != 0) return false;
    }
    return true;
}

}
