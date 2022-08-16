import java.util.*;

class kSimilarString {

    public int kSimilarity(String s1, String s2) {
        HashSet<String> vis = new HashSet<>();
        Queue<String> qu = new LinkedList<>();
        
        qu.add(s1);
        int level = 0;
        
        // BFS
        while(qu.size() > 0){
            int size = qu.size();
            
            for(int i=0 ; i<size ; i++){
                String rem = qu.remove();
                
                if(vis.contains(rem) == true){
                    continue;
                }
                
                vis.add(rem);
                
                if(rem.equals(s2) == true){
                    return level;
                }
                
                for(String str : getNbr(rem , s2)){
                    if(vis.contains(str) == false){
                        qu.add(str);
                    }
                }
            }
            level++;
        }
        
        return -1;
    }
    
    public ArrayList<String> getNbr(String rem , String s2){
        ArrayList<String> ans = new ArrayList<>();
        
        // doing sensible swapping only
        int idx = -1;
        for(int i=0 ; i<rem.length() ; i++){
            if(rem.charAt(i) != s2.charAt(i)){
                idx = i;
                break;
            }
        }
        
        for(int i=idx+1 ; i<rem.length() ; i++){
            if(rem.charAt(i) == s2.charAt(idx)){
                String newStr = swap(rem , idx , i);
                ans.add(newStr);
            }
        }
        
        return ans;
    }
    
    public String swap(String str , int i , int j){
        StringBuilder sb = new StringBuilder(str);
        
        char ch1 = str.charAt(i);
        char ch2 = str.charAt(j);
        sb.setCharAt(i , ch2);
        sb.setCharAt(j , ch1);
        
        return sb.toString();
    }
}
