// https://leetcode.com/problems/determine-if-two-strings-are-close

class Solution {
	public boolean closeStrings(String word1, String word2) {
        if(word1==word2){
            return true;
        }
		HashMap<Character, Integer> map1 = new HashMap<>();
		for (int i = 0; i < word1.length(); i++) {
			map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0) + 1);
		}

		HashMap<Character, Integer> map2 = new HashMap<>();
		for (int i = 0; i < word2.length(); i++) {
			map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0) + 1);
		}
		if (!map1.keySet().equals(map2.keySet())) {
			return false;
		}
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.addAll(map1.values());

		ArrayList<Integer> list2 = new ArrayList<>();
		list2.addAll(map2.values());

		Collections.sort(list1);
		Collections.sort(list2);


		if (list1.size() != list2.size()) {
			return false;
		}
		int i = 0;
		int j = 0;
		while (i < list1.size() && j < list2.size()) {
			if (list1.get(i) !=list2.get(j)) {
                // System.out.println(list1.get(i)+" "+list2.get(i));
				return false;
			} else {
				i++;
				j++;
			}
		}
		return true;
	}
}