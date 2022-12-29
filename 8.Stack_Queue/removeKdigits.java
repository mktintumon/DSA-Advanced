import java.util.*;

class removeKdigits {
    public String removeKdigit(String nums, int k) {
        if(k == nums.length()) return "0"; // all poped

        Stack<Character> st = new Stack<>();
        st.push(nums.charAt(0)); // seeding

        for(int i=1 ; i<nums.length() ; i++){
            char ch = nums.charAt(i);
            // conditional check
            while(st.size() > 0 && k > 0 && st.peek() > ch){
                st.pop();
                k--;
            }

            st.push(ch);
        }

        // koi pop hua hi nhi --> num = 123456 && k = 3
        while(k > 0){
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(st.size() > 0){
            sb.append(st.pop());
        }

        // trimming process  --> sb = 0020 - > we have to reverse and give 200
        for(int i=sb.length()-1 ; i>=0 ; i--){
            if(sb.charAt(i) == '0'){
                sb.deleteCharAt(i);
            }
            else{
                // breaking at first non zero value
                break;
            }
        }

        String ans = sb.reverse().toString();

        return ans.length() == 0 ? "0" : ans;
    }
}