/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    private HashMap<UndirectedGraphNode, UndirectedGraphNode> helper(UndirectedGraphNode ud, HashMap<UndirectedGraphNode, UndirectedGraphNode> map, Queue<UndirectedGraphNode> q){
        if(q.isEmpty() && !map.containsKey(ud)){
            q.add(ud);
            map.put(ud, new UndirectedGraphNode(ud.label));
        }
        
        if(!q.isEmpty()){
            UndirectedGraphNode u = q.poll();
            for(UndirectedGraphNode neighbor: u.neighbors){
                map = helper(neighbor, map, q);
                map.get(u).neighbors.add(map.get(neighbor));
            }
        }
        
        return map;
    }
    
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return node;
        
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        return helper(node, map, q).get(node);
    }
}
