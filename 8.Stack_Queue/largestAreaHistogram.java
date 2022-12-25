import java.util.*;

class largestAreaHistogram {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int maxWidth = 0;

        int[] nsol = nsol(heights);
        int[] nsor = nsor(heights);

        for(int i=0 ; i<heights.length ; i++){
            maxWidth = nsor[i] - nsol[i] - 1;
            int currArea = heights[i]*maxWidth;

            maxArea = Math.max(maxArea , currArea);
        }

        return maxArea;
    }

    int[] nsor(int[] arr){
        int[] ans = new int[arr.length];
        Arrays.fill(ans,arr.length);
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i=0 ; i<arr.length ; i++){
            while(st.size() > 0 && arr[st.peek()] > arr[i]){
                ans[st.peek()] = i;
                st.pop();
            }
            
            st.push(i);
        }
        return ans;
    }
    
    int[] nsol(int[] arr){
        int[] ans = new int[arr.length];
        Arrays.fill(ans,-1);
        Stack<Integer> st = new Stack<>();
        st.push(arr.length-1);
        for(int i=arr.length-2 ; i>= 0 ; i--){
            while(st.size() > 0 && arr[st.peek()] > arr[i]){
                 ans[st.peek()] = i;
                st.pop();
            }
            
            st.push(i);
        }
        return ans;
    }
}
