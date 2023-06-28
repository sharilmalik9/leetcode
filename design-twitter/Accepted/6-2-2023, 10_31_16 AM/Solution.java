// https://leetcode.com/problems/design-twitter

class Pair{
    int userId;
    int tweetId;
    public Pair(int u,int t){
        this.userId = u;
        this.tweetId = t;
    }
}
class Twitter {
    List<Pair> newsFeeds;
    Map<Integer,Set<Integer>> followers;
    public Twitter() {
        this.newsFeeds = new ArrayList<>();
        this.followers = new HashMap<>();
    }
    public void postTweet(int userId, int tweetId) {
        if(!this.followers.containsKey(userId)){
            Set<Integer> set = new HashSet<>();
            set.add(userId);
            this.followers.put(userId,set);
        }
        this.newsFeeds.add(new Pair(userId,tweetId));
    }
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        int cnt = 0;
        for(int i = this.newsFeeds.size() - 1;i >= 0;i--){
            if(cnt == 10){
                break;
            }
            Pair news = this.newsFeeds.get(i);
            if(this.followers.get(userId).contains(news.userId)){
                ans.add(news.tweetId);
                cnt++;
            }
        }
        return ans;
    }
    public void follow(int followerId, int followeeId) {
        if(this.followers.containsKey(followerId)){
            this.followers.get(followerId).add(followeeId);
        }
        else{
            Set<Integer> set = new HashSet<>();
            set.add(followerId);
            set.add(followeeId);
            this.followers.put(followerId,set);
        }
    }
    public void unfollow(int followerId, int followeeId) {
        this.followers.get(followerId).remove(followeeId);
    }
}