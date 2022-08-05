import java.util.*;

/*
    Input: equations = [["a","b"],["b","c"]],
    values = [2.0,3.0], 
    queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]

    Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 
 */

class evaluateDivision {
    
    HashMap<String, String> parent;
    HashMap<String, Double> multiple;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        parent = new HashMap<>();
        multiple = new HashMap<>();
        
        // making self set using hashmap
        for(List<String> eqn : equations){
            addToDSU(eqn.get(0));
            addToDSU(eqn.get(1));
        }
        
        // making set according to DSU -> ["srcLead" , "nbrLead"][".","."][".","."]
        // [["a","b"],["b","c"]]
        int i = 0;
        for(List<String> eqn: equations){
            String srcLead = find(eqn.get(0));
            String nbrLead = find(eqn.get(1));
        
            Double m0 = multiple.get(eqn.get(0));
            Double m1 = multiple.get(eqn.get(1));
            
            multiple.put(srcLead , m1 * values[i] / m0);
            parent.put(srcLead , nbrLead);
            
            i++;
        }
        
        double[] ans = new double[queries.size()];
        i = 0;
        
        // now evaluating the queries
        for(List<String> query: queries){
            if(parent.containsKey(query.get(0)) == false || parent.containsKey(query.get(1)) == false){
                ans[i] = -1;
                i++;
                continue;
            }
            
            String srcLead = find(query.get(0));
            String nbrLead = find(query.get(1));
            
            if(srcLead.equals(nbrLead) == false){
                ans[i] = -1;
                i++;
                continue;
            } 
            
            Double m0 = multiple.get(query.get(0));
            Double m1 = multiple.get(query.get(1));
            ans[i] = m0 / m1;
            
            i++;
        }
        
        return ans;
    }
    
    public void addToDSU(String x){
        if(parent.containsKey(x) == false){
            parent.put(x , x);
            multiple.put(x , 1.0);
        }
    }
    
    public String find(String x){
        if(parent.get(x).equals(x)){
            return parent.get(x);
        }
        else{
            String currParent = parent.get(x);
            String newParent = find(parent.get(x));
            
            multiple.put(x , multiple.get(currParent)*multiple.get(x));
            parent.put(x , newParent);
            
            return newParent;
        }
    }
}