public class Q4_BalancedTree {
    TreeNode root;

    boolean isBalanced(TreeNode root) {
        int d = getHeight(root);
        if (d==Integer.MIN_VALUE) return false;
        else return true;
    }

    public int getHeight(TreeNode n) {
        if (n == null) return -1;

        int l = getHeight(n.left);
        int r = getHeight(n.right);

        if (l == Integer.MIN_VALUE || r == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int d = Math.abs(l-r);

        if(d > 1) return Integer.MIN_VALUE;

        else return Math.max(l,r)+1;

    }


    public static void main(String[] args) {
        Q4_BalancedTree ob = new Q4_BalancedTree();

        ob.root = new TreeNode(20);
        ob.root.left = new TreeNode(17);
        ob.root.right = new TreeNode(22);
        ob.root.left.right = new TreeNode(18);
        ob.root.right.left = new TreeNode(21);
        ob.root.right.right = new TreeNode(24);
        ob.root.right.right.left = new TreeNode(23);

        /*
                                20
                             /       \
                           /           \
                         17              22
                           \           /    \
                            18        21     24
                                            /
                                           23
        * */

        System.out.println(ob.isBalanced(ob.root));
    }
}
