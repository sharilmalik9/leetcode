// https://leetcode.com/problems/longest-uploaded-prefix

class LUPrefix {
    int[] v;
    int max = 0;
    
    public LUPrefix(int n) {
        v = new int[n + 1];
    }
    
    public void upload(int video) {
        v[video] = 1;
        if (video - max == 1) {
            max = video++;
            while (video < v.length && v[video] == 1) {
                max = video++;
            }
        }
    }
    
    public int longest() {
        return max;
    }
}