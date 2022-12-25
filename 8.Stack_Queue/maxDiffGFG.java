import java.util.*;

class maxDiffGFG{
    
    int findMaxDiff(int a[], int n){
	    int[] left = nsol(a);
	    int[] right = nsor(a);
	    
	    int diff = 0;
	    for(int i=0 ; i<a.length ; i++){
	        diff = Math.max(diff , Math.abs(left[i] - right[i]));
	    }
	    return diff;
    }
    
    int[] nsor(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i=0 ; i<arr.length ; i++){
            while(st.size() > 0 && arr[st.peek()] > arr[i]){
                ans[st.peek()] = arr[i];
                st.pop();
            }
            
            st.push(i);
        }
        return ans;
    }
    
    int[] nsol(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr.length-1);
        for(int i=arr.length-2 ; i>= 0 ; i--){
            while(st.size() > 0 && arr[st.peek()] > arr[i]){
                 ans[st.peek()] = arr[i];
                st.pop();
            }
            
            st.push(i);
        }
        return ans;
    }
}
