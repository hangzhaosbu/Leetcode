class MinStack {
    int index;
    int pointer;
    int mini[];
    int stack[];
   
    public MinStack() {
        index = 0;
        pointer = 0;
        stack = new int[3*(10000) + 1];
        mini = new int[3*(10000) + 1];
    }
   
    public void push(int val) {
        stack[index] = val;
        index ++;
        mini[pointer] = pointer > 0 ? Math.min(val, mini[pointer - 1]) : val;
        pointer ++ ;
    }
   
    public void pop() {
        pointer --;
        index --;
    }
   
    public int top() {
        return stack[index-1];
    }
   
    public int getMin() {
        return mini[pointer-1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */