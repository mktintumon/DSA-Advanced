
class lcaBinaryTree{

class Node{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
   
    boolean f1 = false; // for n1 
    boolean f2 = false; // for n2
    
	Node lca(Node root, int n1,int n2){
		Node lca = helper(root , n1 , n2);
		if(f1 == true && f2 == true){
		    return lca;
		}
		else{
		    return null;
		}
	}
	
	Node helper(Node node , int n1 , int n2){
		if(node == null) return null;
	    
	    //post-order working 
	    Node left = helper(node.left , n1 , n2);
	    Node right = helper(node.right , n1 , n2);
	    
	    //cases
	    if(node.data == n1){
	        f1 = true;
	        return node;
	    }
	    else if(node.data == n2){
	        f2 = true;
	        return node;
	    }
	    else if(left != null && right != null){
	        return node;
	    }
	    else if(left != null){
	        return left;
	    }
	    else if(right != null){
	        return right;
	    }
	    else{
	        return null;
	    }
	}
}