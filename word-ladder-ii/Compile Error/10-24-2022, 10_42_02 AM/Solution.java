// https://leetcode.com/problems/word-ladder-ii

class Solution {
  public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
    if(wordList.contains(beginWord)) wordList.remove(beginWord);
    List<List<String>> result = new ArrayList<>();
    List<String> subResult = new ArrayList<>();
    wordList.add(endWord);
    WordLadderNode root = new WordLadderNode(0, beginWord, new ArrayList<>());
    int[] min = new int[]{wordList.size()};
    buildTreeBFS(beginWord, endWord, root, wordList, min);
    searchPathDFS(root, endWord, subResult, result, min);
    return result;
}

public void buildTreeBFS(String beginWord, String endWord,
                         WordLadderNode root, Set<String> wordList, int[] min) {
    Set<String> visited = new HashSet<>();
    visited.add(beginWord);
    Queue<WordLadderNode> queue = new LinkedList<>();
    queue.offer(root);

    while(!queue.isEmpty()) {
        Queue<WordLadderNode> nextQueue = new LinkedList<>();
        Set<String> tempVisited = new HashSet<>();
        while(!queue.isEmpty()) {
            WordLadderNode currNode = queue.poll();
            int index = currNode.index;
            for(String neighbor: getNext(currNode.name, endWord, wordList)) {
                if(endWord.equals(neighbor)) {
                    if(index+1 <= min[0]) {
                        WordLadderNode temp = new WordLadderNode(index+1, neighbor, null);
                        currNode.next.add(temp);
                        min[0] = index+1;
                    }
                    continue;
                }

                if(!visited.contains(neighbor)) {
                    tempVisited.add(neighbor);
                    WordLadderNode temp = new WordLadderNode(index+1, neighbor, new ArrayList<>());
                    nextQueue.offer(temp);
                    currNode.next.add(temp);
                }
            }
        }
        visited.addAll(tempVisited);
        queue = nextQueue;
    }
}

public List<String> getNext(String word, String endWord, Set<String> wordList) {
    List<String> result = new ArrayList<>();
    char[] wordArray = word.toCharArray();
    for(int i=0; i<wordArray.length; i++) {
        char old = wordArray[i];
        for(char c='a'; c<='z'; c++) {
            if(c == old) continue;
            wordArray[i] = c;
            String temp = new String(wordArray);
            if(wordList.contains(temp)) {
                if(endWord.equals(temp)) result.add(0, temp);
                else result.add(temp);
            }
        }
        wordArray[i] = old;
    }
    return result;
}

public void searchPathDFS(WordLadderNode root, String endWord,
                          List<String> subResult, List<List<String>> result, int[] min) {
    if(root == null) return;
    subResult.add(root.name);
    if(endWord.equals(root.name)) {
        if(root.index <= min[0]) result.add(subResult);
        return;
    }
    for(WordLadderNode nextRoot: root.next) {
        searchPathDFS(nextRoot, endWord, new ArrayList<>(subResult), result, min);
    }
}


class WordLadderNode {
    public int index;
    public String name;
    public List<WordLadderNode> next;
    public WordLadderNode(int index, String name, List<WordLadderNode> next) {
        this.index = index;
        this.name = name;
        this.next = next;
    }
}
}