// https://leetcode.com/problems/permutation-sequence

class Solution {
    int cnt ;
    StringBuilder s;
    boolean[] visited;
    int n;
    public String getPermutation(int n, int k) {
        this.n = n;
        cnt = k;
        s = new StringBuilder();
        visited = new boolean[n+1];
        return f(0);
    }
    public String f(int idx){
        if(idx == n){
            cnt--;
            if(cnt == 0){
                return s.toString();
            }
            return "";
        }
        for(int i = 1; i<=n; i++){
            if(!visited[i]){
                visited[i] = true;
                s.append(i+"");
                String curr = f(idx+1);
                s.delete(s.length()-1, s.length());
                visited[i] = false;
                if(curr.length()!=0){
                    return curr;
                }
            }
        }
        return "";  
    }
}