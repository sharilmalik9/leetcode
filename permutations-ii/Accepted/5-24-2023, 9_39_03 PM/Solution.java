// https://leetcode.com/problems/permutations-ii

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> ans = new HashSet<>();
        int len = nums.length;
        if (len == 0) {
            return new ArrayList<>();
        }

        boolean[] vis = new boolean[len];
        backtrack(ans, new ArrayList<>(), nums, vis, 0);
        List<List<Integer>> hehe=new ArrayList<>();
        for(List<Integer> curr:ans){
            hehe.add(curr);
        }
        return hehe;
    }

    public void backtrack(HashSet<List<Integer>> res, List<Integer> list, int[] nums, boolean[] visited, int idx) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
           
            // avoid duplicate
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                backtrack(res, list, nums, visited, idx + 1);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
// class Solution {
//     public List<List<Integer>> permute(int[] letters) {
//         List<List<Integer>> res = new ArrayList<>();
//         dfs(new ArrayList<>(), new boolean[letters.length], res, letters);
//         return res;
//     }

//     private static void dfs(List<Integer> path, boolean[] used, List<List<Integer>> res, int[] letters) {
//         if (path.size() == used.length) {
//             // make a deep copy since otherwise we'd be append the same list over and over
//             res.add(new ArrayList<Integer>(path));
//             return;
//         }

//         for (int i = 0; i < used.length; i++) {
//             // skip used letters
//             if (used[i]) continue;
//             // add letter to permutation, mark letter as used
//             path.add(letters[i]);
//             used[i] = true;
//             dfs(path, used, res, letters);
//             // remove letter from permutation, mark letter as unused
//             path.remove(path.size() - 1);
//             used[i] = false;
//         }
//     }    
// }