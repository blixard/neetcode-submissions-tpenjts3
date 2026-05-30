/*
Definition for a Node.
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
        if(node == null) return null;
        Stack <Node> s = new Stack<>(); 
        HashMap<Node, Node> map = new HashMap<>(); 
        map.put(node,new Node(node.val));
        s.push(node); 
        while(!s.isEmpty()){
            Node cur = s.pop(); 
            Node copy = map.get(cur); 
            for(Node n: cur.neighbors){
                if(!map.containsKey(n)) {
                    Node temp = new Node(n.val); 
                    map.put(n,temp); 
                    s.push(n); 
                    copy.neighbors.add(temp); 
                }
                else{
                    copy.neighbors.add(map.get(n)); 
                }
            }
        }
        // for(Node k : map.keySet()){
        //     List<Node> nodes = new ArrayList<>(); 
        //     for(Node n: k.neighbors){
        //         nodes.add(map.get(n)); 
        //     }
        //     if(map.containsKey(k)) map.get(k).neighbors = nodes; 
        // }
        return map.get(node);
    }
}