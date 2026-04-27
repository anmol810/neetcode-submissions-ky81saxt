class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        List<int[]> ans = new ArrayList<>();
        list.add(newInterval);
        list.sort((a,b)->a[0]-b[0]);
        int[] start = list.get(0);
        for(int i=1;i<list.size();i++){
            if(start[1]>=list.get(i)[0]){
                start[1] = Math.max(start[1],list.get(i)[1]);
            }else{
                ans.add(start);
                start = list.get(i);
            }
        }
        ans.add(start);
        return ans.toArray(new int[ans.size()][]);
    }
}
