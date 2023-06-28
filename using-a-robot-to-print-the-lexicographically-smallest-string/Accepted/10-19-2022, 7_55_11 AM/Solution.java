// https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string

class Solution {
	/*The function sufficeMin is mainly used to retreive the minimum characters index towards the right of the string
	It stores the minimum characters index towards its right in it. */
    public int[] sufficeMin(String s) {
        int n = s.length();
        int[] arr = new int[n];
        arr[n-1] = n-1;
        for(int i=n-2; i>=0; i--) {
            if(s.charAt(i) <= s.charAt(arr[i+1])) arr[i] = i;
            else arr[i] = arr[i+1];
        }
        return arr;
    }
	/*The fucntion checks if the two either of the two condition is satsfied, if it is the character is appended to the finalans.*/
    public String robotWithString(String s) {
        Stack<Character> t = new Stack<>();
        int strlen = s.length(), index = 1;
        StringBuilder finalstr = new StringBuilder();
        int[] sufficemin = sufficeMin(s);
        t.push(s.charAt(0));
        while(index < strlen) {
            int minInd = sufficemin[index];
            if(!t.isEmpty() && (t.peek() <= s.charAt(minInd))) {
                finalstr.append(t.pop());
                continue;
            
            }else if(s.charAt(index) <= s.charAt(minInd)){
                finalstr.append(s.charAt(index));
                index++;   
            }
            else  {
                while(index < minInd) {
                    t.push(s.charAt(index));
                    index++;
                }
            }
        }
        
        while(!t.isEmpty()) {
            finalstr.append(t.pop());
        }
        return finalstr.toString();
    }
}