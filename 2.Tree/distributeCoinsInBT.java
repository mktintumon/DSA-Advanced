
class distributeCoinsInBT {
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
        int nodes;
        int coins;
        
        Pair(){};
        
        Pair(int nodes, int coins){
            this.nodes = nodes;
            this.coins = coins;
        }
    }
    
    int count;
    public int distributeCoins(TreeNode root) {
        count = 0;
        helper(root);
        return count;
    }
    
    public Pair helper(TreeNode node){
        if(node == null){
            return new Pair(0,0);
        }
        
        Pair leftPair = helper(node.left);
        Pair rightPair = helper(node.right);
        
        Pair myPair = new Pair(0,0);
        myPair.nodes = leftPair.nodes + rightPair.nodes + 1;
        myPair.coins = leftPair.coins + rightPair.coins + node.val;
        
        count += Math.abs(myPair.nodes - myPair.coins);
        
        return myPair;
    }
}