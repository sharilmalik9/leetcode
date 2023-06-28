// https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage

class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int cntG=0;
        int cntP=0;
        int cntM=0;
        for(int i=0;i<garbage.length;i++){
            for(int j=0;j<garbage[i].length();j++){
                char ch= garbage[i].charAt(j);
                if(ch=='G'){
                    cntG=i;
                }
                if(ch=='P'){
                    cntP=i;
                }
                if(ch=='M'){
                    cntM=i;
                }
}
}
      //  System.out.println(cntG);
        //System.out.println(cntP);
        //System.out.println(cntM);
       
        int timeP=0;
        for(int i=0;i<=cntP;i++){
            if(i!=cntP){
                timeP+=travel[i];
            }
            for(int j=0;j<garbage[i].length();j++){
                char ch= garbage[i].charAt(j);
                if(ch=='P'){
                    timeP+=1;
                }
}
            
        }
        int timeM=0;
        for(int i=0;i<=cntM;i++){
            if(i!=cntM){
                timeM+=travel[i];
            }
            for(int j=0;j<garbage[i].length();j++){
                char ch= garbage[i].charAt(j);
                if(ch=='M'){
                    timeM+=1;
                }
}
            
        }
        int timeG=0;
        for(int i=0;i<=cntG;i++){
            if(i!=cntG){
                timeG+=travel[i];
            }
            for(int j=0;j<garbage[i].length();j++){
                char ch= garbage[i].charAt(j);
                if(ch=='G'){
                    timeG+=1;
                }
}
            
        }
        
        
        
        
        
        
        
        
        
        
        
        System.out.println(timeP);
        return timeP+timeM+timeG;
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}