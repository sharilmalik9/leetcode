// https://leetcode.com/problems/move-pieces-to-obtain-a-string

class Solution {
    public boolean canChange(String start, String target) {
        int ptr1=0;
        int ptr2=0;
        int n = target.length();

        while(ptr1 <= n && ptr2 <= n){
            while(ptr1 < n && start.charAt(ptr1) == '_') ptr1++;
            while(ptr2 < n && target.charAt(ptr2) == '_') ptr2++;

            if(ptr1 == n ||ptr2 == n){
                return ptr1 == n && ptr2 == n;
            }

            if(target.charAt(ptr2) != start.charAt(ptr1)) return false;

            if(start.charAt(ptr1) == 'L'){
                if(ptr2 > ptr1) return false;

            }

            if(start.charAt(ptr1) == 'R'){
                if(ptr2 < ptr1) return false;
            }
            ptr1++;
            ptr2++;
        }

        return ptr1 == n && ptr2 == n;
    }
}