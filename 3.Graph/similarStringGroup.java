import java.util.*;

class similarStringGroup {
    static HashMap<String, String> parent;
    static HashMap<String, Integer> rank;
    
    public int numSimilarGroups(String[] strs) {
        parent = new HashMap<>();
        rank = new HashMap<>();
        for(String str: strs){
            parent.put(str, str);
            rank.put(str, 1);
        }
        
        for(int i=0 ; i<strs.length ; i++){
            for(int j=i+1 ; j<strs.length ; j++){
                String s1 = strs[i];
                String s2 = strs[j];
                
                if(areSimiliar(s1 , s2) == true){
                    String s1Lead = find(s1);
                    String s2Lead = find(s2);
                    
                    if(s1Lead.equals(s2) == false){
                       union(s1Lead , s2Lead);
                    }
                }
            }
        }
        
        int count = 0;
        for(String key: parent.keySet()){
            if(parent.get(key).equals(key)){
                count++;
            }
        }
        
        return count;
    }
    
    public boolean areSimiliar(String s1 , String s2){
        int count = 0;
        for(int i=0 ; i<s1.length() ; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
            }
        }
        
        // if count of unequal > 2 -> return false
        // as we have to swap only 2 letters
        return (count == 2);
    }
    
    public static String find(String x) {
        if(parent.get(x).equals(x)) {
            return x;
        } else {
            String parentOfX = parent.get(x);
            String setLead = find(parentOfX);
            parent.put(x, setLead);
            return setLead;
        }
    }

    public static void union(String x, String y) {
        if (rank.get(x) < rank.get(y)) {
            parent.put(x, y);
        } else if (rank.get(y) < rank.get(x)) {
            parent.put(y, x);
        } else {
            parent.put(x, y);
            rank.put(y, rank.get(y) + 1);
        }
    }
}
