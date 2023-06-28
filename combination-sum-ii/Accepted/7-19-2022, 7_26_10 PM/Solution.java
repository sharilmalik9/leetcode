// https://leetcode.com/problems/combination-sum-ii

class Solution {
    List<List<Integer>> list = new ArrayList<>() ;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates) ;
        func(candidates,target,new ArrayList<>(),0,false) ;
        return list ;
    }
    public void func(int[] a , int target , List<Integer> rlist , int index , boolean tprev){
	//variable 'tprev' is true when we have considered the previous number , false otherwise
        if(target==0){
            list.add(new ArrayList<>(rlist)) ;
            return ;
        }
        else if(index>=a.length || target<0){
            return ;
        }
        else{
            //for each number (i.e. a[index] ) we make two decisions : either we take it in our combination or we don't
			
			//move to the next index without considering the current number (hence tprev is false for next recursion call
            func(a,target,rlist,index+1,false) ;//not taking the current number
            
            //if the previous number is equal to the current one and we had decided to discard it , dont choose current number
            if(index>0 && a[index]==a[index-1] && !tprev)return ;
            
            //else take the number 
            rlist.add(a[index]) ;
            func(a,target-a[index],rlist,index+1,true) ;
            rlist.remove(rlist.size()-1) ;
            
        }
    }
}