import java.util.*;

public class levelOrderTraversal {
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

    public static void levelOrder(Node root) {
        Queue<Node> qu = new LinkedList<>();
        // seeding
        qu.add(root);

        while (qu.size() > 0) {
            // 1. remove
            Node rem = qu.remove();

            // 2. Work
            System.out.print(rem.val + " ");

            // 3. Add all child If possible
            if (rem.left != null) {
                qu.add(rem.left);
            }
            if (rem.right != null) {
                qu.add(rem.right);
            }
        }
    }

    // LEVEL ORDER LINE WISE
    public static void levelOrderNULL_Method(Node root) {
        Queue<Node> qu = new LinkedList<>();
        // seeding
        qu.add(root);
        qu.add(null);

        while (qu.size() > 0) {
            if (qu.size() == 1 && qu.peek() == null) {
                break;
            }
            // 1. remove
            Node rem = qu.remove();
            if (rem == null) {
                qu.add(null);
                System.out.println();
            } else {
                System.out.print(rem.val + " ");

                // 3. Add all child If possible
                if (rem.left != null) {
                    qu.add(rem.left);
                }
                if (rem.right != null) {
                    qu.add(rem.right);
                }
            }

        }
    }


    // REVERSE_LEVEL_ORDER
    public static void reverseLevelOrder(Node root) {
        Queue<Node> qu = new LinkedList<>();
        Stack<String> st = new Stack<>();
        String s = "";

        qu.add(root);
        qu.add(null);

        while (qu.size() > 0) {
            Node rem = qu.remove();

            if (rem != null) {
                s += rem.val + " ";

                if (rem.left != null) {
                    qu.add(rem.left);
                }
                if (rem.right != null) {
                    qu.add(rem.right);
                }
            } else {
                st.push(s);
                s = "";

                if (qu.size() > 0) {
                    qu.add(rem);
                }
            }
        }

        while (st.size() > 0) {
            s = st.pop();
            System.out.println(s);
        }
    }


    // GFG
    public ArrayList<Integer> reverseLevelOrderGFG(Node node) {
        Queue<Node> qu = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        qu.add(node);

        while (qu.size() > 0) {
            Node rem = qu.remove();

            st.push(rem.val);
            if (rem.right != null) {
                qu.add(rem.right);
            }
            if (rem.left != null) {
                qu.add(rem.left);
            }
        }

        while (st.size() > 0) {
            int val = st.pop();
            ans.add(val);
        }

        return ans;

    }


    //LEVEL LEVEL USING PAIR
    static class LOPair {
        Node node;
        int level;
  
        LOPair(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }
  
    public static void levelOrderLW(Node node) {
      Queue<LOPair> queue = new LinkedList<>();
      queue.add(new LOPair(node, 1));
      int currLevel = 1;
  
      while(queue.size() > 0){
          LOPair pair = queue.remove();
  
          if(pair.level > currLevel){
            //line change
              System.out.println();
              currLevel = pair.level;
          }
  
          System.out.print(pair.node.val + " ");
  
          if(pair.node.left != null){
              LOPair leftPair = new LOPair(pair.node.left, pair.level + 1);
              queue.add(leftPair);
          }
  
          if(pair.node.right != null){
              LOPair rightPair = new LOPair(pair.node.right, pair.level + 1);
              queue.add(rightPair);
          }
      }
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

        // display(root);
        // System.out.println(height(root));
        // levelOrder(root);
        // levelOrderNULL_Method(root);
        reverseLevelOrder(root);

    }
}