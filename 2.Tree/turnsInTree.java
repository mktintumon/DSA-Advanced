import java.util.*;

class turnsInTree {

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

    public String getDirections(TreeNode root, int startValue, int destValue) {
        ArrayList<TreeNode> list1 = getPath(root, startValue);
        ArrayList<TreeNode> list2 = getPath(root, destValue);
        
        int i = list1.size() - 1;
        int j = list2.size() - 1;
        
        while(i >= 0 && j >= 0){
            if(list1.get(i) == list2.get(j)){
                i--;
                j--;
            } 
            else {
                break;
            }
        }
        
        i++;
        j++;
        
        StringBuilder ans = new StringBuilder();
        //working inn list1
        for(int k = 0; k < i; k++){
            ans.append("U");
        }
        
        //working in list2
        for(int k = j; k > 0; k--){
            if(list2.get(k - 1) == list2.get(k).left){
                ans.append("L");
            } else {
                ans.append("R");
            }
        }
        
        return ans.toString();
    }
    
    public ArrayList<TreeNode> getPath(TreeNode node, int val){
        if(node == null)  return new ArrayList<>();
        
        if(node.val == val){
            ArrayList<TreeNode> ret = new ArrayList<>();
            ret.add(node);
            return ret;
        } 
        else {
            ArrayList<TreeNode> left = getPath(node.left, val);
            if(left.size() > 0){
                left.add(node);
                return left;
            } 
            else {
                ArrayList<TreeNode> right = getPath(node.right, val);
                if(right.size() > 0){
                    right.add(node);
                    return right;
                } 
                else {
                    return new ArrayList<>();
                }
            }
        }
    }
}