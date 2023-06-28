// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> levelNodes = new ArrayList<>();
            while (size-- > 0) {
                TreeNode curr = q.poll();
                if (level % 2 == 0) {
                    levelNodes.add(curr.val);
                } else {
                    levelNodes.add(0, curr.val);
                }
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            level++;
            ans.add(levelNodes);
        }
        return ans;
    }
}