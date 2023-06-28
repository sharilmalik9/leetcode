// https://leetcode.com/problems/greatest-common-divisor-traversal

class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

}

class Solution {
    ArrayList<Integer> primes;
    public void primeFactors(int n)
    {
        HashSet<Integer> hs = new HashSet<>();
        while (n%2==0)
        {
            hs.add(2);
            n /= 2;
        }
 
        for (int i = 3; i <= Math.sqrt(n); i+= 2){
            while (n%i == 0){
                hs.add(i);
                n /= i;
            }
        }
 
        if (n > 2)
            hs.add(n);
        
        primes = new ArrayList<>(hs);
        
    }
 
    public boolean canTraverseAllPairs(int[] nums) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        DisjointSet ds = new DisjointSet(nums.length);
        
        for(int i=0; i< nums.length; i++){
            boolean flag = true;
            primeFactors(nums[i]); 
            
            for(int j = 0; j< primes.size();j++){
                if(!hs.containsKey(primes.get(j))){
                    hs.put(primes.get(j),i);
                }else{
                     ds.unionByRank(i,hs.get(primes.get(j)));
                }
            }
            
        }
        int cnt = 0;
        for(int i = 0; i< nums.length; i++){
            if(ds.findUPar(i) == i){
                cnt++;
            }
        }
        return cnt==1;
        
    }
    
    public int gcd(int a, int b){
        int i;
        if (a < b)
            i = a;
        else
            i = b;
 
        for (i = i; i > 1; i--) {
 
            if (a % i == 0 && b % i == 0)
                return i;
        }
 
        return 1;
    }
    
    
    
}