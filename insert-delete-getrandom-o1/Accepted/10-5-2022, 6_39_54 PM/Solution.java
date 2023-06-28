// https://leetcode.com/problems/insert-delete-getrandom-o1

class RandomizedSet {

//Arraylist for storing element
ArrayList<Integer> list;

//In hashmap
//Key - storing element
//value -  index of element present in arraylist
HashMap<Integer,Integer> map;

//for return random element
Random r;

public RandomizedSet() {
    list=new ArrayList<>();
    map=new HashMap<>();
    r=new Random();
}

public boolean insert(int val) {
    
    if(map.containsKey(val)){return false;}
    
    //if map not contains element then we will add in hashmap
    //key as a val
    // value as a index of this val in arraylist
    map.put(val,list.size());
    
    //add it in arraylist
    list.add(val);
    
    return true;
}

public boolean remove(int val) {
    
    if(!map.containsKey(val)){ return false;}
    
        //getting last element
        int last=list.get(list.size()-1);
        
        //in hashmap we have stored index of the val that is we are getting
        int index=map.get(val);
        
        //now override the given value index with last element
        list.set(index,last);
        
        //And update the index of last element in hashmap
        map.put(last,index);
        
        //remove the given value from hashmap 
        map.remove(val);
        
        //And remove the last element from list bcz we replaced it for given value
        
        list.remove(list.size()-1); 
        
        return true;
    
}

public int getRandom() {
    
   
    //return the random element from this list size
    return list.get(r.nextInt(list.size()));
}
}