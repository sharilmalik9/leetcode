// https://leetcode.com/problems/median-of-two-sorted-arrays

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = mergeArray(nums1, nums2);
        int sizeOfArray = mergedArray.length;
        int mid = (mergedArray.length - 1) / 2; //Finding the mid index of the array.
        mid = Math.abs(mid); //Index can not be negative.
        double ans = 0.0;
		//If size of array is even.
        if((sizeOfArray & 1) == 0) {
            ans = (double)(mergedArray[mid] + mergedArray[mid + 1]) / 2;
        }else{
            ans = (double)mergedArray[mid];
        }
        
        return ans;
    }
    
	//Function to merge Arrays and return the sorted merged Array.
    public int[] mergeArray(int[] nums1, int[] nums2){
        int[] mArray = new int[nums1.length + nums2.length]; //Delearing temp Array.
        int i = 0;
        int j = 0;
        int k = 0;
		
		//Copying First Array into temp array.
        while(i < nums1.length){
            mArray[k++] = nums1[i++];
        }

		//Copying second array into the temp array.
        while(j < nums2.length){
            mArray[k++] = nums2[j++];

        }
		
		sorting the tempArray.
        Arrays.sort(mArray);
        return mArray;
    }
}