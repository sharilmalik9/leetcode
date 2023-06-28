// https://leetcode.com/problems/exam-room

class ExamRoom {
    int[] seats;
    public ExamRoom(int n){
        seats=new int[n];
    }
    public int seat(){
       
        int idx=maxDistToClosest();
        this.seats[idx]=1;
      //  System.out.println(idx);
       //  System.out.println(Arrays.toString(seats));
        return idx;
        
    }
    public void leave(int p) {
        seats[p]=0;
    }
    public int maxDistToClosest() {
       
        int idx=0;
        int ansidx=0;
        int ans=0;
        
        while(idx<seats.length){
            if(seats[idx]==0){
                int right=idx;
                int cnt=0;
                while(right<seats.length && seats[right]==0){
                    
                    right++;
                    cnt++;
                }
                if(idx==0 || right == seats.length){
                    if(cnt>ans && idx==0){
                        ansidx=0;
                    }
                    else if(cnt>ans ){
                        ansidx=seats.length-1;

                    }
                    ans=Math.max(ans,cnt);

                }
                else{
                    if(cnt%2!=0){
                        if(cnt/2+1>ans){
                            ansidx=idx-1+cnt/2+1;
                        }
                         ans=Math.max(ans,cnt/2+1);

                    }
                    else{
                        if(cnt/2>ans){
                            ansidx=idx-1+cnt/2;
                        }
                        ans=Math.max(ans,cnt/2);
                    }
                   
                }
                idx=right+1;

            }
            else{
                idx++;
            }
        }
         

        return ansidx;

    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */