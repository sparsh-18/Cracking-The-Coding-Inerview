import java.util.Random;

class TreeNodeQ11 {
    int value,size;
    TreeNodeQ11 left, right;
    public TreeNodeQ11(int value) {
        this.value = value;
        size = 1;
    }
}
public class Q11_RandomNode {
    TreeNodeQ11 root;

    public Q11_RandomNode() {
        root = null;
    }

    public TreeNodeQ11 getRandomNode() {
        int size = root.size;
        Random r = new Random();
        int random = r.nextInt(size);

        return getNodefromR(root, random);
    }

    public TreeNodeQ11 getNodefromR(TreeNodeQ11 root, int random) {
        int leftSize = root.left == null ? 0 : root.left.size;

        if (random == leftSize) return root;

        else if (random < leftSize) return getNodefromR(root.left, random);

        else return getNodefromR(root.right, random-leftSize-1);
    }

    public TreeNodeQ11 insertBST(TreeNodeQ11 root, int n) {
        if (root == null) {
            root = new TreeNodeQ11(n);
            return root;
        }

        int d = root.value;
        if (n<=d) {
            root.left = insertBST(root.left, n);
        } else {
            root.right = insertBST(root.right, n);
        }
        root.size++;
        return root;
    }

    public static void main(String args[]) {
        Q11_RandomNode ob = new Q11_RandomNode();

        int ar[] = {20,10,25,8,15,11};

        for(int i : ar) {
            ob.root = ob.insertBST(ob.root, i);
        }

        for (int i=0;i<50;i++)
            System.out.println("Random = "+ob.getRandomNode().value);
    }
}
