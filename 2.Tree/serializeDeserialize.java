import java.util.*;

public class serializeDeserialize {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
       if(root == null) return ""; 
        
       StringBuilder sb = new StringBuilder();
       helper(root , sb);
       return sb.toString();
    }
    
    public void helper(TreeNode node,StringBuilder sb){
       if(node == null){
           sb.append("n");
           sb.append(" ");
           return;
       }
        
       sb.append(node.val);
       sb.append(" ");
        
       helper(node.left , sb);
       helper(node.right , sb); 
    }

    
    // Decodes your encoded data to tree.
    class Pair{
        TreeNode node;
        int state = 0;
    }
   
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
       
        String[] dataArr = data.split(" ");
        int idx = 0;
        
        Stack<Pair> st = new Stack<>();
        Pair rootPair = new Pair();
        rootPair.node = new TreeNode(Integer.parseInt(dataArr[idx])); // str-->Int
        st.push(rootPair);
        
        while(st.size() > 0){
            Pair top = st.peek();
            
            if(top.state == 0){
                // ask for left
                idx++;
                top.state++;
                
                if(!dataArr[idx].equals("n")){
                   Pair leftPair = new Pair();
                   leftPair.node = new TreeNode(Integer.parseInt(dataArr[idx]));
                   top.node.left = leftPair.node;
                    
                   st.push(leftPair); 
                }
            }
            else if(top.state == 1){
                //ask for right
                idx++;
                top.state++;
                
                if(!dataArr[idx].equals("n")){
                   Pair rightPair = new Pair();
                   rightPair.node = new TreeNode(Integer.parseInt(dataArr[idx]));
                   top.node.right = rightPair.node;
                    
                   st.push(rightPair); 
                }
            }
            else{
                //action completed
                st.pop();
            }
        }
        
        return rootPair.node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));