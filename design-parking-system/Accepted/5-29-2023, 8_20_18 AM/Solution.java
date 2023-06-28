// https://leetcode.com/problems/design-parking-system

class ParkingSystem {
    int one;
    int two;
    int three;


    public ParkingSystem(int big, int medium, int small) {
        one=big;
        two=medium;
        three=small;
    }
    
    public boolean addCar(int carType) {
        if(carType==1){
            if(one==0){
                return false;
            }
            one--;
            

        }
        else if(carType==2){
            if(two==0){
                return false;
            }
            two--;

            
        }
        else{
            if(three==0){
                return false;
            }
            three--;

        }
        return true;
        
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */