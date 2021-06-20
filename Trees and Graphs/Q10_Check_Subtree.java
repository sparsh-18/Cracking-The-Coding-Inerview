public class Q10_Check_Subtree {
    TreeNode t1,t2;

    Q10_Check_Subtree() {
        t1 = t2 = null;
    }

    // by comparing preorder that stores null also
    public String preorderWithNull (TreeNode root) {
        StringBuilder s = new StringBuilder();

        if (root == null) {
            s.append(" n");
            return s.toString();
        }

        s.append(" "+root.value);
        s.append(preorderWithNull(root.left));
        s.append(preorderWithNull(root.right));
        return s.toString();
    }

    public boolean isSubtree(TreeNode t1, TreeNode t2) {
        String t1Preorder = preorderWithNull(t1);
        String t2Preorder = preorderWithNull(t2);

        return t1Preorder.indexOf(t2Preorder) != -1;
    }

    public static void main(String[] args) {
        Q10_Check_Subtree ob = new Q10_Check_Subtree();
        ob.t1 = new TreeNode(20);
        ob.t1.left = new TreeNode(96);
        ob.t1.right = new TreeNode(22);
        ob.t1.left.right = new TreeNode(18);
        ob.t1.right.left = new TreeNode(4);
        ob.t1.right.right = new TreeNode(24);
        ob.t1.right.right.left = new TreeNode(23);

        /*
                                20
                             /       \
                            /         \
                           96          22
                            \          /   \
                             18       4    24
                                            /
                                           23
        * */

        ob.t2 = new TreeNode(22);
        ob.t2.left = new TreeNode(4);
        ob.t2.right = new TreeNode(24);
        ob.t2.right.left = new TreeNode(23);
        /*
                             22
                            /   \
                           4    24
                               /
                              23
        */

        System.out.println(ob.isSubtree(ob.t1,ob.t2));
    }
}
