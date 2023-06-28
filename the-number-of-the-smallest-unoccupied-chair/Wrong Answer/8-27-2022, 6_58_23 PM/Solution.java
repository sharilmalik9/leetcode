// https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair

class Solution {
    class pair{
        boolean arrival;
        int index;
        int time;
        pair(boolean arrival,int index,int time){
            this.arrival=arrival;
                this.index=index;
            this.time=time;
}
    }
    
    public int smallestChair(int[][] times, int targetFriend) {
        PriorityQueue<pair> pq= new PriorityQueue<>((a,b)->a.time-b.time);
        for(int i=0;i<times.length;i++){
            pair pp= new pair(true,i,times[i][0]);
            pair pp1= new pair(false,i,times[i][1]);
            pq.add(pp);
            pq.add(pp1);  
            
}
        HashMap<Integer,Integer> hp= new HashMap<>();
        PriorityQueue<Integer> left= new PriorityQueue<>();
        int[] arr= new int[times.length];
        int end=0;
        int empty=0;
        while(pq.size()!=0){
            pair curr= pq.poll();
            if(pq.peek().time!=curr.time){
                
            
            if(curr.arrival){
                if(left.size()!=0){
                    empty=left.poll();
                    arr[empty]=curr.index;
                    hp.put(curr.index,empty);
                    if(curr.index==targetFriend){
                        return empty;
                    }
                              
                    
          }
                else{
                    arr[end]=curr.index;
                    hp.put(curr.index,end);
                     if(curr.index==targetFriend){
                           return end;
                     }
                    end++;
                    
                }        
         }
            else{
               int hey= hp.get(curr.index);
                System.out.println(hey);
                hp.remove(curr.index);
               left.add(hey);
               
                
            }
            }
            else{
                pair next = pq.poll(); 
                if(!curr.arrival){
                      int hey= hp.get(curr.index);
                System.out.println(hey);
                hp.remove(curr.index);
               left.add(hey);
                    if(left.size()!=0){
                    empty=left.poll();
                    arr[empty]=next.index;
                    hp.put(next.index,empty);
                    if(next.index==targetFriend){
                        return empty;
                    }
                              
                    
          }
                else{
                    arr[end]=next.index;
                    hp.put(next.index,end);
                     if(next.index==targetFriend){
                           return end;
                     }
                    end++;
                    
                }        
                    
                    
                    
                }
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                else{
                    int hey= hp.get(next.index);
                System.out.println(hey);
                hp.remove(next.index);
               left.add(hey);
                    if(left.size()!=0){
                    empty=left.poll();
                    arr[empty]=curr.index;
                    hp.put(curr.index,empty);
                    if(curr.index==targetFriend){
                        return empty;
                    }
                              
                    
          }
                else{
                    arr[end]=curr.index;
                    hp.put(curr.index,end);
                     if(curr.index==targetFriend){
                           return end;
                     }
                    end++;
                    
                }        
                    
                    
                    
                    
                }
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
            }
            
            
        }
       return -1 ; 
    }
}