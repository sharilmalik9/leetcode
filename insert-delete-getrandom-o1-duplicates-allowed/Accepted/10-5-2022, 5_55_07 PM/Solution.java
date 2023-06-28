// https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed

// class RandomizedCollection {
//     HashMap<Integer,Integer> hm;

//     public RandomizedCollection() {
//         hm=new HashMap<>();
        
//     }
    
//     public boolean insert(int val) {
//         if(hm.containsKey(val)){
//             hm.put(val,hm.get(val)+1);
//             return false;
//         }
//         else{
//             hm.put(val,1);
//             return true;
//         }
        
//     }
    
//     public boolean remove(int val){
//         if(hm.containsKey(val)){
//             hm.put(val,hm.get(val)-1);
//             if(hm.get(val)==0){
//                 hm.remove(val);
//             }
//             return true;
//         }
//         else{
//             return false;
//         }
        
        
//     }
//     public int getRandom() {
//         List<Integer> ls= new ArrayList<>();
//         for(Map.Entry<Integer,Integer> set:hm.entrySet()){
//             for(int i=0;i<set.getValue();i++){
//                 ls.add(set.getKey());
//             }
//         }
//         Random random= new Random();
//         return ls.get(random.nextInt(ls.size()));
        
        
//     }
// }

// /**
//  * Your RandomizedCollection object will be instantiated and called as such:
//  * RandomizedCollection obj = new RandomizedCollection();
//  * boolean param_1 = obj.insert(val);
//  * boolean param_2 = obj.remove(val);
//  * int param_3 = obj.getRandom();
//  */
class RandomizedCollection {

java.util.Random random = new java.util.Random();
HashMap<Integer, Integer> map;
ArrayList<Integer> list;

public RandomizedCollection() {
    map = new HashMap();
    list = new ArrayList<>();
}

public boolean insert(int val) {
    list.add(val);
    if(!map.containsKey(val)){
        map.put(val, 1);
        return true;
    }
    else{
        map.put(val, map.get(val) + 1);
        return false;
    }
}

public boolean remove(int val) {
  
    if(!map.containsKey(val)){
        return false;
    }
    else{
        int idx = list.indexOf(val);
        list.remove(idx);
        
        if(map.get(val) == 1){
            map.remove(val);
        }
        else{
            map.put(val, map.get(val) - 1);
        }
        return true;
    }
    
}

public int getRandom() {
    return list.get(random.nextInt(list.size()));
}
}