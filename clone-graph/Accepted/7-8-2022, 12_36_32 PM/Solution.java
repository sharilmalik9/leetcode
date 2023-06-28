// https://leetcode.com/problems/clone-graph

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
        if(node == null)    return null;
        HashMap<Node, Node> map = new HashMap<>();
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(node);
        Node head = new Node(node.val);
        map.put(node, head);
        while(q.size() > 0){
            Node rem = q.remove();
            if(map.containsKey(rem) == false){
                Node newnode = new Node(rem.val);
                map.put(rem, newnode);
            }
            List<Node> ngbrs = rem.neighbors;
            Node n1 = map.get(rem);
            for(Node ngbr : ngbrs){
                if(map.containsKey(ngbr) == false){
                    Node n2 = new Node(ngbr.val);
                    map.put(ngbr, n2);
                    q.add(ngbr);
                }
                Node n2 = map.get(ngbr);
                n1.neighbors.add(n2);
            }
        }
        return head;
    }
}