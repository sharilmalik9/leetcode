// https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid

// class Solution {
//     public boolean canBeValid(String s, String locked) {
//         if(s.length()%2!=0){
//             return false;
//         }
//         int lock=0;
//         Stack<Character> st=new Stack<>();
//         for(int i=0;i<s.length();i++){
//             if(locked.charAt(i)=='0'){
//                 lock++;
//             }
//             else{
//                 if(s.charAt(i)=='('){
//                     lock++;
//                 }
//                 else{

//                         lock--;
//                 }
//             }
//         }
    //     if(lock<0){
    //         return false;
    //     }
    //     st=new Stack<>();
    //    int  idx=s.length()-1;
    //     lock=0;
    //     while(idx>=0){
    //         if(locked.charAt(idx)=='0'){
    //             lock++;
    //         }
    //         else{
    //             if(s.charAt(idx)==')'){
    //                 lock++;
    //             }
    //             else{
    //                     lock--;
    //             }
    //         }
    //         idx--;
    //     }
    //     if(lock<0){
    //         return false;
    //     }
//         return true;
//     }
// }
class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) return false;
        
        int possibleOpens = 0;
        int fixedCloses = 0;
        
        for (int i = 0; i < n; i ++) {
            if ( locked.charAt(i) == '0') {
                possibleOpens++;
            } else {
                if(s.charAt(i)=='('){
                    possibleOpens++;
                }
                else{
                     possibleOpens--;

                }

            }
            
            if (possibleOpens<0) return false;
        }
        
        int possibleCloses = 0;
        int fixedOpens = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')' || locked.charAt(i) == '0') {
                possibleCloses++;
            } else {
                possibleCloses--;
            }
            
            if (possibleCloses<0) return false;
        }
        
        return true;
    }
}