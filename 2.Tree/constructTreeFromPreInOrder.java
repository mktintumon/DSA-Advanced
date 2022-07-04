import java.util.*;

class constructTreeFromPreInOrder {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // take root from pre and find in inorder 
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i=0 ; i<inorder.length ; i++){
            map.put(inorder[i] , i);
        }
        
        //no need to pass inorder[]
        TreeNode root = construct(0 , preorder.length-1 , 0 , inorder.length-1 , preorder , map);
        return root;
    }
    
    public TreeNode construct(int pre_start,int pre_end,int in_start,int in_end,int[] preorder,HashMap<Integer , Integer> map){
        if(pre_start > pre_end || in_start > in_end){
            return null;
        }
        
        TreeNode node = new TreeNode();
        // take root value from preorer
        // find root idx in inorder
        // find total node in left side of root
        node.val = preorder[pre_start];
        int idx = map.getOrDefault(preorder[pre_start], 0);
        int totalLeft = idx - in_start;
        
        node.left = construct(pre_start+1, pre_start+totalLeft ,in_start , idx-1, preorder, map);
        node.right = construct(pre_start+totalLeft+1, pre_end ,idx+1 ,in_end ,preorder , map);
            
        return node;    
    }
}