// https://leetcode.com/problems/accounts-merge

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new ArrayList<>();
        if (accounts == null || accounts.size() == 0) {
            return result;
        }
        
        int[] parent = new int[accounts.size()];
        for (int i=0;i<accounts.size(); i++) {
            parent[i] = i; 
        }
        
        // union find
        Map<String, Integer> emailToIdxMap = new HashMap<>();
        for (int i=0; i<accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j=1; j<account.size(); j++) {
                String email = account.get(j);
                if (emailToIdxMap.containsKey(email)) {
                    int givenIdx = emailToIdxMap.get(email);
                    int r1 = find(givenIdx, parent);
                    int r2 = find(i, parent);
                    parent[r2] = r1;
                } else {
                    emailToIdxMap.put(email, i);
                }
            }
        }
        
        // merge accounts   
        Map<Integer, Set<String>> idxToEmailMap = new HashMap<>();
        for (int i=0;i <accounts.size(); i++) {
            for (int j=1; j<accounts.get(i).size(); j++) {
                idxToEmailMap.putIfAbsent(find(i, parent), new TreeSet<>());
                idxToEmailMap.get(find(i, parent)).add(accounts.get(i).get(j));
            }
        }
        
        // convert into required output format
        for (Map.Entry<Integer, Set<String>> entry : idxToEmailMap.entrySet()) {
            List<String> currentAccount = new ArrayList<>();
            currentAccount.add(accounts.get(entry.getKey()).get(0));
            for (String email : entry.getValue()) {
                currentAccount.add(email);
            }
            result.add(currentAccount);
        }
        return result;
    }
    
    private int find(int i, int[] parent) {
        if (parent[i] != i) {
            return find(parent[i], parent);
        }
        return parent[i];
    }
}