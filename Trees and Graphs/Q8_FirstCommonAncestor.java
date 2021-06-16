import java.util.Scanner;

public class Q8_FirstCommonAncestor {
    TreeNode root;

    public Q8_FirstCommonAncestor() {
        root = null;
    }

    TreeNode getNode (TreeNode root, int v) {
        if (root == null) return null;
        if (root.value == v) return root;
        TreeNode l = getNode(root.left,v);
        if (l!=null) return l;
        TreeNode r = getNode(root.right, v);
        if (r!=null) return r;
        return l==null ? r: l;
    }

    public TreeNode getAncestor(TreeNode root, TreeNode pNode, TreeNode qNode) {
        if (root == null) return null;

        if (root == pNode || root == qNode) return root;

        TreeNode l = getAncestor(root.left, pNode, qNode);
        if (l!=null && l!=pNode && l!=qNode) return l;

        TreeNode r = getAncestor(root.right, pNode, qNode);
        if (r!=null && r!=pNode && r!=qNode) return r;

        if (l!=null && r!=null) return root;

        else return l==null ? r : l;
    }

    public static void main(String[] args) {
        Q8_FirstCommonAncestor ob= new Q8_FirstCommonAncestor();

        ob.root = new TreeNode(20);
        ob.root.left = new TreeNode(96);
        ob.root.right = new TreeNode(22);
        ob.root.left.right = new TreeNode(18);
        ob.root.right.left = new TreeNode(4);
        ob.root.right.right = new TreeNode(24);
        ob.root.right.right.left = new TreeNode(23);

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
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter values of nodes");
        int p = sc.nextInt(), q = sc.nextInt();

        TreeNode pNode = ob.getNode(ob.root,p), qNode = ob.getNode(ob.root, q);

        if (pNode!=null && qNode!=null) {
            TreeNode anc = ob.getAncestor(ob.root, pNode, qNode);
            System.out.println(anc.value);
        } else {
            System.out.println("Not in tree");
        }
    }

}
