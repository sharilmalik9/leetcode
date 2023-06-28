// https://leetcode.com/problems/random-pick-with-weight

class Solution {
    int[] weigths;

    public Solution(int[] w) {
        this.weigths = new int[w.length];
        int sum = 0;
        for(int i=0; i< w.length; i++){
            sum += w[i];
            this.weigths[i] = sum;
        }
    }
    public int pickIndex() {
        int random = ((int) (this.weigths[this.weigths.length-1] * Math.random()));
        int s = 0;
        int e = this.weigths.length-1;
        int result = -1;

        while(s<=e){
            int p = (s+(e-s)/2);
            if(random < this.weigths[p]){
                result = p;
                e = p-1;
            }else s = p+1;
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */