import java.util.*;

class constructTreeFromPostInOrder {
    
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
         // take root from post and find in inorder 
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i=0 ; i<inorder.length ; i++){
            map.put(inorder[i] , i);
        }
        
        //no need to pass inorder[]
        TreeNode root = construct(0 , postorder.length-1 , 0 , inorder.length-1 , postorder , map);
        return root;
    }
    
    public TreeNode construct(int post_start,int post_end,int in_start,int in_end,int[] postorder,HashMap<Integer , Integer> map){
        if(post_start > post_end || in_start > in_end){
            return null;
        }
        
        TreeNode node = new TreeNode();
        // take root value from postorder
        // find root idx in inorder
        // find total node in right side of root
        node.val = postorder[post_end];
        int idx = map.getOrDefault(postorder[post_end], 0);
        int totalRight = in_end - idx;
         
        node.left = construct(post_start, post_end-totalRight-1  ,in_start , idx-1, postorder, map);
        node.right = construct(post_end-totalRight, post_end-1 , idx+1 , in_end ,postorder , map);
            
        return node;    
    }
}