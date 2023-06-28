// https://leetcode.com/problems/single-threaded-cpu

// class Solution {
//     class pair{
//         int idx;
//         int start;
//         int time;
//         pair(int idx,int start,int time){
//             this.idx=idx;
//             this.start=start;
//             this.time=time;
//         }
//     }
//     public int[] getOrder(int[][] tasks){
//         pair[] arr= new pair[tasks.length];
//         int[] ans= new int[tasks.length];
//         int idx=0;
//         for(int i=0;i<tasks.length;i++){
//             pair pp= new pair(i,tasks[i][0],tasks[i][1]);
//             arr[i]=pp;
//         }
//         Arrays.sort(arr,(a,b)-> (a.start==b.start)? a.time-b.time : a.start-b.start);
//         int time=arr[0].start;
//         time+=arr[0].time;
//         ans[idx]=arr[0].idx;
//         idx++;
//         int idx1=1;
//         PriorityQueue<pair> pq= new PriorityQueue<>((a,b)-> (a.time==b.time) ? a.idx-b.idx : a.time-b.time);
//         while(idx<ans.length){
//              while(idx1<arr.length && arr[idx1].start<=time){
//                  pq.add(arr[idx1]);
//                  idx1++;
//              }
//              if(pq.size()!=0){
//                  pair curr=pq.poll();
//              time+=curr.time;
//              ans[idx]=curr.idx;
//              idx++;

//              }
//               else{
//                   time++;
//               }
//         }
//        return ans;
//     }
// }
class Solution{
public static int[] getOrder(int[][] tasks) {
        int curTime = 0, i2 = 0, len = tasks.length;
        int[] order = new int[len];
//        Collect all the tasks with index, and sort it in order of enqueueTime (start time)
        PriorityQueue<Task> orderedTasks = new PriorityQueue<>(Comparator.comparingInt(t -> t.start));
        for (int i = 0; i < len; i++) {
            orderedTasks.add(new Task(tasks[i][0], tasks[i][1], i));
        }
        PriorityQueue<Task> processor = new PriorityQueue<>((t1, t2) -> t1.time == t2.time ? Integer.compare(t1.idx, t2.idx) : Integer.compare(t1.time, t2.time));
        while (!orderedTasks.isEmpty()) {
            while (!orderedTasks.isEmpty() && orderedTasks.peek().start <= curTime) {
                processor.add(orderedTasks.poll());
            }
            if (!processor.isEmpty()) {
                Task poll = processor.poll();
                order[i2++] = poll.idx;
                curTime += poll.time;
            } else {
//                This is the key:
//                  If the process is empty, then instead of staying ideal. Move the current time to the next task start time.
                if (!orderedTasks.isEmpty()) curTime = orderedTasks.peek().start;
//                Break the while loop, when there are no any new tasks that can be added to queue.
                else break;
            }
        }
//        Collect all the tasks present in processor.
        while (!processor.isEmpty()) {
            order[i2++] = processor.poll().idx;
        }
        return order;
    }

    static class Task {
        int start, time, idx;

        public Task(int start, int time, int idx) {
            this.start = start;
            this.time = time;
            this.idx = idx;
        }
}
}
