// https://leetcode.com/problems/image-overlap

class Solution {
    class pair{
        int i;
        int j;
         int hashCode;
        pair(int i,int j ){
            this.i=i;
            this.j=j;
            this.hashCode = Objects.hash(i, j);
        }
        
          public int hashCode() {
        return this.hashCode;
    }
         public boolean equals(Object o) {
        pair that = (pair) o;
        return i == that.i && j == that.j;
    }
    }
    public int largestOverlap(int[][] img1, int[][] img2) {
        ArrayList<pair> im1=new ArrayList<>();
        ArrayList<pair> im2=new ArrayList<>();
        for(int i=0;i<img1.length;i++){
            for(int j=0;j<img1[0].length;j++){
                if(img1[i][j]==1){
                    im1.add(new pair(i,j));
                }
                if(img2[i][j]==1){
                    im2.add(new pair(i,j));
                }  
            }
        }
        int ans=0;
        HashMap<pair,Integer> hm= new HashMap<>();
        
        for(int i=0;i<im1.size();i++){
            pair curr=im1.get(i);
            for(int j=0;j<im2.size();j++){
                pair now=im2.get(j);
                pair pp= new pair(now.i-curr.i,now.j-curr.j);
                hm.put(pp,hm.getOrDefault(pp,0)+1);
                ans=Math.max(ans,hm.get(pp));
                
            }
        }
        
        return ans;
    }
}