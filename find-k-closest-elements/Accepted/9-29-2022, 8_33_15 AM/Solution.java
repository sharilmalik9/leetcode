// https://leetcode.com/problems/find-k-closest-elements

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // in this question we need to find k closest element
        //therefore we will use hashmap and priority queue in this question
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++)
        {
            hm.put(arr[i], Math.abs(x - arr[i]));
        }
        PriorityQueue<Integer> ab = new PriorityQueue<>((a,b) -> hm.get(a) == hm.get(b) ? (a - b) : (hm.get(a) - hm.get(b)));
         
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
        {
            ab.add(arr[i]);
        }
        while (!ab.isEmpty() && k != 0)
        {
            list.add(ab.remove());
            k--;
        }
        Collections.sort(list);
        return list;
    }
}