class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        List<int[]> events = new ArrayList<>();
        int count = 0, max = 0;
        for(Interval interval : intervals){
            events.add(new int[]{interval.start,1});
            events.add(new int[]{interval.end,-1});
        }
        Collections.sort(events, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        for (int[] e : events) {
            count += e[1];
            max = Math.max(max, count);
        }
        return max;
    }
}
