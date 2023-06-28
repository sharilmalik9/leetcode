// https://leetcode.com/problems/online-stock-span

class StockSpanner {
    List<Integer> ans;
    List<Integer> ls;
    Stack<Integer> st;

    public StockSpanner(){
        ans= new ArrayList<>();
        ls= new ArrayList<>();
        st= new Stack<>();
        
    }
    
    public int next(int price) {
        while(st.size()!=0 && ls.get(st.peek())<=price){
            st.pop();
        }
        if(st.size()==0){
            ans.add(1+ls.size());
        }
        else{
            ans.add(ls.size()-st.peek());
        }
          ls.add(price);
        st.push(ls.size()-1);
       
        return ans.get(ans.size()-1);
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */