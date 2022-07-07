
class constructBSTfromPreOrder {

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

    int idx = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode helper(int[] preorder, int min, int max) {
        if (idx == preorder.length) {
            return null;
        } else if (preorder[idx] > min && preorder[idx] < max) {
            TreeNode node = new TreeNode();
            node.val = preorder[idx];
            idx++;

            node.left = helper(preorder, min, node.val);
            node.right = helper(preorder, node.val, max);

            return node;
        } else {
            // not satisfied
            return null;
        }
    }
}