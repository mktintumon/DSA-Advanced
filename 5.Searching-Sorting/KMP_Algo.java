import java.util.*;

class KMP_Algo{
    
    ArrayList<Integer> search(String pat, String txt){
        // for storing all found starting idx of pattern
        ArrayList<Integer> ans = new ArrayList<>();
        
        int[] lps = getLps(pat);
        
        int i = 0;
        int j = 0;
        
        while(i < txt.length()){
            if(txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;
                
                if(j == pat.length()){
                    //found
                    ans.add(i - j + 1);

                    // search for another idx
                    j = lps[j - 1];
                }
            }
            else if(j == 0){
                // yaha nhi milne wala --> i ko aage badhao
                i++;
            }
            else{
                // mismatch found --> shifting
                j = lps[j - 1];
            }
        }
        
        return ans;
    }
    

    int[] getLps(String s){
        int[] lps = new int[s.length()];
        
        int length = 0;
        int i = 1;
        while(i < lps.length){
            if(s.charAt(i) == s.charAt(length)){
                lps[i] = length + 1;
                length++;
                i++;
            }
            else if(length == 0){
                lps[i] = 0;
                length = 0;
                i++;
            }
            else{
                length = lps[length - 1];
            }
        }
        
        return lps;
    }
}