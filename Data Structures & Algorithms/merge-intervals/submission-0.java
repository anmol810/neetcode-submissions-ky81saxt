
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] start = intervals[0];
        List<int[]> ans = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            if (start[1] >= intervals[i][0]) {
                start[1] = Math.max(start[1], intervals[i][1]);
            } else {
                ans.add(start);
                start = intervals[i];
            }
        }

        ans.add(start);

        return ans.toArray(new int[ans.size()][]);
    }
}