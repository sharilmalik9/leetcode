// https://leetcode.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance

class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> list= new ArrayList<>();
        List<Integer> filteredIds= new ArrayList<>();

        for(int[] restaurant: restaurants){
            if(veganFriendly==1){
            if(restaurant[2]==1&&restaurant[3]<=maxPrice&&restaurant[4]<=maxDistance)list.add(restaurant);
            }else{
                if(restaurant[3]<=maxPrice&&restaurant[4]<=maxDistance)list.add(restaurant);
            }
        }

        Collections.sort(list,(a,b)->{
            return (a[1]!=b[1])?(b[1]-a[1]):b[0]-a[0];
        });

for(int [] restaurant:list)
    filteredIds.add(restaurant[0]);
return filteredIds;

    }
}