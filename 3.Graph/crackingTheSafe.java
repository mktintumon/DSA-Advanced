import java.util.*;

class crackingTheSafe {
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        //start with n zeros
        for(int i=0 ; i<n ; i++){
            sb.append(0);
        }
        
        HashSet<String> vis = new HashSet<>();
        vis.add(sb.toString());
        
        int limit = (int)Math.pow(k,n);
        dfs(sb , vis , limit , n , k);
        
        return sb.toString();
    }
    
    public boolean dfs(StringBuilder sb ,HashSet<String> vis ,int limit , int n , int k){
        if(vis.size() == limit) return true;
        
        // extracting the last 2 digit for eg: n=3 k=2 
        String reqStr = sb.substring(sb.length() - (n-1));
        
        for(int i=0 ; i<k ; i++){
            String newPass = reqStr + i;
            
            if(vis.contains(newPass) == false){
                vis.add(newPass);
                sb.append(i);
                boolean flag = dfs(sb , vis , limit , n , k);
                if(flag == true){
                    // as question give multiple answers -> we need only one answer
                    return true;
                }
                
                //backtrack
                vis.remove(newPass);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        
        return false;
    }
}
