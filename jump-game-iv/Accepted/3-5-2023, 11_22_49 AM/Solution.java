// https://leetcode.com/problems/jump-game-iv

// class Solution {
//     public int minJumps(int[] arr){
//         HashMap<Integer,List<Integer>> hm= new HashMap<>();
//         for(int i=0;i<arr.length;i++){
//             if(hm.containsKey(arr[i])){
//                 hm.get(arr[i]).add(i);
//             }
//            else{
//                List<Integer> ls= new ArrayList<>();
//                ls.add(i);
//                hm.put(arr[i],ls);
//            }
//         }
//         List<List<Integer>> graph= new ArrayList<>();
//         for(int i=0;i<arr.length;i++){
//             List<Integer> adj= new ArrayList<>();
//             List<Integer> curr= hm.get(arr[i]);
//             for(int j=0;j<curr.size();j++){
//                   if(curr.get(j)!=i-1 && curr.get(j)!=i+1 && curr.get(j)!=i){
//                       adj.add(curr.get(j));
//                   }

//             }
//             if(i!=0){
//                 adj.add(i-1);
//             }
//             if(i!=arr.length-1){
//                 adj.add(i+1);
//             }
           
//             graph.add(adj);
//         } 
//         Queue<Integer> que= new LinkedList<>();
//         que.add(0);
//         int ans=0;
//         boolean[] vis= new boolean[arr.length];
//         vis[0]=true;
//         while(que.size()!=0){
//             int size=que.size();
//             ans++;
//             while(size!=0){
//                 int curr=que.poll();
//                 for(int i: graph.get(curr)){
//                     if(i==arr.length-1){
//                         return ans;
//                     }
//                     if(!vis[i]){
//                         que.add(i);
//                         vis[i]=true;
//                     }
//                 }
//                 size--;
//             }

//         }

//         return 0;       
//     }
// }



class Solution {
    public int minJumps(int[] arr) {
        int steps=0;
        int  n=arr.length;
        HashMap<Integer,List<Integer>> hm=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!hm.containsKey(arr[i])){
                List<Integer> temp =new ArrayList<>();
                temp.add(i);
                hm.put(arr[i],temp);
            }
            else{
                List<Integer> temp=hm.get(arr[i]);
                temp.add(i);
                hm.put(arr[i],temp);
            }
        }
        boolean vis[]=new boolean[n];
        vis[0]=true;
        Queue<Integer> qu=new LinkedList<>();
        qu.add(0);
        while(!qu.isEmpty()){
            int size=qu.size();
            for(int i=0;i<size;i++){
                int curridx=qu.poll();
                if(curridx==n-1)
                    return steps;
                List<Integer> jumptoindexes=hm.get(arr[curridx]);
                jumptoindexes.add(curridx+1);
                jumptoindexes.add(curridx-1);
                for(int q:jumptoindexes){
                    if(q>=0 && q<n && !vis[q]){
                        vis[q]=true;
                        qu.add(q);
                    }
                }
                jumptoindexes.clear();
            }
            steps++;
        }
        return -1;
    }
}