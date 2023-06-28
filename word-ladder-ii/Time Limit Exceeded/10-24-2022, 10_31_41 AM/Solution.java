// https://leetcode.com/problems/word-ladder-ii

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        var res = new ArrayList<List<String>>();
                
        var words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return res;
        }
        
        var queue = new ArrayDeque<List<String>>();
        queue.push(Arrays.asList(beginWord));
        
        var usedInPreviousLevels = new HashSet<String>();
        usedInPreviousLevels.add(beginWord);
        
        var lastLevel = false;
        while (!queue.isEmpty() && !lastLevel) {
            var levelSize = queue.size();
            
            var usedInCurrentLevel = new HashSet<String>();
            for (int lvl = 0; lvl < levelSize; lvl++) {
                var path = queue.poll();
                var node = path.get(path.size() - 1);
                
                if (node.equals(endWord)) {
                    res.add(path);
                    lastLevel = true;
                }
                
                if (!lastLevel) {
                    var chars = node.toCharArray();
                    for (int i = 0; i < chars.length; i++) {
                        var oldChar = chars[i];
                        for (char l = 'a'; l <= 'z'; l++) {
                            chars[i] = l;
                            var str = new String(chars);
                            if (words.contains(str) && !usedInPreviousLevels.contains(str)) {
                                var newPath = new ArrayList(path);
                                newPath.add(str);
                                queue.add(newPath);
                                usedInCurrentLevel.add(str);
                            }
                        }
                        chars[i] = oldChar;
                    }
                }
            }
            usedInPreviousLevels.addAll(usedInCurrentLevel);
        }
        
        return res;
    }
}