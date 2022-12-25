import java.util.*;

class maxRectangleArea {
    
    public int maximalRectangle(char[][] matrix) {
        int[] ht = new int[matrix[0].length];

        //making intial view of height
        for(int j=0 ; j<matrix[0].length ; j++){
            ht[j] = matrix[0][j] == '0' ? 0 : 1;
        }

        int ans = largestAreaHistogram(ht);

        // increasing the level of height array
        // i == rows and j == cols
        for(int i=1 ; i<matrix.length ; i++){
            for(int j=0 ; j<matrix[i].length ; j++){
                ht[j] = matrix[i][j] == '0' ? 0 : ht[j]+1;
            }

            int ans2 = largestAreaHistogram(ht);
            ans = Math.max(ans , ans2);
        }

        return ans;
    }

    int largestAreaHistogram(int[] heights) {
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
