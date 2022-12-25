import java.util.*;

class dailyTemperature {

    // left to right travel
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];

        // pushing idxes in stack
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i=1 ; i<temperatures.length ; i++){
            while(st.size() > 0 && temperatures[st.peek()] < temperatures[i]){
                ans[st.peek()] = i - st.peek();
                st.pop();
            }

            st.push(i);
        }

        return ans;
    }


    // right to left travel
    public int[] dailyTemperatures2(int[] temperatures) {
        int[] ans = new int[temperatures.length];

        // pushing idxes in stack
        Stack<Integer> st = new Stack<>();
        st.push(temperatures.length-1);
        for(int i=temperatures.length-2 ; i>=0 ; i--){
            while(st.size() > 0 && temperatures[st.peek()] <= temperatures[i]){
                st.pop();
            }

            if(st.size() > 0){
                ans[i] = st.peek() - i;
            }

            st.push(i);
        }

        return ans;
    }
}
