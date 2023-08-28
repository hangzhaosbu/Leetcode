class MyStack {

    /** Initialize your data structure here. */
    
    Queue <Integer> data = new LinkedList<Integer>();
    
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        
        Queue <Integer> temp_queue = new LinkedList<Integer>();
        
        temp_queue.offer(x);
        
        while(!data.isEmpty()){
            
            temp_queue.offer(data.peek());
            
            data.poll();
        }
        
        while(!temp_queue.isEmpty()){
            
            data.add(temp_queue.peek());
            
            temp_queue.poll();
        }
        
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        
        int num = data.peek();
        
        data.poll();
        
        return num;
        
    }
    
    /** Get the top element. */
    public int top() {
        
        return data.peek();
        
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        
        return data.isEmpty();
        
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */