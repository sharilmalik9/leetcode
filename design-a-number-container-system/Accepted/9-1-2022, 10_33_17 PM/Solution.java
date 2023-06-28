// https://leetcode.com/problems/design-a-number-container-system

class NumberContainers {
   Map<Integer,Integer> container ;
    public NumberContainers() {
        container=new TreeMap<>();
    }
    
    public void change(int index, int number) {
        container.put(index,number);
    }
    
    public int find(int number) {
        if(container.containsValue(number)) {
         for(int p:container.keySet()){
             if(container.get(p)==number) return p;
         }
        }
        return -1;
    }
}
/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */