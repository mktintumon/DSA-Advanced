public class constructBSTfromPostOrder {
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

    int idx ;
    public TreeNode bstFromPreorder(int[] postorder) {
        idx = postorder.length-1;
        return helper(postorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode helper(int[] postorder, int min, int max) {
        if (idx == -1) {
            return null;
        } else if (postorder[idx] > min && postorder[idx] < max) {
            TreeNode node = new TreeNode();
            node.val = postorder[idx];
            idx--;

            // first right call -> then left call
            node.right = helper(postorder, node.val, max);
            node.left = helper(postorder, min, node.val);

            return node;
        } else {
            // not satisfied
            return null;
        }
    }
}
