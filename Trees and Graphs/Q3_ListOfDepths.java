import java.util.ArrayList;
import java.util.LinkedList;

public class Q3_ListOfDepths {
    TreeNode root;

    Q3_ListOfDepths() {
        root = null;
    }

    // DFS method   used preorder  Node, Left, Right
    void createLists(ArrayList<LinkedList<TreeNode>> ar, int level, TreeNode root) {
        if (root != null) {
            LinkedList<TreeNode> l = null;

            if(ar.size() == level) { // means the linked list is not present in array
                l = new LinkedList<>();
                ar.add(l);
            } else { // if linked list is already  present in array get it
                l = ar.get(level);
            }

            l.addLast(root);

            createLists(ar, level+1, root.left);
            createLists(ar, level+1, root.right);
        }
    }

    // BFS method
    void createListBFS(ArrayList<LinkedList<TreeNode>> ar, TreeNode root) {

        if (root != null) {

                LinkedList<TreeNode> current = new LinkedList<>();
                current.addLast(root);

                while (current.size() != 0) {

                    ar.add(current);

                    LinkedList<TreeNode> parent = current;

                    current = new LinkedList<>();

                    for (TreeNode e: parent) {
                        if (e.left != null) current.addLast(e.left);
                        if (e.right!= null) current.addLast(e.right);
                    }

                }

        }

    }

    void showLists(ArrayList<LinkedList<TreeNode>> ar) {
        int c = 0;
        for(LinkedList<TreeNode> e : ar) {
            System.out.print("List ["+c+"] ");
            for (TreeNode t : e) {
                System.out.print(" -> "+t.value);
            }
            System.out.println();
            c++;
        }
    }

    public static void main(String[] args) {
        Q3_ListOfDepths ob = new Q3_ListOfDepths();

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
                           18         21     24
                                            /
                                           23
        * */

        System.out.println("DFS");
        ArrayList<LinkedList<TreeNode>> ardfs = new ArrayList<>();
        ob.createLists(ardfs,0,ob.root);
        ob.showLists(ardfs);

        System.out.println("\nBFS");
        ArrayList<LinkedList<TreeNode>> arbfs = new ArrayList<>();
        ob.createListBFS(arbfs, ob.root);
        ob.showLists(arbfs);
    }
}
