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
        Map<Integer, Node> map = new HashMap<Integer, Node>();
        if(node == null)
            return null;
        return cloneNode(node, map);
        
    }
    
    public Node cloneNode(Node node, Map<Integer, Node> map) {
        Node newNode = new Node();
        newNode.val = node.val;
        map.put(newNode.val, newNode);
        for(Node neighbor: node.neighbors) {
            if(map.containsKey(neighbor.val))
                newNode.neighbors.add(map.get(neighbor.val));
            else
                newNode.neighbors.add(cloneNode(neighbor, map));
        }
        return newNode;
    }
}