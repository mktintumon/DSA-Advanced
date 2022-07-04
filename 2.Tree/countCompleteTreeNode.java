
class countCompleteTreeNode {
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

    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        // logn complexity
        int leftHeight = 0;
        TreeNode node = root.left;
        while(node != null){
          node = node.left;
          leftHeight++;  
        }
        
        int rightHeight = 0;
        node = root.right;
        while(node != null){
          node = node.right;
          rightHeight++;    
        }
        
        if(leftHeight == rightHeight){
            int myHeight = leftHeight + 1;
            return (1 << myHeight) - 1; // --> pow(2,h) - 1
        }
        
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
