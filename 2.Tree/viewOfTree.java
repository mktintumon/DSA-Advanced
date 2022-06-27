import java.util.*;

public class viewOfTree {
    public static class pair {
        Node node;
        int state;

        pair() {
        }

        pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

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

    public static void display(Node root) {
        if (root == null)
            return;

        if (root.left != null) {
            System.out.print(root.left.val);
        } else {
            System.out.print(".");
        }
        System.out.print(" <- " + root.val + " -> ");
        if (root.right != null) {
            System.out.print(root.right.val);
        } else {
            System.out.print(".");
        }
        System.out.println();

        display(root.left);
        display(root.right);
    }

    // LEFT VIEW OF A TREE
    public static ArrayList<Integer> leftView(Node root) {
        Queue<Node> qu = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        qu.add(root);

        if (root == null)
            return ans;

        while (qu.size() > 0) {
            int levelSize = qu.size();

            for (int i = 0; i < levelSize; i++) {
                Node rem = qu.remove();

                if (i == 0)
                    ans.add(rem.val);

                if (rem.left != null) {
                    qu.add(rem.left);
                }

                if (rem.right != null) {
                    qu.add(rem.right);
                }
            }
        }
        return ans;
    }

    // RIGHT VIEW OF A TREE
    public static ArrayList<Integer> rightView(Node root) {
        Queue<Node> qu = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        qu.add(root);

        if (root == null)
            return ans;

        while (qu.size() > 0) {
            int levelSize = qu.size();

            for (int i = 0; i < levelSize; i++) {
                Node rem = qu.remove();

                if (i == levelSize - 1)
                    ans.add(rem.val);

                if (rem.left != null) {
                    qu.add(rem.left);
                }

                if (rem.right != null) {
                    qu.add(rem.right);
                }
            }
        }
        return ans;
    }

    public static class TreePair {
        Node node;
        int axis = 0;
    }

    // TOP VIEW OF A TREE
    public static ArrayList<Integer> topView(Node root) {
        Queue<TreePair> qu = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        int leftMostView = 0;
        int rightMostView = 0;

        TreePair p = new TreePair();
        p.node = root;
        p.axis = 0;
        qu.add(p);

        while (qu.size() > 0) {
            TreePair rem = qu.remove();

            if (rem.axis < leftMostView) {
                leftMostView = rem.axis;
            }

            if (rem.axis > rightMostView) {
                rightMostView = rem.axis;
            }

            if (map.containsKey(rem.axis) == false) {
                map.put(rem.axis, rem.node);
            }

            if (rem.node.left != null) {
                TreePair left = new TreePair();
                left.node = rem.node.left;
                left.axis = rem.axis - 1;

                qu.add(left);
            }

            if (rem.node.right != null) {
                TreePair right = new TreePair();
                right.node = rem.node.right;
                right.axis = rem.axis + 1;

                qu.add(right);
            }
        }

        for (int i = leftMostView; i <= rightMostView; i++) {
            ans.add(map.get(i).val);
        }

        return ans;
    }

    // BOTTOM VIEW OF A TREE
    public static ArrayList<Integer> bottomView(Node root) {
        Queue<TreePair> qu = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        int leftMostView = 0;
        int rightMostView = 0;

        TreePair p = new TreePair();
        p.node = root;
        p.axis = 0;
        qu.add(p);

        while (qu.size() > 0) {
            TreePair rem = qu.remove();

            if (rem.axis < leftMostView) {
                leftMostView = rem.axis;
            }

            if (rem.axis > rightMostView) {
                rightMostView = rem.axis;
            }

            // keep updating hashmap
            map.put(rem.axis, rem.node);

            if (rem.node.left != null) {
                TreePair left = new TreePair();
                left.node = rem.node.left;
                left.axis = rem.axis - 1;

                qu.add(left);
            }

            if (rem.node.right != null) {
                TreePair right = new TreePair();
                right.node = rem.node.right;
                right.axis = rem.axis + 1;

                qu.add(right);
            }
        }

        for (int i = leftMostView; i <= rightMostView; i++) {
            ans.add(map.get(i).val);
        }

        return ans;
    }

    public static void main(String[] args) {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };
        Node root = new Node(arr[0]);
        Stack<pair> st = new Stack<>();
        pair rootPair = new pair(root, 1);
        st.push(rootPair);
        int idx = 1;
        while (st.size() != 0) {
            pair peekPair = st.peek();

            if (peekPair.state == 1) {
                peekPair.state++;
                if (arr[idx] != null) {

                    Node leftChild = new Node(arr[idx]);
                    peekPair.node.left = leftChild;

                    st.push(new pair(leftChild, 1));

                }
                idx++;

            } else if (peekPair.state == 2) {
                peekPair.state++;
                if (arr[idx] != null) {

                    Node rightChild = new Node(arr[idx]);
                    peekPair.node.right = rightChild;

                    st.push(new pair(rightChild, 1));
                }
                idx++;
            } else {
                st.pop();
            }

        }
        // rightView(root);
        System.out.println(topView(root));

    }
}
