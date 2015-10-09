public class Solution {
    
    private int  findSet(int[] set, int i){
        //if the parent is -1, then it means its a self parent => representative of the set
        if(set[i]==-1) return i;
        //path compression
        set[i] = findSet(set, set[i]);
        return set[i];
    }
    
    public boolean validTree(int n, int[][] edges) {
        //create an array to store the parents
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        //loop the edges
        for(int i=0;i<edges.length;i++){
            int u = findSet(parent, edges[i][0]);
            int v = findSet(parent, edges[i][1]);
            if(u==v)return false; //if the parents are same, then there is a cycle
            //create a new parent entry => Union
            parent[v] = u;   
        }
        
        //handle the edge cases eg: 2 nodes with no edges
        return edges.length==n-1;
    }
    
}