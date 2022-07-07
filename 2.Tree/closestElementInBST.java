class closestElementInBST{
    public class Node {
        int data;
        Node left;
        Node right;

        Node() {
        }

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static int min_diff;   
    static int minDiff(Node  root, int K){ 
        min_diff = Integer.MAX_VALUE;
        helper(root , K);
        return min_diff;
    } 
    
    static void helper(Node node , int k){
        if(node == null) return;
        
        int diff = Math.abs(node.data - k);
        if(diff < min_diff){
            min_diff = diff;
        }
        
        if(k > node.data){
            helper(node.right , k);
        }
        else if(k < node.data){
            helper(node.left , k);
        }
        else{
            return;
        }
    }
}