import java.util.*;

// SAME AS -> LC 1081. Smallest Subsequence of Distinct Characters

class removeDuplicateLetters {
    public String remove_DuplicateLetters(String s) {
        char[] arr = s.toCharArray();

        // create frequency map
        int[] count = new int[26];
        for(char ch : arr){
            int idx = ch - 'a';
            count[idx]++;
        }

        boolean[] exists = new boolean[26];
        Stack<Character> st = new Stack<>();

        for(char ch : arr){
            int idx = ch - 'a';
            count[idx]--;

            if(exists[idx] == false){
                while(st.size() > 0 && count[st.peek() - 'a'] > 0 && st.peek() > ch){
                    exists[st.peek() - 'a'] = false;
                    st.pop();
                }

                st.push(ch);
                exists[idx] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(st.size() > 0){
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}
