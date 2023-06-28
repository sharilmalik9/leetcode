// https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period

class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        HashMap<String,List<String>> hm= new HashMap<>();
        for(int i=0;i<keyName.length;i++){
            if(hm.containsKey(keyName[i])){
                hm.get(keyName[i]).add(keyTime[i].substring(0,2)+keyTime[i].substring(3,5));
            }
            else{
                List<String> curr=new ArrayList<>();
                curr.add(keyTime[i].substring(0,2)+keyTime[i].substring(3,5));
                hm.put(keyName[i],curr);
            }
        }
        List<String> ans=new ArrayList<>();
        for(String s:hm.keySet()){
            Collections.sort(hm.get(s));
            if(check(hm.get(s))){
                ans.add(s);
            }

        }
        Collections.sort(ans);
        return ans; 
    }
    public boolean check(List<String> ls){
        if(ls.size()==1){
            return false;
        }
        //System.out.println(ls);
        String start=ls.get(0);
        int cnt=1;
        int idx=0;
        for(int i=0;i<ls.size()-1;i++){
            
            start=ls.get(i);
            cnt=1;
            idx=i+1;
            while(idx<ls.size()&& (Integer.parseInt(ls.get(idx))-Integer.parseInt(start)<=100)){
                idx++;
                cnt++;
                if(cnt==3){
                    return true;
                }
            }

        }
        return false;
    }
}