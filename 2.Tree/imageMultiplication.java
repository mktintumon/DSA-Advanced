class imageMultiplication {
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
     
    long ans = 0L;
    long MOD = 1000000007;
    public long imgMultiply(Node root){
        
       ans = (root.data * root.data) % MOD;
       
       //root ka kaam ho gya , isiliye left aur right call
       helper(root.left,root.right);
       return ans;
    }
    
    public void helper(Node n1 , Node n2){
        if(n1 == null || n2 == null){
            return;
        }
        
        ans = (ans + n1.data * n2.data) % MOD;
        helper(n1.left , n2.right);
        helper(n1.right , n2.left);
    }
}
