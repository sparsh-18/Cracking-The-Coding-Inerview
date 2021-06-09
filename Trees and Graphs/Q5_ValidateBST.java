public class Q5_ValidateBST {
    TreeNode root;

    public boolean isBst(TreeNode root) {
        return isBst(root,null,null);
    }

    public boolean isBst(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;

        if (min!=null && root.value<min  ||  max!=null && root.value>max) return false;

        return isBst(root.left,min,root.value) && isBst(root.right,root.value,max);
    }

    public static void main(String[] args) {
        Q5_ValidateBST ob = new Q5_ValidateBST();

        ob.root = new TreeNode(20);
        ob.root.left = new TreeNode(17);
        ob.root.right = new TreeNode(22);
        ob.root.left.right = new TreeNode(18);
        ob.root.right.left = new TreeNode(21);
        ob.root.right.right = new TreeNode(24);
        ob.root.right.right.left = new TreeNode(23);

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

        System.out.println("is BST: "+ob.isBst(ob.root));
    }
}
