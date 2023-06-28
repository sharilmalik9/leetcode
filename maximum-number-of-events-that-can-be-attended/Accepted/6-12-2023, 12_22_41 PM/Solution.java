// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a,b)->a[0]-b[0]);
        PriorityQueue<Integer> existingEvents = new PriorityQueue<>((a,b)->a-b);
        int curDay =events[0][0],eventsAttended=0, i=0;
        while(i<events.length || !existingEvents.isEmpty()){
            //step 1
            while(!existingEvents.isEmpty() && existingEvents.peek()<curDay){
                //discarding the expired events
                existingEvents.poll();
            }

            //step 2
            while(i<events.length && events[i][0]==curDay){
                //noting the finish time of events that I can attend
                existingEvents.offer(events[i][1]);
                i++;
            }
            //step 3
            if(!existingEvents.isEmpty()){
                existingEvents.poll();
                eventsAttended++;
            }
            //Day Passed by
            curDay++;
        }
        return eventsAttended;
    }
}