/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return node;
        
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        q.add(node);
        
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        map.put(node, new UndirectedGraphNode(node.label));
        
        while(!q.isEmpty()){
            UndirectedGraphNode ud = q.poll();
            for(UndirectedGraphNode neighbor : ud.neighbors){
                if(!map.containsKey(neighbor)){
                  map.put(neighbor, new UndirectedGraphNode(neighbor.label));  
                  q.add(neighbor);
                }
                map.get(ud).neighbors.add(map.get(neighbor));
            }
        }
        
        return map.get(node);
    }
}
