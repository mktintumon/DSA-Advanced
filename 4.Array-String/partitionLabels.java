import java.util.*;

class partitionLabels {
    public List<Integer> partition_Labels(String s) {
        int[] map = new int[26];
        Arrays.fill(map , -1);
        
        // storing last idx of every char occurance
        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            map[ch - 'a'] = i; // char to int 
        }
        
        int start = 0;
        int end = 0;
        List<Integer> ans = new ArrayList<>();
            
        for(int i=0 ; i<s.length() ; i++){
            //putting end to last occurance idx
            char ch = s.charAt(i);
            end = Math.max(end , map[ch - 'a']);
            
            if(i == end){
                int length = end - start + 1;
                ans.add(length);
                start = end = i + 1;
            }
        }
        
        return ans;
    }
}
