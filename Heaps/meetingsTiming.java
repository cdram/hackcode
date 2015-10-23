/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

/***
	Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

	For example,
	Given [[0, 30],[5, 10],[15, 20]],
	return 2.
***/
public class Solution {
    
    
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length == 0) return 0;
        if(intervals.length == 1) return 1;
        
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                    return (i1.start-i2.start);
                }});

		//just keep pushing the end times of the meetings. The goal is if the, new incoming
		//meeting starts at the same time of an ending meeting or is greater than the already 
		//ended meeting, we pop the already ended meeting and push this new meeting's ending 
		//time. If not, just push the new meeting's ending time.
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();       
        q.add(intervals[0].end);

        for(int i=1;i<intervals.length;i++){
            if(intervals[i].start >= q.peek()){
                q.poll();
            }
            q.add(intervals[i].end);
        }
        
        return q.size();
        
    }
}