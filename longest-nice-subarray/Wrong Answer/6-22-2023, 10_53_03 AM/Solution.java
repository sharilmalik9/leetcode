// https://leetcode.com/problems/longest-nice-subarray

class Solution {
    int[] parent;
    public int longestNiceSubarray(int[] nums) {
        parent=new int[nums.length];
        int[] xor=new int[33];
        Arrays.fill(xor,-1);
        for(int i=0;i<nums.length;i++){
            parent[i]=i;
        }
        for(int i=0;i<nums.length;i++){
            int numb=nums[i];
            int cnt=0;
            while(numb!=0){
                if((numb&1)==1){
                    if(xor[cnt]==-1){
                        xor[cnt]=i;
                    }
                    else{
                        union(xor[cnt],i);
                        break;
                    }
                }
               numb= numb>>1;
                cnt++;
            }
        }
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<parent.length;i++){
            hs.add(parent[i]);
        }
        return hs.size();
        
    }
    public int parent(int element){
        if(parent[element]==element){
            return element;
        }
        return parent[element]=parent(parent[element]);

    }

    public void union(int one,int two){
        int onep=parent(one);
        int twop=parent(two);
        if(onep==twop){
            return;
        }
        parent[twop]=onep;
    }
}