// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public void makeParent(TreeNode root, HashMap<TreeNode, TreeNode> parent){
        Queue<TreeNode> que= new LinkedList<>();
        que.add(root);
       while(que.size()!=0){
           TreeNode curr= que.poll();
           if(curr.left!=null){
               parent.put(curr.left,curr);
               que.add(curr.left);
           }
           if(curr.right!=null){
                parent.put(curr.right,curr);
               que.add(curr.right);
           }
       }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode ,TreeNode> parent = new HashMap<>();
        makeParent(root,parent);
         Map<TreeNode ,Boolean> visited = new HashMap<>();
        Queue<TreeNode> ansque= new LinkedList<>();
        ansque.add(target);
        int level=0;
        visited.put(target,true);
        while(!ansque.isEmpty()){
            if(level==k) break;
            int size = ansque.size();
            while(size>0){
                 TreeNode curr = ansque.poll();
                if(curr.left!=null && visited.get(curr.left)==null){
                    ansque.add(curr.left);
                    visited.put(curr.left,true);
                }
                 if(curr.right!=null && visited.get(curr.right)==null){
                    ansque.add(curr.right);
                    visited.put(curr.right,true);
                }
                 if(parent.get(curr)!=null && visited.get(parent.get(curr))==null){
                    ansque.add(parent.get(curr));
                    visited.put(parent.get(curr),true);
                }
               
                
                size--;
            }
           level++;
        }
        List<Integer> ans = new ArrayList<>();
        while(ansque.size()>0){
            ans.add(ansque.poll().val);
        }
        return ans;
    }
}