// https://leetcode.com/problems/word-ladder-ii

class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> words){
    Map<String, List<List<String>>> dictStart = new HashMap<String, List<List<String>>>();
    Map<String, List<List<String>>> dictEnd = new HashMap<String, List<List<String>>>();
    dictStart.put(start, new ArrayList<List<String>>());
    dictEnd.put(end, new ArrayList<List<String>>());
    dictStart.get(start).add(new ArrayList<String>());
    dictEnd.get(end).add(new ArrayList<String>());
    dictStart.get(start).get(0).add(start); dictEnd.get(end).get(0).add(end);
    words.remove(start); words.remove(end);
    List<List<String>> resultList = new ArrayList<List<String>>();
    while(dictStart.size() != 0 && dictEnd.size() != 0){
        Map<String, List<List<String>>> newDict = new HashMap<String, List<List<String>>>();
        Map<String, List<List<String>>> tmpDict1, tmpDict2;
        Set<String> visited = new HashSet<String>();
        tmpDict1 = dictEnd; tmpDict2 = dictStart;
        if(dictStart.size() < dictEnd.size()) { tmpDict1 = dictStart; tmpDict2 = dictEnd; }
        boolean getResults = false;
        for(Map.Entry<String, List<List<String>>> kv : tmpDict1.entrySet()){
            StringBuilder sb = new StringBuilder(kv.getKey());
            for(int i = 0; i < sb.length(); i++){
                char ch = sb.charAt(i);
                for(char rep = 'a'; rep <= 'z'; rep++){
                    if(rep == ch) continue;
                    sb.setCharAt(i, rep);
                    String newStr = sb.toString();
                    if(tmpDict2.containsKey(newStr)){
                        List<List<String>> list1 = tmpDict2.get(newStr), list2 = kv.getValue();
                        for(int j = 0; j < list1.size(); j++)
                            for(int k = 0; k < list2.size(); k++){
                                List<String> result = new ArrayList<String>(list1.get(j));
                                for(int l = list2.get(k).size() - 1; l >= 0; l--)
                                    result.add(list2.get(k).get(l));
                                if(result.get(0) != start) Collections.reverse(result);
                                resultList.add(result);
                            }
                        getResults = true;
                    }
                    else if(words.contains(newStr) && !getResults){
                        if(!visited.contains(newStr)) visited.add(newStr);
                        if(!newDict.containsKey(newStr)) newDict.put(newStr, new ArrayList<List<String>>());
                        for(List<String> list : kv.getValue()){
                            newDict.get(newStr).add(new ArrayList<String>(list));
                            newDict.get(newStr).get(newDict.get(newStr).size() - 1).add(newStr);
                        }
                    }
                }
                sb.setCharAt(i, ch);
            }
        }
        if(getResults) break;
        words.removeAll(visited);
        if(tmpDict1 == dictStart) dictStart = newDict;
        else dictEnd = newDict;
    }
    return resultList;
}
}