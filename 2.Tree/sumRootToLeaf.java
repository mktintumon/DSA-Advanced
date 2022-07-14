class sumRootToLeaf {

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
    
    int sum ;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        //let number be start as 0
        helper(root , 0);
        return sum;
    }
    
    public void helper(TreeNode node , int num){
        if(node == null) return;
        
        helper(node.left , num*10 + node.val);
        helper(node.right , num*10 + node.val);
        
        //post-oder working
        if(node.left == null && node.right == null){
            // its leaf
            num = num*10 + node.val;
            sum += num;
        }
    }
}