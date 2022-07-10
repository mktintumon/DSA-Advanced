
class flattenBTtoLinkedList {
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

    // APPROACH - 1
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        flatten(root.right);
        flatten(root.left);
        
        root.left = null;
        root.right = prev;
        prev = root;
    }


    // APPROACH - 2
    class Pair{
        TreeNode head;
        TreeNode tail;
        
        Pair(){};
        Pair(TreeNode head, TreeNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    public void flatten2(TreeNode root){
        if(root != null){
           helper(root);
        }
    }

    public Pair helper(TreeNode node){
        if(node.left != null && node.right != null){
           Pair leftPair = helper(node.left);
           Pair rightPair = helper(node.right);

           Pair myPair = new Pair();
           myPair.head = node;
           myPair.head.left = null;
           myPair.head.right = leftPair.head;
           leftPair.tail.right = rightPair.head;
           myPair.tail = rightPair.tail;

           return myPair;
        }
        else if(node.left != null){
            Pair leftPair = helper(node.left);
 
            Pair myPair = new Pair();
            myPair.head = node;
            myPair.head.left = null;
            myPair.head.right = leftPair.head;
            myPair.tail = leftPair.tail;
 
            return myPair;
        }
        else if(node.right != null){
            Pair rightPair = helper(node.right);

            Pair myPair = new Pair();
            myPair.head = node;
            myPair.head.left = null;
            myPair.head.right = rightPair.head;
            myPair.tail = rightPair.tail;

           return myPair;
        }
        else{
          Pair myPair = new Pair(node , node);
          return myPair;
        }
    }
}