class greaterSumTree {

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


    int sum;
    public TreeNode bstToGst(TreeNode root) {
       sum = 0;
       helper(root);
       return root; 
    }
    
    public void helper(TreeNode node){
        if(node == null){
            return;
        }
        
        //working in reverse in-order
        helper(node.right);
         
        node.val = node.val + sum;
        sum = node.val;
         
        helper(node.left);
    }
}