/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        return cloneNode(node, new HashMap<Integer, Node>());
        
    }
    
    public Node cloneNode(Node node, Map<Integer, Node> map) {
        Node newNode = new Node(node.val);
        map.put(newNode.val, newNode);
        for(Node neighbor: node.neighbors) {
            Node newNeighbor = map.get(neighbor.val);
            if(newNeighbor == null)
                newNeighbor = cloneNode(neighbor, map);
             newNode.neighbors.add(newNeighbor);
        }
        return newNode;
    }
}