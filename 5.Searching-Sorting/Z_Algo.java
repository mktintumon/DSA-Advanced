import java.util.*;

// GFG --> For printing, Starting Index of a string should be taken as 1.

class Z_Algo{
    
    ArrayList<Integer> search(String pat, String S){
        String str = pat + "$" + S;
        
        int[] zArr = new int[str.length()];
        zArr[0] = 0;
        
        int left = 0;
        int right = 0;
        for(int i=1 ; i<str.length() ; i++){
            if(i > right){
                // make window
                left = right = i;
                
                while(right < str.length() && str.charAt(right) == str.charAt(right - left)){
                    right++;
                }
                
                //mismatch found
                right--;
                zArr[i] = right - left + 1;
            }
            else{
                // left <= i <= right
                int k = i - left;
                
                if(zArr[k] == right - i + 1){
                    left = i;
                    
                    while(right < str.length() && str.charAt(right) == str.charAt(right - left)){
                        right++;
                    }
                
                    //mismatch found
                    right--;
                    zArr[i] = right - left + 1;
                }
                else{
                    // within window
                    zArr[i] = zArr[k];
                }
            }
        }
        

        // collecting our idxes from zArr
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0 ; i<zArr.length ; i++){
            if(zArr[i] == pat.length()){
                ans.add(i - pat.length());
            }
        }
        
        return ans;
    }
}
