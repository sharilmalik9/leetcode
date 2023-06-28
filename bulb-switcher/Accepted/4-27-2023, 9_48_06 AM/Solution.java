// https://leetcode.com/problems/bulb-switcher

// class Solution {
//     public int bulbSwitch(int n) {
//         boolean[] fac=new boolean[n];
//         Arrays.fill(fac,true);
//         for(int i=2;i<=n;i++){
//             int idx=1;
//             while(idx*i<=n){
//                 fac[idx*i-1]=!fac[idx*i-1];
//                 idx++;
//             }
//         }
//          int ans=0;
//          for(boolean i:fac){
//              if(i==true){
//                  ans++;
//              }
//          }
//         return ans;
        
//     }
// }
class Solution {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}