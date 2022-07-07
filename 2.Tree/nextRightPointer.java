
class nextRightPointer {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    
        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
     
    public Node connect(Node root) {
        Node n1 = root; // leftMost node in each level
        
        while(n1 != null){
            Node n2 = n1; // current node
            while(n2 != null){
              if(n2.left != null){
                 n2.left.next = n2.right;
              }
                
              if(n2.right != null && n2.next != null){
                 n2.right.next = n2.next.left; 
              } 
                
              n2 = n2.next;  
            }
            
            n1 = n1.left;
        }
        return root;
    }
}