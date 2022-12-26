import java.util.*;

class iplFinalGFG {
    static int findMaxLen(String s) {
        int ans = 0;
        
        // pushing indexes in stack -> start with -1
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        
        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(i);
            }
            else{
                st.pop();
                
                // keep record of longest length
                if(st.size() > 0){
                    int length = i - st.peek();
                    ans = Math.max(length , ans);
                }
                else{
                    // pushing itself
                    st.push(i);
                }
            }
        }
        return ans;
    }
};