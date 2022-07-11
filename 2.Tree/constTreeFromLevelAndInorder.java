import java.util.*;

class constTreefromLevelAndInorder{
    public static class Node {
        int val;
        Node left;
        Node right;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Node buildTree(int inord[], int level[])
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < level.length; i++){
            map.put(level[i], i);
        }

        Node root = helper(inord, map, 0, inord.length - 1);
        return root;
        
    }

    public Node helper(int[] inord, HashMap<Integer, Integer> map, int in_start, int in_end){
        if(in_start > in_end){
            return null;
        }
        
        // assuming start of inorder is the lowest in level-order
        int minIdx = in_start;
        for(int i = in_start + 1; i <= in_end; i++){
            if(map.get(inord[i]) < map.get(inord[minIdx])){
                minIdx = i;
            }
        }

        Node node = new Node(inord[minIdx]);
        node.left = helper(inord, map, in_start, minIdx - 1);
        node.right = helper(inord, map, minIdx + 1, in_end);

        return node;
    } 
}