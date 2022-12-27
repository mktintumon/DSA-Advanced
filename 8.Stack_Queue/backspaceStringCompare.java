import java.util.*;

class backspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        String s1 = evaluate(s);
        String s2 = evaluate(t);
        return s1.equals(s2);
    }

    public String evaluate(String s){
        Stack<Character> st = new Stack<>();
        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            if(ch != '#'){
                st.push(ch);
            }
            else if(st.size() > 0){
                st.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while(st.size() > 0){
            sb.append(st.pop());
        }

        return sb.toString();
    }
}