/***
	There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

	You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

	Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

	Note:
	The solution is guaranteed to be unique.
***/
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length != cost.length || gas.length == 0 || cost.length == 0) return -1;
        int start = 0, end  = gas.length-1, tank = 0;
        
        while(start<=end){
            if(tank + gas[start] >= cost[start]){
                tank += gas[start]-cost[start];
                start++;
            }else{
                tank += gas[end]-cost[end];
                end--;
            }
        }
        
        return (tank >=0)?(start%gas.length):-1;
    }
}