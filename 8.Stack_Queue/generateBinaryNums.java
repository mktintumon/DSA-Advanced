import java.util.*;

class generateBinaryNums{
    static ArrayList<String> generate(int N){
        ArrayList<String> ans = new ArrayList<>();
        Queue<String> qu = new LinkedList<>();
        qu.add("1");
        
        for(int i=1 ; i<=N ; i++){
            String rem = qu.remove();
            ans.add(rem);
            
            qu.add(rem + "0");
            qu.add(rem + "1");
        }
        
        return ans;
    }
    
}