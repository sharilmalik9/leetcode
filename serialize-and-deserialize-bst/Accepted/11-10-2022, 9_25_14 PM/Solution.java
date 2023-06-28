// https://leetcode.com/problems/serialize-and-deserialize-bst

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "#";
        }
        return root.val+"," + serialize(root.left)+","+serialize(root.right);
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data){
        Queue<String> que= new LinkedList<>();
       
        for(int i=0;i<data.length();i++){
            int j=i;
            while(j<data.length() && data.charAt(j)!=','){
                j++;
            }
            que.offer(data.substring(i,j));
            i=j;
            
        }
        return help(que);
        
    }
    public TreeNode help(Queue<String> que){
        String str=que.poll();
        if(str.equals("#")){
            return null;
        }
        TreeNode curr = new TreeNode(Integer.parseInt(str));
        curr.left=help(que);
        curr.right=help(que);
        return curr;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;