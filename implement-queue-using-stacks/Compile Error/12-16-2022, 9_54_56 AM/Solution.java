// https://leetcode.com/problems/implement-queue-using-stacks

class MyQueue {
Stack<Integer> queue = new Stack<Integer>();
// Push element x to the back of queue.
public void push(int x) {
    Stack<Integer> temp = new Stack<Integer>();
    while(!queue.empty()){
        temp.push(queue.pop());
    }
    queue.push(x);
    while(!temp.empty()){
        queue.push(temp.pop());
    }
}

// Removes the element from in front of queue.
public void pop() {
    queue.pop();
}

// Get the front element.
public int peek() {
    return queue.peek();
}

// Return whether the queue is empty.
public boolean empty() {
    return queue.empty();
}
}