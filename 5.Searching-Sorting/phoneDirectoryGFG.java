import java.util.*;

class phoneDirectoryGFG{

    static ArrayList<ArrayList<String>> displayContacts(int n, String a[], String S){ 

        Arrays.sort(a); // lexographical order
        
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        HashMap<String,ArrayList<String>> hm = new HashMap<>();
        
        for(int i=0;i<n;i++){
            String temp = a[i];
            
            if(i>0 && a[i].equals(a[i-1])) continue;
            
            for(int j=1;j<=temp.length();j++){
                String sub = temp.substring(0,j);
                
                if(!hm.containsKey(sub)){
                    hm.put(sub,new ArrayList<String>());
                }

                hm.get(sub).add(temp);
            }
        }
        
        ArrayList<String> temp = new ArrayList<>();
        temp.add("0");
        for(int i=1;i<=S.length();i++){
            ans.add(hm.getOrDefault(S.substring(0,i),temp));
        }

       return ans;
    }
    
}