import java.util.*;

class pathsum3 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // initialize
        helper(root, root.val, targetSum, map);
        return count;
    }

    public void helper(TreeNode node, int sum, int targetSum, HashMap<Integer, Integer> map) {
        if (map.containsKey(sum - targetSum) == true) {
            count += map.get(sum - targetSum);
        }

        // map entry
        if (map.containsKey(sum) == false) {
            map.put(sum, 1);
        } else {
            map.put(sum, map.get(sum) + 1);
        }

        // call -> left
        if (node.left != null) {
            helper(node.left, sum + node.left.val, targetSum, map);
        }

        // call -> right
        if (node.right != null) {
            helper(node.right, sum + node.right.val, targetSum, map);
        }

        // removal from map
        if (map.get(sum) == 1) {
            map.remove(sum);
        } else {
            map.put(sum, map.get(sum) - 1);
        }
    }
}
