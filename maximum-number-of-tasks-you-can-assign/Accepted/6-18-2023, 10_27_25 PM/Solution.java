// https://leetcode.com/problems/maximum-number-of-tasks-you-can-assign

class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        TreeMap<Integer,Integer> tm=new TreeMap<>();
         for (int i : workers)
        	tm.put(i, tm.getOrDefault(i, 0) + 1);
        int start=0;
        int end=Math.min(workers.length,tasks.length)-1;
        int ans=0;
        while(start<=end){
            int mid=start+(end-start)/2;
         
            if(check(tasks,pills,strength,(TreeMap<Integer, Integer>)tm.clone(),mid)){
                ans=mid+1;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans;
    }
    public boolean check(int[] arr,int pills,int strength,TreeMap<Integer,Integer> tm,int mid){
        while(mid>=0){
            int max=tm.lastKey();
            int t=arr[mid]; 
            if((pills>0 && strength+max<t )||(pills==0 && max<t)){
                return false;
            }
            if(max<t){
                t-=strength;
                pills--;
            }
            int got=tm.ceilingKey(t);
            if(tm.get(got)>1){
                tm.put(got,tm.get(got)-1);
            }
            else{
                tm.remove(got);
            }
            mid--;
        }
        return true;
    }
}