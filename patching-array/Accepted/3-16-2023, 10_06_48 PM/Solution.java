// https://leetcode.com/problems/patching-array

 //  Approach -
    //  Ham kya karege ki ek reach variable lenge
    //  Reach hame bataega ki kis number tak ham pohoch sakte he jo hamare pass number he unse
    //  Ham kya krege ki jab tak reach < n tab tak lopp chalaege
    
    //  Agar reach < nums[i] to matlab abhi ham nums[i] tak number generate nahi kar sakte
    //  isliye hame kuch patch add karna hoga, or bo patch reach + 1 hoga kyuki reach tak ke number ham generate kar sakte he
    //  Lekin Reach se Jyada nahi isliye ham reach se ek jyada number ko patch kaarege array me jisse reach increase ho jaegi
    //  reach += reach + 1 se
    
    
    // Or jab reach nums[i] se jyada ho to matlab ham nums[i] se jyada generate kar sakte nums[i] ke bina 
    // or agar nums[i] ko bhi saath le le to reach increase ho jaegi reach + nums[i] kyoki nums[i] ko ham 1 to reach sabke saath
    // add kar sakte he to jisse max reach hamari reach + nums[i] ho jaegi
    
    //Ek case or jab reach nums[i] se ek kam ho tab means (nums[i] == reach + 1) is time ham reach ko nums[i] se increase kar denge
    // kyoki ham nums[i] - 1 tak generate kar sakte agar nums[i] aa jaega to nums[i] + reach ista generate kar paege
    
    // For Ex - 1 5 10
        // reach = 0         nums[i] = 1         nums[i] <= reach + 1    ye last bala case jab nums[i] == reach + 1 to reach me num[i] add karege  == > i++ (jab bhi       nums1 [i] add ho jaega tabhi i++ karege)
        // reach = 1         nums[i] = 5         nums[i] > reach         array me patch karege reach + 1 (1 + 1 = 2) or reach increase karege
        // reach = 3 (1 +2)  nums[i] = 5         nums[i] > reach         array me patch karege reach + 1 (3 + 1 = 4) or reach increase karege
        // reach = 7 (3 +4)  nums[i] = 5         nums[i] <= reach + 1    reach += nums[i]   ==> i++
        // reach = 12(7 +5)  nums[i] = 10         nums[i] <= reach + 1    reach += nums[i]  ==> i++
        // reach = 22 (12+10)  reach > n breack loop return the patch count (we added 2 and 4 so count will be 2)
class Solution {
    public int minPatches(int[] nums, int n) {
        long  reach=0;
        int patch=0;
        int i=0;
        while(reach<n){
            if(i<nums.length && nums[i]<=reach+1){
               
                reach=reach+nums[i];
                 i++;
            }
            else{
                reach=reach+reach+1;
                patch++;
            }
        }
        return patch;
        
    }
}