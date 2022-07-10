
class convertBTtoCircularDoublyLL{
    class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }
    
    //Function to convert binary tree into circular doubly linked list.
    Node bTreeToClist(Node root){
       return helper(root);
    }
    
    // Making inOrder pattern in CDLL
    Node helper(Node node){
        if(node == null) return null;
        
        Node leftHead = helper(node.left);
        Node rightHead = helper(node.right);
        
        Node oneSelf = node;
        oneSelf.left = oneSelf.right = oneSelf;
        
        Node s1 = concat(leftHead , oneSelf);
        Node s2 = concat(s1 , rightHead);
        
        return s2;
    }
    
    // mast function -> important
    Node concat(Node h1, Node h2){
        if(h1 == null){
            return h2;
        } else if(h2 == null){
            return h1;
        }

        Node t1 = h1.left;
        Node t2 = h2.left;

        t1.right = h2;
        h2.left = t1;

        t2.right = h1;
        h1.left = t2;

        return h1;
    }
}