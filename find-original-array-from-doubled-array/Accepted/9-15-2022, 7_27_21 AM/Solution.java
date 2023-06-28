// https://leetcode.com/problems/find-original-array-from-doubled-array

class Solution {
    public int[] findOriginalArray(int[] changed) {
		//if length of array is odd it can't be doubled array
        if(changed.length%2==1)
            return new int[0];
        
        int n = changed.length/2;
        int[] result = new int[n];
		// sort the array because we want to check if double of element exists from smaller to greater
        Arrays.sort(changed);
        
		// HashMap because we want to keep track of considered element 
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int c : changed){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        int index = 0;
        for(int i : changed){
            int doubled = i*2;
			// i=0 have the same doubled value so handled explicitly
            if(i==0 && map.getOrDefault(i,0)>1){
                result[index++] = i;
                map.put(i,map.get(doubled)-2);
            }
			// check if element and doubled both exists in remaining element
            else if(i!=0 && map.get(i)>0 && map.getOrDefault(doubled,0)>0){
                result[index++] = i;
                map.put(doubled,map.get(doubled)-1);
                map.put(i,map.get(i)-1);
            }
        }
        
		// n is half the length of input array and if index is same then it is doubled array
        if(index==n)
            return result;
        
        return new int[0];
    }
}