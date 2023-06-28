// https://leetcode.com/problems/task-scheduler

class Solution {
    public int leastInterval(char[] tasks, int k) {
       int[] arr=new int[26];
        for(int i=0;i<tasks.length;i++){
            arr[tasks[i]-'A']+=1;
        }
        List<Integer> ls=new ArrayList<>();
        for(int i:arr){
            if(i>0){
                ls.add(i);
            }
        }
        Collections.sort(ls,Collections.reverseOrder());
        int rem=(ls.get(0)-1)*k;
        int ans=0;
        ans+=rem;
        int spaces=ls.get(0)-1;
        ans+=spaces+1;
        int extra=0;
        boolean change=false;
        for(int i=1;i<ls.size();i++){
            int ele=ls.get(i);
            if(ele<=spaces){
                if(rem>=ele){
                    rem-=ele;
                    continue;
                }
                else{
                    spaces=ele-rem-1;
                    rem=(ele-rem-1)*k;
                    change=true;
                    ans+=rem+spaces+1;
                }
            }
            else{
               if(rem<spaces){
                   change=true;
                  spaces=ele-rem-1;
                  rem=(ele-rem-1)*k;
                  ans+=rem+spaces+1;
                   
               }
               else{
                   rem-=spaces;
                   change=false;
                   extra+=ele-spaces;
               }
            }
            
           
            
        }
        if(extra>rem && change){
            ans+=extra-rem;
        }
        else{
            ans+=extra;
        }
      
        
        
        
        return ans;
    }
}