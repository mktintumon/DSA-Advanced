import java.util.*;

class slidingWindowMax {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        
        // storing idxes
        int[] nextGreater = new int[n];
        Stack<Integer> st = new Stack<>();
        nextGreater[n-1] = n; // infinite
        st.push(n-1);
        
        for(int i=n-2 ; i>=0 ; i--){
           while(st.size() > 0 && nums[i] >= nums[st.peek()]){
               st.pop();
           } 
            
           if(st.size() == 0){
               nextGreater[i] = n; // infinite
           }
           else{
               nextGreater[i] = st.peek();
           }
            
            st.push(i);
        }
        
        int[] ans = new int[n-k+1];
        int j = 0;
        for(int i = 0; i < ans.length; i++){
            if(j < i) j = i;
            
            while(nextGreater[j] <= i + k - 1){
                j = nextGreater[j];
            }
            
            ans[i] = nums[j];
        }
        
        return ans;
    }
}