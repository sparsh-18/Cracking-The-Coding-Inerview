import java.util.ArrayList;
import java.util.LinkedList;

public class Q9_BST_Sequences {
    TreeNode root;

    public Q9_BST_Sequences (){
        root = null;
    }

    public ArrayList<LinkedList<Integer>> allpermutations(TreeNode root) {
        ArrayList<LinkedList<Integer>> res = new ArrayList<>();

        if (root == null) {
            res.add(new LinkedList<Integer>());
            return res;
        }

        ArrayList<LinkedList<Integer>> left = allpermutations(root.left);
        ArrayList<LinkedList<Integer>> right = allpermutations(root.right);

        LinkedList<Integer> p = new LinkedList<>();
        p.add(root.value);

        for (LinkedList<Integer> l : left) {
            for (LinkedList<Integer> r: right) {
                weave(l,r,p,res);
            }
        }

        return res;
    }

    public void weave(LinkedList<Integer> l, LinkedList<Integer> r, LinkedList<Integer> p, ArrayList<LinkedList<Integer>> res) {
        if (l.size() == 0 || r.size() == 0) {
            LinkedList<Integer> re = (LinkedList<Integer>) p.clone();
            re.addAll(l);
            re.addAll(r);

            res.add(re);
            return;
        }

        Integer tl = l.peekFirst();
        l.removeFirst();
        p.addLast(tl);
        weave(l,r,p,res);
        l.addFirst(tl);
        p.removeLast();

        Integer tr = r.peekFirst();
        r.removeFirst();
        p.addLast(tr);
        weave(l,r,p,res);
        r.addFirst(tr);
        p.removeLast();
    }

    public static void main(String[] args) {
        Q9_BST_Sequences ob = new Q9_BST_Sequences();

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

        ArrayList<LinkedList<Integer>> ar = ob.allpermutations(ob.root);
        System.out.println(ar.size());
        for (LinkedList<Integer> list: ar) {
            for (Integer i: list) {
                System.out.print(i+"\t");
            }
            System.out.println();
        }
    }
}
