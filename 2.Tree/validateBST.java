public class validateBST {
    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode next;
    
        public TreeNode() {}
        
        public TreeNode(int _val) {
            val = _val;
        }
    
        public TreeNode(int _val, TreeNode _left, TreeNode _right, TreeNode _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    // APPROACH -> 1
    int prev = Integer.MIN_VALUE;
    public boolean validate(TreeNode root){
      if(root == null) return true;

      boolean left = validate(root.left);
      if(left == false) return false;

      if(prev >= root.val) return false;
      prev = root.val;

      boolean right = validate(root.right);
      if(right == false) return false;

      return true;
    }

    // APPROACH -> 2
    class Pair {
        boolean isBST = true;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
    }

    public boolean isValidBST(TreeNode root) {
        Pair rp = helper(root);
        return rp.isBST;
    }

    public Pair helper(TreeNode node){
        if(node == null) return new Pair();

        Pair left = helper(node.left);
        Pair right = helper(node.right);

        Pair myPair = new Pair();
        myPair.min = Math.min(node.val , Math.min(left.min , right.min ));
        myPair.max = Math.max(node.val , Math.max(left.max , right.max ));
        myPair.isBST = (left.isBST) && (right.isBST) && (node.val > left.max) && (node.val < right.min);

        return myPair;
    }
}
