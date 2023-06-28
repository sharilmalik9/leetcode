// https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<Integer,Integer> nodeToLevel = new HashMap();
    HashMap<Integer,Integer> nodeToDepth = new HashMap();
    HashMap<Integer,PriorityQueue<Integer>> levelToNode = new HashMap();      
    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] answer = new int[queries.length];  
        findDepth(root);
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> nodeToDepth.get(b) - nodeToDepth.get(a));
            while(size-- > 0){
                TreeNode n = queue.poll();
                if(n.left != null)
                    queue.add(n.left);
                if(n.right != null)
                    queue.add(n.right);
                pq.add(n.val);
                nodeToLevel.put(n.val,level);
            }
            levelToNode.put(level,pq);
            level++;
        }

        for(int i=0;i<queries.length;i++){
            int levelOfQuery = nodeToLevel.get(queries[i]);
            PriorityQueue<Integer> pq = levelToNode.get(levelOfQuery);
            if(pq.size() == 1){
                answer[i] = levelOfQuery - 1;
                continue;
            }
            if(pq.peek() == queries[i]){
                pq.poll();
                answer[i] = levelOfQuery + nodeToDepth.get(pq.peek());
                pq.add(queries[i]);          
            }
            else {
                answer[i] = levelOfQuery + nodeToDepth.get(pq.peek());
            }
        }        
        return answer;
    }
    
    public int findDepth(TreeNode node){
        if(node == null)
            return 0;
        int max = Math.max(findDepth(node.left),findDepth(node.right));
        nodeToDepth.put(node.val,max);
        return max+1;
    }
}