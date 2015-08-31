//https://www.dropbox.com/s/q3oax2ox1fmxpm3/Screenshot%202015-08-09%2021.10.51.png?dl=0
public class Solution {
    
    static enum State {STARTED, FINISHED};
    State[] states = null;
    
    //form an adjacency List<List> from the course prerequisite edge list
    private static List<List<Integer>> formAdjacencyList(int nodes, int [][] edgelist){
        List<List<Integer>> list = new ArrayList<>(nodes);
        
        for(int i=0;i<nodes;i++){
            list.add(null);
        }
        
        for(int i=0;i<edgelist.length;i++){
            int course = edgelist[i][0];
            int req = edgelist[i][1];
            if(list.get(course) == null){
                List l = new ArrayList<Integer>();
                l.add(req);
                list.set(course, l);
            }else{
                list.get(course).add(req);                
            }
        }
        return list;
    }
    
    public  boolean isLooped(int course, List<List<Integer>> adjList){
        //this indicates that the course has already been checked for loop existency. All the Pre Reqs for this course has no           
		//Loop, thus this course can be completed
        if(states[course] == State.FINISHED) return false; 
        
        //this indicates that the course has already started in a loop traversal, so this is a LOOP!
        if(states[course] == State.STARTED) return true;
        
        //Set the course to Start Mode...
        states[course] = State.STARTED;
        
        //no dependency for this course, so mark it as All Ok!
        if(adjList.get(course) == null) {
            states[course] = State.FINISHED;
            return false;
        }
        
        //Loop over the prerequisites for this course
        for(int i=0;i<adjList.get(course).size();i++){
            //recur over the prerequisites
            boolean b = isLooped(adjList.get(course).get(i), adjList);
            if(b) return b; //return true as a loop exists!
        }
        
        //this means that all the prerequsites can be completed, so which means that this course can be completed
        states[course] = State.FINISHED;
        
        //returning false as no loop exists!
        return false;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //form the adjacency list
        List<List<Integer>> adjList = formAdjacencyList(numCourses, prerequisites);
        
        // form the state Array based on the Enum
        states = new State[numCourses];
        
        //loop over all courses
        for(int i = 0;i< numCourses;i++){
            //if even one course cannot be completed, then break!
            if(isLooped(i, adjList)) return false;
        }
        
        //all the above courses can be completed, thus return true!
        return true;
    }
}