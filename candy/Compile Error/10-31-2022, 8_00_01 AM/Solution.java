// https://leetcode.com/problems/candy

int n=ratings.length;
        int[] candy=new int[n];
        candy[0]=1;  //base case,as minimum 1 candy is to be given
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]) candy[i]=candy[i-1]+1;   //if left neighbour is smaller
            else candy[i]=1;
        }
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candy[i]=Math.max(candy[i],candy[i+1]+1);   // //if right neighbour is smaller
            }
        }int res=0;
        for(int val:candy) res+=val;
        return res;