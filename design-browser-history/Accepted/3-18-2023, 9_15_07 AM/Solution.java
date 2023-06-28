// https://leetcode.com/problems/design-browser-history

class BrowserHistory {
    int curridx;
    List<String> ls;

    public BrowserHistory(String homepage) {
        ls=new ArrayList<>();
        ls.add(homepage);
        curridx=0;
        
    }
    
    public void visit(String url){
        while(ls.size()-1!=curridx){
            ls.remove(ls.size()-1);
        }
        ls.add(url);
        curridx=ls.size()-1;

    }
    
    public String back(int steps){
        if(curridx-steps>=0){
              curridx=curridx-steps;
            return ls.get(curridx);
          
        }
        curridx=0;
        return ls.get(0);
        
    }
    
    public String forward(int steps) {
        if(curridx+steps<ls.size()){
            curridx+=steps;
            return ls.get(curridx);
        }
        curridx=ls.size()-1;
        return ls.get(ls.size()-1);
        
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */