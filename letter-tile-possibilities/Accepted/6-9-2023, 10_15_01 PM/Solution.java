// https://leetcode.com/problems/letter-tile-possibilities

class Solution {
    public int numTilePossibilities(String tiles) {
        int vis[]=new int[tiles.length()];
        StringBuilder sb=new StringBuilder();
        Set<String> l=new HashSet<>();
        bt(tiles,vis,sb,l);
        return l.size();
    }
    void bt(String t,int vis[],StringBuilder sb,Set<String> l){
        for(int i=0;i<t.length();i++){
            if(vis[i]==0){
                vis[i]=1;
                sb.append(t.charAt(i));
                l.add(sb.toString());
                bt(t,vis,sb,l);
                sb.deleteCharAt(sb.length()-1);
                vis[i]=0;
            }
        }

    }
}