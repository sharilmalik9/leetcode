// https://leetcode.com/problems/determine-if-two-strings-are-close

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1==word2){
            return true;
}
        HashMap<Character,Integer> hp1= new HashMap<>();
        HashMap<Character,Integer> hp2= new HashMap<>();
        for(int i=0;i<word1.length();i++){
            char s= word1.charAt(i);
            hp1.put(s,hp1.getOrDefault(s,0)+1);
}
        for(int i=0;i<word2.length();i++){
            char s= word2.charAt(i);
            hp2.put(s,hp2.getOrDefault(s,0)+1);
}
       if (!hp1.keySet().equals(hp2.keySet())) {
			return false;
		}
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.addAll(hp1.values());

		ArrayList<Integer> list2 = new ArrayList<>();
		list2.addAll(hp2.values());

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