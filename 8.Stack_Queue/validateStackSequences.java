import java.util.*;

class validateStackSequences {
    public boolean validateStackSequence(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();

        int i = 0;
        int j = 0;
        while(i < pushed.length ){
            st.push(pushed[i]);
            i++;

            while(st.size() > 0 && st.peek() == popped[j] && j< popped.length){
                st.pop();
                j++;
            }
        }

        if(st.size() == 0 ) return true;

        return false;
    }
}
