import java.util.HashMap;

class constTreefromPreAndPost {
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

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }

        TreeNode root = helper(preorder, map, 0, preorder.length - 1, 0, postorder.length - 1);
        return root;
    }

    public TreeNode helper(int[] pre, HashMap<Integer, Integer> map, int pre_start, int pre_end, int post_start,
            int post_end) {
        if (pre_start > pre_end || post_start > post_end) {
            return null;
        }

        TreeNode node = new TreeNode(pre[pre_start]);

        if (pre_start + 1 <= pre_end) {
            int idx = map.get(pre[pre_start + 1]);
            int totalLeft = idx - post_start + 1;

            node.left = helper(pre, map, pre_start + 1, pre_start + totalLeft, post_start, idx);
            node.right = helper(pre, map, pre_start + totalLeft + 1, pre_end, idx + 1, post_end - 1);
        }

        return node;
    }
}