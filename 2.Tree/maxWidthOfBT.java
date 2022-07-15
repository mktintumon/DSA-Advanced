import java.util.*;

class maxWidthOfBT {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Pair{
        int min;
        int max;
    }
    
    int maxWidth = 0;
    public int widthOfBinaryTree(TreeNode root) {
        maxWidth = 0;
        HashMap<Integer , Pair> map = new HashMap<>();
        helper(root, 1 , 1 , map);
        return maxWidth;
    }
    
    public void helper(TreeNode node , int level , int idx ,HashMap<Integer , Pair> map){
        if(node == null) return;
        
        helper(node.left , level+1 , 2*idx , map);
        helper(node.right , level+1 , 2*idx + 1 , map);
        
        Pair p = null;
        
        if(map.containsKey(level)){
            p = map.get(level);
            // p.min will remain unchanged
            p.max = idx;
        }
        else{
           p = new Pair();
           p.min = idx;
           p.max = idx;
           map.put(level , p);    
        }
        
        int width = p.max - p.min + 1;
        if(width > maxWidth){
            maxWidth = width;
        }
    }
}