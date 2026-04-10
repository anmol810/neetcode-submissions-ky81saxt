class Solution {
    public int appendCharacters(String s, String t) {
        int step = 0;
        for(int i=0;i<s.length();i++){
            if(step<t.length()&&s.charAt(i)==t.charAt(step))step++;
        }
        return t.length() - step;
    }
}