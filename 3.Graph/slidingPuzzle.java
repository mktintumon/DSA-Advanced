import java.util.*;

/*  learning from this question

 * default constructor make code faster
 * str.indexOf('0')
 * new StringBuilder(str)  ||  sb.setCharAt(i , ch1);
 * HashSet -> (contains) keyword
 
*/

class slidingPuzzle {
    class Pair{
        int level;
        String config;
        
        Pair(int level , String config){
            this.level = level;
            this.config = config;
        }
    }
    
    // swapping possible with idx
    int dir[][] = {
        {1,3},
        {0 , 2 , 4},
        {1, 5},
        {0 , 4},
        {1, 3, 5},
        {2,4}
    };
    
    public int sliding_Puzzle(int[][] board) {
        HashSet<String> vis = new HashSet<>();
        Queue<Pair> qu = new LinkedList<>();
        
        Pair seed = new Pair(0 , getConfig(board));
        qu.add(seed);
        
        while(qu.size() > 0){
            //remove
            Pair rem = qu.remove();
            
            //mark
            if(vis.contains(rem.config) == true){
                continue;
            }
            
            vis.add(rem.config);
            
            //work
            if(rem.config.equals("123450")){
                return rem.level;
            }
            
            //add nbr
            int idx = rem.config.indexOf('0');
            
            for(int i : dir[idx]){
                String newConfig = swap(rem.config , idx , i);
                
                if(vis.contains(newConfig) == false){
                    Pair newPair = new Pair(rem.level+1 , newConfig);
                    qu.add(newPair);
                }
            }
        }
        
        return -1;
    }
    
    public String swap(String str , int i , int j){
        StringBuilder sb = new StringBuilder(str);
        
        char ch1 = str.charAt(i);
        char ch2 = str.charAt(j);
        sb.setCharAt(i , ch2);
        sb.setCharAt(j , ch1);
        
        return sb.toString();
    }
    
    public String getConfig(int[][] board){
        StringBuilder sb = new StringBuilder();
        
        for(int[] row : board){
            for(int val : row){
                sb.append(val);
            }
        }
        return sb.toString();
    }
       
}