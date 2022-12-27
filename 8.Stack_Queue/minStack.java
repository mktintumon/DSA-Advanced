import java.util.*;

// APPROACH - 1  ( USING EXTRA SPACE -> MIN STACK SPACE)

class minStack {
    Stack<Integer> data;
    Stack<Integer> min;

    public minStack() {
        data = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        if(data.size() == 0){
            data.push(val);
            min.push(val);
        }
        else if(val <= min.peek()){
            data.push(val);
            min.push(val);
        }
        else{
            data.push(val);
        }
    }
    
    public void pop() {
        // for INTEGER greater than 127 , then (==) will not run correctly
        // BUT (x.equals(y)) will run correctly
        if(data.peek().equals(min.peek())){
            data.pop();
            min.pop();
        }
        else{
            data.pop();
        }
    }
    
    public int top() {
        return data.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}



// APPROACH - 2 ---> USING 0(1) SPACE WITHOUT MIN STACK

class MinStack {
    Stack<Long> data;
    Long min;

    public MinStack() {
        data = new Stack<>();
        min = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        long val1 = val; // conversion to long
        if(data.size() == 0){
            data.push(val1);
            min = val1;
        }
        else if(val1 >= min){
            data.push(val1);
        }
        else{
            // encryption and then push
            data.push(val1 + val1 - min);
            min = val1;
        }
    }
    
    public void pop() {
        if(data.peek() >= min){
            data.pop();
        }
        else{
            // retriving the correct min and then pop
            min = (2*min) - (data.peek());
            data.pop();
        }
    }
    
    public int top() {
        if(data.peek() >= min){
            return data.peek().intValue();
        }
        else{
            // data.peek() < min  -----> fake value detected
            return min.intValue();
        }
    }
    
    public int getMin() {
        return min.intValue(); // conversion to int
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
