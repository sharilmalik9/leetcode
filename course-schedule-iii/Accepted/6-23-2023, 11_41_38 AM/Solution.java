// https://leetcode.com/problems/course-schedule-iii

class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->a[1]==b[1] ? a[0]-b[0] :a[1]-b[1]);
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        int time=0;
        for(int i=0;i<courses.length;i++){
            int end=courses[i][1];
            int duration=courses[i][0];
            if(duration+time<=end){
                time+=duration;
                pq.add(duration);

            }
            else if(pq.size()!=0 && pq.peek()>duration){
                int niklo=pq.poll();
                time-=niklo;
                pq.add(duration);
                time+=duration;
            }
        }
        return pq.size();
        
    }
}