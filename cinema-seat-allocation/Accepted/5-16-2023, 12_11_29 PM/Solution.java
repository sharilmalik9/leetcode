// https://leetcode.com/problems/cinema-seat-allocation

// class Solution {
//     public int maxNumberOfFamilies(int n, int[][] r) {
//         HashMap<Integer,HashSet<Integer>> hm= new HashMap<>();
//         for(int[] i:r){
//             if(hm.containsKey(i[0])){
//                 hm.get(i[0]).add(i[1]);
//             }
//             else{
//                 HashSet<Integer> hs= new HashSet<>();
//                 hs.add(i[1]);
//                 hm.put(i[0],hs);
//             }
//         }
//         int ans=0;
//         HashSet<Integer> hs;
//         for(int i=1;i<=n;i++){
//             int curr=0;
//             if(!hm.containsKey(i)){
//                 ans+=2;
//                 continue;
//             }
//             hs=hm.get(i);
//           if(!hs.contains(2) && !hs.contains(3)){
//                 if(!hs.contains(4) && !hs.contains(5)){
//                     curr++;
//                 }
//             }
//            if(!hs.contains(8) && !hs.contains(9)){
//                if(!hs.contains(6) && !hs.contains(7)){
//                    curr++;
//                }
//            }
//            if(curr==2 || curr==1){
//                ans+=curr;
//                continue;
//            }
//            if(!hs.contains(4) && !hs.contains(5) && !hs.contains(6) && !hs.contains(7)){
//                ans+=1;
//            } 
//         }
//          return ans; 
//     }
// }
import java.util.*;

class Solution {
  public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int[] seat: reservedSeats) {
      int u = seat[0], v = seat[1];
      map.putIfAbsent(u, new HashSet<>());
      map.get(u).add(v);
    }
    int ret = 2 * (n - map.size());
    for (Map.Entry<Integer, Set<Integer>> entry: map.entrySet()) {
      Set<Integer> set = entry.getValue();
      // Split the seat into 4 segments
      // 1 2 3 | 4 5 6 7 | 8 9 10
      //   ___   ___ ___   ___
      // seat 2, 3: left segment
      // seat 4, 5: left-middle segment
      // seat 6, 7: middle-right segment
      // seat 8, 9: right segment
      boolean l = true, lm = true, mr = true, r = true;
      if (set.contains(2) || set.contains(3)) {
        l = false;
      }
      if (set.contains(4) || set.contains(5)) {
        lm = false;
      }
      if (set.contains(6) || set.contains(7)) {
        mr = false;
      }
      if (set.contains(8) || set.contains(9)) {
        r = false;
      }
      // If middle segments are empty
      if (lm && mr) {
        // If left and right segments are empty, ret += 2 'cause we split people across the aisle
        if (l && r) {
          ret += 2;
        // exactly 1, no matter what 
        } else {
          ret += 1;
        }
      } else if ((mr && r) || (lm && l)) { // now we know that the middle segments aren't empty, check the cross-aisle-equal-split scenario
        ret += 1;
      }
    }
    return ret;
  }
}