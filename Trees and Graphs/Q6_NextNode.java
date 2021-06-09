class TreeNode2 {
    int value;
    TreeNode2 left, right, parent;

    public TreeNode2(int v) {
        value = v;
        left = right = parent = null;
    }
}

public class Q6_NextNode { // inorder successor
    TreeNode2 root;

    public TreeNode2 nextNode(TreeNode2 n){
        if (n==null) return null;

        if (n.right != null){ // find leftmost element of right subtree
            n = n.right;
            while (n.left != null) n=n.left;
            return n;
        }
        else {
            TreeNode2 child = n;
            TreeNode2 parent = n.parent;

            while (parent!=null && parent.left!=child) {
                child = parent;
                parent = parent.parent;
            }

            return parent;
        }
    }

    public static void main(String[] args) {
        Q6_NextNode ob = new Q6_NextNode();

        ob.root = new TreeNode2(20);
        ob.root.left = new TreeNode2(17);
        ob.root.left.parent = ob.root;
        ob.root.right = new TreeNode2(22);
        ob.root.right.parent = ob.root;
        ob.root.left.right = new TreeNode2(18);
        ob.root.left.right.parent = ob.root.left;
        ob.root.right.left = new TreeNode2(21);
        ob.root.right.left.parent = ob.root.right;
        ob.root.right.right = new TreeNode2(24);
        ob.root.right.right.parent = ob.root.right;
        ob.root.right.right.left = new TreeNode2(23);
        ob.root.right.right.left.parent = ob.root.right.right;

        /*
                                 20
                             /        \
                            /          \
                          17            22
                           \           /    \
                            18        21     24
                                            /
                                           23
        * */

        TreeNode2 s = ob.nextNode(ob.root.left.right);
        if (s!=null) System.out.println(s.value);
    }
}
