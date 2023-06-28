// https://leetcode.com/problems/populating-next-right-pointers-in-each-node

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
     public List<Node> returnlevel(Node root,int level,List<Node> ans1){
        if(root== null){
            return null;
        }
       // List<Integer> ans1= new ArrayList<Integer>();
        if(level==1){
          //  System.out.println(root.val);
            ans1.add(root);
          //  System.out.println(ans1);
            
        }
         returnlevel(root.left,level-1,ans1);
        returnlevel(root.right,level-1,ans1);
       
       
        return ans1;
    }
    
    public int height(Node root){
        if(root==null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }
    public Node connect(Node root) {
       
        for(int i=1;i<height(root)+1;i++){
             List<Node> ans1=new ArrayList<Node>();
             returnlevel(root,i,ans1);
            System.out.println( returnlevel(root,i,ans1));
            for(int j=0;j<ans1.size()-1;j++){
                ans1.get(j).next=ans1.get(j+1); 
                
            }
            ans1.get(ans1.size()-1).next=null; 
         }
        
        return root;
       
        
    }
}