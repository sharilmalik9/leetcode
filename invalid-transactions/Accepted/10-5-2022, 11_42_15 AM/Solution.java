// https://leetcode.com/problems/invalid-transactions

// class Solution {
//     class transaction{
//         String name;
//         int time;
//         int amount;
//         String city;
//         public transaction(String line){
			
//             String[] split = line.split(",");
//             name = split[0];
//             time = Integer.parseInt(split[1]);
//             amount = Integer.parseInt(split[2]);
//             city = split[3];
//         }
//     }
//     public List<String> invalidTransactions(String[] transactions) {
//         List<String> invalid = new ArrayList<>();
//         List<transaction> sep = new ArrayList<>();
//         Map< String, List<transaction>> mp= new HashMap<>();
//         for(String t : transactions){
//             transaction tr= new transaction(t);
//             sep.add(tr);
//             if(mp.containsKey(tr.name)){
//                 mp.get(tr.name).add(tr);
//             }
//             else{
//                 List<transaction> hey= new ArrayList<>();
//                 hey.add(tr);
//                 mp.put(tr.name,hey);
//             }
//         }
//         int idx=0;
//         for(transaction t: sep){
            
//             if(check(t,mp.get(t.name))){
//                 invalid.add(transactions[idx]);
//             }
//             idx++;
// }
        
//         return invalid;
        
        
//     }
//     public boolean check(transaction t1,List<transaction> ls ){
//         System.out.println(ls);
//         if(t1.amount>1000){
//             return true;
//         }
//         for(transaction tt: ls){
//           //  System.out.println(t1.city);
//             if(Math.abs(t1.time - tt.time) <= 60 && !t1.city.equals(tt.city)){
               
//                   //  System.out.println(t1.amount);
//                     return true;
                
                
//             }
//         }
//         return false;
//     }
// }
class Solution {
	// store transaction in an object for ease of handling and cleaner code
    class Transaction{
        String name;
        int time;
        int amount;
        String city;
        public Transaction(String line){
			// split the string and parse it
            String[] split = line.split(",");
            name = split[0];
            time = Integer.parseInt(split[1]);
            amount = Integer.parseInt(split[2]);
            city = split[3];
        }
    }
    public List<String> invalidTransactions(String[] transactions) {
        List<String> invalid = new ArrayList<>();
        Map<String, List<Transaction>> map = new HashMap<>();
		// go through entire transaction list and create object and store in map using 'name' as key
        for(String transaction : transactions){
            Transaction t = new Transaction(transaction);
            map.putIfAbsent(t.name, new ArrayList<>());
            map.get(t.name).add(t);
        }
		// now go through the transaction list again and 
		// compare each transaction to the respective list for that name
        for(String transaction : transactions){
            Transaction t = new Transaction(transaction);
			// if transaction is not valid, add to final result
			// (notice we are passing to the function only the list of transactions for that specific name
			// we only care about transactions for the same name)
            if(!isValid(t, map.getOrDefault(t.name, new ArrayList<>()))){
                invalid.add(transaction);
            }
        }
        return invalid;
    }
    public boolean isValid(Transaction t, List<Transaction> list){
		// if the transaction is greater than 1000, 
		/// we hit the first condition in the description so return the transaction as false
        if(t.amount > 1000){
			return false;
		}
		// go through the list for that name
		// see if the time of the transaction is less than or equal to 60
		// and if the transaction is not in the same city
		// we hit the second condition return the transaction as false
        for(Transaction ta : list){
            if(Math.abs(ta.time - t.time) <= 60 && !ta.city.equals(t.city)){
				return false;
			}
        }
		// if we go through the entire list and we don't hit any condition, then the transaction is true
        return true;
    }
}