// https://leetcode.com/problems/watering-plants

class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int count=0;
        int copy=capacity;
        for(int i=0;i<plants.length;i++){
            if(plants[i]<=capacity){
                count++;
            }
            else{
                count+=((i-0)+(i+1));
                capacity=copy;
            }
            capacity=capacity-plants[i];
        }
        return count;
        
    }
}