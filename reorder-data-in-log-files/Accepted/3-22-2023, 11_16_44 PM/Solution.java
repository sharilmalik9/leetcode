// https://leetcode.com/problems/reorder-data-in-log-files

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        int n = logs.length;
        
		// we will store letter-logs so that we can sort them independently
        List<String> letterLogs = new ArrayList<>();
        List<String> result = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            if(!isDigitLogs(logs[i])){
                letterLogs.add(logs[i]);
            }
        }
        
		// Here we are sorting 
        Collections.sort(letterLogs,(s1,s2)->{
            String exceptFirstWord_ofS1 = s1.split(" ", 2)[1];  // only content of sentence will be there
            String exceptFirstWord_ofS2 = s2.split(" ", 2)[1];  // only content of sentence will be there
            
			// if the content is same then we are using full word to sort else the content alone
            return exceptFirstWord_ofS1.equals(exceptFirstWord_ofS2)?s1.compareTo(s2):exceptFirstWord_ofS1.compareTo(exceptFirstWord_ofS2);
        });
        
		// lets add the letter logs first
        for(String letterLog : letterLogs){
            result.add(letterLog);
        }
        
		// lets add digit logs 
        for(int i=0;i<n;i++){
            if(isDigitLogs(logs[i])){
                result.add(logs[i]);
            }
        }
        
        return result.toArray(new String[0]);
    }
    
	// return true if it is digit log
    public boolean isDigitLogs(String s){
        String secondWord = s.split(" ")[1];
        if(secondWord.charAt(0)>='0' && secondWord.charAt(0)<='9')
            return true;
        return false;
    }
}