// https://leetcode.com/problems/odd-even-jump

class Solution {
    public int oddEvenJumps(int[] arr){
        int n=arr.length;
        TreeMap<Integer,Integer> map= new TreeMap<>();
        int[] odd=new int[n];
        int[] even=new int[n];
        for(int i=n-1;i>=0;i--){
           int no = arr[i];
            Map.Entry<Integer, Integer> higher = map.higherEntry(no - 1);
            odd[i] = -1;
            if(higher != null) odd[i] = higher.getValue();
            Map.Entry<Integer, Integer> lower = map.lowerEntry(no + 1);
            even[i] = -1;
            if(lower != null) even[i] = lower.getValue();
            map.put(no, i);
        }
        boolean[] oddo=new boolean[n];
        boolean[] eveno=new boolean[n];
        System.out.println(Arrays.toString(odd));
         System.out.println(Arrays.toString(even));
        oddo[n-1]=true;
        eveno[n-1]=true;
        for(int i=n-2;i>=0;i--){
            if(odd[i]!=-1){
                oddo[i]=eveno[odd[i]];
            }
            if(even[i]!=-1){
                eveno[i]=oddo[even[i]];

            }
        }
        int ans=0;
        for(boolean curr:oddo){
            if(curr){
                ans++;
            }
        }
        return ans;
    }
    // public int[] findodd(int[] arr){
    //     // grater than me 
    //     // and min amoung them 
    //     int[] ans=new int[arr.length];
    //     Arrays.fill(ans,Integer.MAX_VALUE);
    //     for(int i=0;i<arr.length-1;i++){
    //         for(int j=i+1;j<arr.length;j++){
    //             if(arr[i]<=arr[j]){
    //                 if(ans[i]==Integer.MAX_VALUE){
    //                     ans[i]=j;

    //                 }
    //                 else if(arr[ans[i]]>arr[j]){
    //                     ans[i]=j;
    //                 }
                   
    //             }
    //         }
    //     }
    //     for(int i=0;i<arr.length;i++){
    //         if(ans[i]==Integer.MAX_VALUE){
    //             ans[i]=-1;
    //         }
    //     }
    //     return ans;


    // }
    // public int[] findeven(int[] arr){
    //     int[] ans= new int[arr.length];
    //     Arrays.fill(ans,Integer.MIN_VALUE);
    //      for(int i=0;i<arr.length-1;i++){
    //         for(int j=i+1;j<arr.length;j++){
    //             if(arr[i]>=arr[j]){
    //                 if(ans[i]==Integer.MIN_VALUE){
    //                     ans[i]=j;

    //                 }
    //               else if(arr[ans[i]]<arr[j]){
    //                     ans[i]=j;
    //                 }
    //             }
    //         }
    //     }
    //     for(int i=0;i<arr.length;i++){
    //         if(ans[i]==Integer.MIN_VALUE){
    //             ans[i]=-1;
    //         }
    //     }
    //     return ans;

    // }
}