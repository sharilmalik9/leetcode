// https://leetcode.com/problems/minimum-genetic-mutation

class Solution {
    public int minMutation(String start, String end, String[] bank){
        HashSet<String> st= new HashSet<>();
        for(String i :bank){
            st.add(i);
            
        }
        if(!st.contains(end)){
            return -1;
        }
        int level=0;
        Queue<String> que=new LinkedList<>();
        que.add(start);
        while(que.size()!=0){
            int size=que.size();
            while(size!=0){
                String curr=que.poll();
               
                for(int j=0;j<curr.length();j++){
                 char[] c = curr.toCharArray();
                    for(char x = 'A'; x <= 'T'; x++){
                        if(x!='A' && x!='C' && x!='G' && x!='T'){
                            continue;
                          }
                        c[j] = x;
                        String temp = new String(c);
                         System.out.println(temp);
                        if(temp.equals(end)){
                            return level+1;
                        }
                        if(st.contains(temp)){
                            
                            que.add(temp);
                            st.remove(temp);
                          }
                    }
            }
                size--;
            }
                level++;
        }
            return -1;
    }
}