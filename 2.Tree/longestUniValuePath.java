class longestUniValuePath {

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

    int length;
    public int longestUnivaluePath(TreeNode root) {
        length = 0;
        helper(root , -1);
        
        //calculating in terms of nodes but answer in terms of edges
        if(length > 0){
            length = length -1;
        }
        
        return length;
    }
    
    public int helper(TreeNode node , int val){
        if(node == null){
            return 0;
        }
        
        int left = helper(node.left , node.val);
        int right = helper(node.right , node.val);
        
        //working in post-order
        if(left + right + 1 > length){
            length = left + right + 1;
        }
        
        if(node.val == val){
            return Math.max(left , right) + 1;
        }
        else{
            return 0;
        }
    }
}