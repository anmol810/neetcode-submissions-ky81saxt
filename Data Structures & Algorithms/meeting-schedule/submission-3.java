/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals==null) return false;
        if(intervals.size()==0) return true;
        intervals.sort((a,b)->a.start-b.start);
        Interval temp = intervals.get(0);
        for(int i=1; i<intervals.size(); i++){
            if(intervals.get(i).start<temp.end) return false;
            temp = intervals.get(i);
        }
        return true;
    }
}
