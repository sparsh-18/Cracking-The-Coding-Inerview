public class Q2_MinimalBST {
    TreeNode root;

    public Q2_MinimalBST() {
        root = null;
    }

    public void push(int ar[]) {
        root = createBST(root, ar, 0, ar.length-1);
    }

    public TreeNode createBST(TreeNode root, int[] ar, int s, int e) {
        if(s>e) return null;

        int mid = (s+e)/2;

        root = new TreeNode(ar[mid]);
        root.left = createBST(root.left, ar, s, mid-1);
        root.right = createBST(root.right, ar, mid+1, e);

        return root;
    }

    public void inorder(TreeNode root){
        if (root!=null) {
            inorder(root.left);
            System.out.print(root.value + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        int ar[] = {1,2,3,4,5,6};

        /*
                    3
                 /    \
                1       5
                 \     /  \
                  2   4    6
        * */

        Q2_MinimalBST ob = new Q2_MinimalBST();

        ob.push(ar);
        ob.inorder(ob.root);
    }
}
