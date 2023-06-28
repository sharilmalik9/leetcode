// https://leetcode.com/problems/invalid-transactions

class Solution {
    class transaction{
        String name;
        int time;
        int amount;
        String city;
        public transaction(String line){
			
            String[] split = line.split(",");
            name = split[0];
            time = Integer.parseInt(split[1]);
            amount = Integer.parseInt(split[2]);
            city = split[3];
        }
    }
    public List<String> invalidTransactions(String[] transactions) {
        List<String> invalid = new ArrayList<>();
        List<transaction> sep = new ArrayList<>();
        Map< String, List<transaction>> mp= new HashMap<>();
        for(String t : transactions){
            transaction tr= new transaction(t);
            sep.add(tr);
            if(mp.containsKey(tr.name)){
                mp.get(tr.name).add(tr);
            }
            else{
                List<transaction> hey= new ArrayList<>();
                hey.add(tr);
                mp.put(tr.name,hey);
            }
        }
        int idx=0;
        for(transaction t: sep){
            
            if(check(t,mp.get(t.name))){
                invalid.add(transactions[idx]);
            }
            idx++;
}
        
        return invalid;
        
        
    }
    public boolean check(transaction t1,List<transaction> ls ){
        if(t1.amount>1000){
            return true;
        }
        for(transaction tt: ls){
            if(Math.abs(t1.time-tt.time)<=60 && t1!=tt){
                if(t1.city!=tt.city){
                    return true;
                }
                
            }
        }
        return false;
    }
}