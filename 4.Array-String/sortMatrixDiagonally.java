import java.util.*;

//  TC --> O(mn*log(min(m , n))
//  adding only min(m , n) key to PQ

class sortMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int gap = i - j;
                
                if(map.containsKey(gap) == false){
                    map.put(gap, new PriorityQueue<>());
                }
                
                map.get(gap).add(mat[i][j]);
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int gap = i - j;
                mat[i][j] = map.get(gap).remove();
            }
        }
        
        return mat;
    }
}