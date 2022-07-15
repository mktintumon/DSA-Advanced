
public class AVL{

    public static class Node{
        int data;
        Node left;
        Node right;

        int ht = 1;  //in terms of node 
        int bal = 0; // leftHt - rightHt
        
        Node(){};

        Node(int data){
            this.data = data;
        }
    }

    public static Node construct(int[] arr){
        return construct_helper(arr , 0 , arr.length-1);
    }

    public static Node construct_helper(int[] arr , int lo , int hi){
        if( lo > hi) return null;

        int mid = (lo + hi) / 2;

        Node node = new Node(arr[mid]);
        node.left = construct_helper(arr , lo , mid-1);
        node.right = construct_helper(arr , mid+1 , hi);

        node.ht = getHeight(node);
        node.bal = getBalance(node);

        return node;
    }

    private static int getHeight(Node node){
        int leftH = node.left != null ? node.left.ht : 0;
        int rightH = node.right != null ? node.right.ht : 0;
        return Math.max(leftH , rightH) + 1;
    }

    private static int getBalance(Node node){
        int leftH = node.left != null ? node.left.ht : 0;
        int rightH = node.right != null ? node.right.ht : 0;
        return leftH - rightH;
    }

    public static void display(Node node){
        if(node == null){
            return;
        }
        
        String str = " <- " + node.data + "[" + node.ht + ", " + node.bal + "] -> ";
        String lstr = node.left != null? node.left.data + "": ".";
        String rstr = node.right != null? node.right.data + "": ".";
        
        System.out.println(lstr + str + rstr);
        
        display(node.left);
        display(node.right);
    }

    public static Node add(Node node, int val){
        if(node == null){
            return new Node(val);    
        }
        
        if(val > node.data){
            node.right = add(node.right, val);
        } else if(val < node.data){
            node.left = add(node.left, val);
        }
        
        node.ht = getHeight(node);
        node.bal = getBalance(node);
        
        if(node.bal > 1){ //--->LL and LR cases

            if(node.left.bal >= 0){ 
                // case --> LL
                node = rightRotate(node);
            } 
            else { 
                // case --> LR
                node.left = leftRotate(node.left);
                node = rightRotate(node);
            }
        } 
        else if(node.bal < -1){ //---> RR and RL cases 

            if(node.right.bal < 0){ 
                // Case --> RR
                node = leftRotate(node);
            } 
            else { 
                // case --> RL
                node.right = rightRotate(node.right);
                node = leftRotate(node);
            }
        }
        
        return node;
    }
    
    public static Node rightRotate(Node node){
        Node z = node;
        Node y = z.left;
        Node t3 = y.right;
        
        z.left = t3;
        y.right = z;
        
        z.ht = getHeight(z);
        z.bal = getBalance(z);
        y.ht = getHeight(y);
        y.bal = getBalance(y);
        
        return y;
    }
    
    public static Node leftRotate(Node node){
        Node z = node;
        Node y = z.right;
        Node t2 = y.left;
        
        z.right = t2;
        y.left = z;
        
        z.ht = getHeight(z);
        z.bal = getBalance(z);
        y.ht = getHeight(y);
        y.bal = getBalance(y);
        
        return y;
    }

    public static Node remove(Node node, int val){
        if(node == null){
            return null;
        }
        
        if(val == node.data){
            if(node.left != null && node.right != null){
                int lmax = max(node.left);
                node.data = lmax;
                node.left = remove(node.left, lmax);
            } 
            else if(node.left != null){
                return node.left;
            } 
            else if(node.right != null){
                return node.right;
            } 
            else {
                return null;
            }
        } 
        else if(val < node.data){
            node.left = remove(node.left, val);
        } 
        else if(val > node.data){
            node.right = remove(node.right, val);
        }
        
        node.ht = getHeight(node);
        node.bal = getBalance(node);
        
        // same code as add node
        if(node.bal > 1){ //--->LL and LR cases

            if(node.left.bal >= 0){ 
                // case --> LL
                node = rightRotate(node);
            } 
            else { 
                // case --> LR
                node.left = leftRotate(node.left);
                node = rightRotate(node);
            }
        } 
        else if(node.bal < -1){ //---> RR and RL cases 

            if(node.right.bal < 0){ 
                // Case --> RR
                node = leftRotate(node);
            } 
            else { 
                // case --> RL
                node.right = rightRotate(node.right);
                node = leftRotate(node);
            }
        }
        
        return node;
    }
    
    public static int max(Node node){
        if(node.right == null){
            return node.data;
        } else {
            return max(node.right);
        }
    }

    public static void main(String[] args){
        int[] arr = {10, 12, 20, 25, 30, 37, 40, 50, 60, 62, 70, 75, 80, 87, 90};
        Node root = construct(arr);
        display(root);
        root = add(root, 5);
        root = add(root, 1);
        root = add(root, 11);
        
        root = remove(root, 1);
        root = remove(root, 5);
        root = remove(root, 10);
        root = remove(root, 30);
        root = remove(root, 40);
        root = remove(root, 37);
        root = remove(root, 11);
        display(root);
    }
}