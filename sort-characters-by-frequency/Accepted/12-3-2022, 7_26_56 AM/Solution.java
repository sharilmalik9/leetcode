// https://leetcode.com/problems/sort-characters-by-frequency

class Solution {
	public String frequencySort(String s) {
		Map<Character,Integer> map= new HashMap<>();
		for(char c: s.toCharArray())
		{
			map.put(c,map.getOrDefault(c,0)+1);
		}

		PriorityQueue<Map.Entry<Character,Integer>> pq= new PriorityQueue<>(
		(a,b)-> b.getValue()-a.getValue());

		for(Map.Entry<Character,Integer> entry: map.entrySet())
		{
			pq.offer(entry);
		}

		StringBuilder sb=new StringBuilder();
		while(!pq.isEmpty())
		{
			int n=pq.peek().getValue();
			while(n-->0)
			{
				sb.append(pq.peek().getKey());
			}
			pq.remove();
		}

		return sb.toString();
	}
}