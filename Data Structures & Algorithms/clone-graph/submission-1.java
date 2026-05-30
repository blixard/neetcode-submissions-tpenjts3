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
        Node nnode = new Node(10); 
        int count =0; 
        while(!s.isEmpty()){
            Node cur = s.pop(); 
            visited.add(cur); 
            //System.out.println("cur: " + cur.val + " " + map); 
            List<Node> nodes = cur.neighbors;
            ArrayList<Node> reNodes = new ArrayList<>(); 
            
            for(Node n: nodes){
                Node temp = new Node(n.val);
                //System.out.println(n + " "+ n.val +" "+ temp); 
                if(map.containsKey(n)){
                    temp = map.get(n); 
                }
                else{
                    map.put(n, temp); 
                }
                //System.out.println("Neghibour :  " + n.val );  
                if(!visited.contains(n)) s.push(n); 
                reNodes.add(temp); 
            }

            Node re = new Node(cur.val, reNodes); 
           
            if(map.containsKey(cur)){
                Node temp = re; 
                re = map.get(cur);
                re.neighbors = temp.neighbors;
            }
            else{
                map.put(cur, re); 
            }

            //System.out.println("for : " + re + "(" + cur+ ")"  + " with val " + re.val + " Added these in new neghibours: " + re.neighbors); 

            if(cur == node) nnode = re; 
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


        return nnode;
    }
}