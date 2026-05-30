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
        HashSet<Node> visited = new HashSet<>(); 
        s.push(node); 
        while(!s.isEmpty()){
            Node cur = s.pop(); 
            if(!map.containsKey(cur)) map.put(cur,new Node(cur.val));
            visited.add(cur);
            
            for(Node n: cur.neighbors){
                if(!map.containsKey(n)) map.put(n,new Node(n.val));
                if(!visited.contains(n)) s.push(n); 
            }
        }

        s.push(node); 
        visited = new HashSet<>(); 
        while(!s.isEmpty()){
            Node cur = s.pop(); 
            visited.add(cur);
            List<Node> nodes = new ArrayList<>(); 
            for(Node n: cur.neighbors){
                nodes.add(map.get(n)); 
                if(!visited.contains(n)) s.push(n); 
            }
            if(map.containsKey(cur)) map.get(cur).neighbors = nodes; 
        }


        // s.push(nnode);
        // System.out.println("Copy: ");
        // while(!s.isEmpty()){
        //     Node cur = s.pop(); 
        //     visited.add(cur); 
        //     System.out.println("cur: " + cur.val); 
        //     List<Node> nodes = cur.neighbors;
            
        //     for(Node n: nodes){
        //         System.out.println("Neghibour :  " + n.val);  
        //         if(!visited.contains(n)) s.push(n);
        //     }
        // }


        return map.get(node);
    }
}