// https://leetcode.com/problems/course-schedule-ii

class Solution {
   // do topological sorting and check if cycle is there if no cycle then return topo else false
// no of topo != edges
public int[] findOrder(int numCourses, int[][] prerequisites) {
    ArrayList<Integer>[] graph = new ArrayList[numCourses];
    for(int i = 0; i < numCourses; i++) {
        graph[i] = new ArrayList<>();
    }
    for (int[] pre : prerequisites) {
        graph[pre[1]].add(pre[0]);
    }


    boolean[] visited = new boolean[numCourses];
    boolean[] onStack = new boolean[numCourses];

    Deque<Integer> reversePost = new LinkedList<>();

    if (hasCircle(graph, visited, onStack, reversePost)) {
        return new int[0];
    }

    int[] res = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
        res[i] = reversePost.pop();
    }

    return res;


}

private boolean hasCircle(ArrayList<Integer>[] graph, boolean[] visited, boolean[] onStack, Deque<Integer> reversePost) {
    for(int i = 0; i < graph.length; i++) {
        if (!visited[i]) {
            if (dfs(graph, visited, onStack, i, reversePost)) {
                return true;
            }
        }
    }
    return false;
}

private boolean dfs(ArrayList<Integer>[] graph, boolean[] visited, boolean[] onStack, int i, Deque<Integer> reversePost) {
    onStack[i] = true;
    visited[i] = true;
    for (int j : graph[i]) {
        if (!visited[j]) {
            if (dfs(graph, visited, onStack, j, reversePost)) {
                return true;
            }
        } else if (onStack[j]) {
            return true;
        }
    }
    onStack[i] = false;
    reversePost.push(i);
    return false;
}
}