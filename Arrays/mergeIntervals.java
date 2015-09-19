/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    
     
    private static Interval merger(Interval i, Interval interval){
        return new Interval(i.start,Math.max(i.end, interval.end));
    }
    
    public static List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1) return intervals;
        List<Interval> list = new ArrayList<>();
        
        Collections.sort(intervals, new Comparator<Interval>(){
                public int compare(Interval i1, Interval i2){
                    return i1.start - i2.start;
                }
        });
        
        list.add(intervals.get(0)); 
        Interval previous = intervals.get(0);
        for(int i =1;i<intervals.size();i++){
            Boolean flag = (previous.end >= intervals.get(i).start);
            if(flag){
                list.set(list.size()-1,merger(previous, intervals.get(i)));    
            }else{
                list.add(intervals.get(i));
            }
            
            previous = list.get(list.size()-1);
        }
        return list;
    }
}