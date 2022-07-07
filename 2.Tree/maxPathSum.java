class maxPathSum{
    public static class Node {
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


    // ROOT TO LEAVES  (Approach-1)
    public static int maxPathSumRTL(Node root)
    {
        if(root.left != null && root.right != null){
            int left = maxPathSumRTL(root.left);
            int right = maxPathSumRTL(root.right);
            return Math.max(left, right) + root.data;
        } else if(root.left != null){
            int left = maxPathSumRTL(root.left);
            return left + root.data;
        } else if(root.right != null){
            int right = maxPathSumRTL(root.right);
            return right + root.data;            
        } else {
            // leaf
            return root.data;
        }
    }

    
    // ROOT TO LEAVES  (Approach-2)
    static int max = Integer.MIN_VALUE;
    public static int maxPathSumRTL2(Node root)
    {
        max = Integer.MIN_VALUE;
        travel(root, 0);
        return max;
    }
    
    public static void travel(Node node, int sum){
        if(node == null){
            return;
        }
        
        if(node.left == null && node.right == null){
            sum = sum + node.data;
            if(sum > max){
                max = sum;
            }
            return;
        }
        
        travel(node.left, sum + node.data);
        travel(node.right, sum + node.data);
    }


    //ROOT TO NODE (Approach-1)
    public static int maxPathSumRTN(Node root)
    {
        if(root.left != null && root.right != null){
            int left = maxPathSumRTN(root.left);
            int right = maxPathSumRTN(root.right);
            // ignoring negative sum
            int left_dash = Math.max(0, left);
            int right_dash = Math.max(0, right);

            return Math.max(left_dash, right_dash) + root.data;

        } else if(root.left != null){
            int left = maxPathSumRTN(root.left);
            int left_dash = Math.max(0, left);

            return left_dash + root.data;

        } else if(root.right != null){
            int right = maxPathSumRTN(root.right);
            int right_dash = Math.max(0, right);

            return right_dash + root.data;   

        } else {
            // leaf
            return root.data;
        }
    }


    //ROOT TO NODE (Approach-2)
    static int maxVal = Integer.MIN_VALUE;
    public static int maxPathSumRTN2(Node root)
    {
        max = Integer.MIN_VALUE;
        travels(root, 0);
        return max;
    }
    
    public static void travels(Node node, int sum){
        if(node == null){
            return;
        }
        
        if(sum + node.data > maxVal){
            maxVal = sum + node.data;
        }
        
        travel(node.left, sum + node.data);
        travel(node.right, sum + node.data);
    }


    //ROOT TO NODE (Approach-3)
    public static int maxPathSumRTN3(Node root)
    {
        if(root == null){
            return 0;
        }
        
        int left = maxPathSumRTN3(root.left);
        int right = maxPathSumRTN3(root.right);

        int left_dash = Math.max(0, left);
        int right_dash = Math.max(0, right);

        return Math.max(left_dash, right_dash) + root.data;
    }

    
    // REAL QUESTION -> NODE TO NODE MAX SUM
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSumNTN(Node root) {
      max = Integer.MIN_VALUE; 
      helper(root);
      return max;  
    }
    
    // return root to node sum
    // but calculate node to node sum
    public int helper(Node root){
      if(root == null) return 0;
        
      int left = helper(root.left);
      int right = helper(root.right);
        
      int left_dash = Math.max(0 , left);
      int right_dash = Math.max(0 , right);
        
      // pair -> left + right + node  
      int pairSum = left_dash + right_dash + root.data; 
      if(pairSum > maxSum){
        maxSum = pairSum;
      }  
      
      return Math.max(left_dash, right_dash) + root.data;
    }

    
    // LEAF TO LEAF MAX SUM 
    int maximum; //  maximum l 2 l
    public int maxPathSumLTL(Node root)
    { 
        maximum = Integer.MIN_VALUE;
        helper(root);
        return maximum;    
    } 
    
    int helperLTL(Node node){
      if(node.left != null && node.right != null){
          int left = helperLTL(node.left);
          int right = helperLTL(node.right);

          max = Math.max(max, left + node.data + right);

          return Math.max(left, right) + node.data;
      } else if(node.left != null){
          int left = helperLTL(node.left);
          return node.data + left;
      } else if(node.right != null){
          int right = helperLTL(node.right);
          return node.data + right;
      } else {
          return node.data;
      }
    }
}
