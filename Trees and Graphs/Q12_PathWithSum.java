import java.util.HashMap;

public class Q12_PathWithSum {
    TreeNode root;

    Q12_PathWithSum() {
        root = null;
    }

    public int countPaths(int sum) {
        HashMap<Integer,Integer> count = new HashMap<>();
        return countPaths(root,count,sum,0);
    }

    public int countPaths(TreeNode root, HashMap<Integer, Integer> count, int sum, int totalsum) {

        if (root == null) return 0;
        totalsum+= root.value;
        int s = totalsum - sum;
        int totalpath = count.getOrDefault(s,0);

        if (totalsum == sum) totalpath++;

        createOrIncrement(count,totalsum,1);
        totalpath += countPaths(root.left, count, sum, totalsum);
        totalpath += countPaths(root.right, count, sum, totalsum);
        createOrIncrement(count,totalsum,-1); // remove from map

        return totalpath;
    }

    public void createOrIncrement(HashMap<Integer, Integer> count, int totalsum, int i) {
        int c = count.getOrDefault(totalsum,0) + i;
        if (c==0) count.remove(totalsum);
        else count.put(totalsum,i);
    }

    public static void main(String[] args) {
        Q12_PathWithSum ob = new Q12_PathWithSum();

        ob.root = new TreeNode(10);
        ob.root.left = new TreeNode(5);
        ob.root.right = new TreeNode(-3);
        ob.root.left.left = new TreeNode(3);
        ob.root.left.right = new TreeNode(2);
        ob.root.left.right.right = new TreeNode(1);
        ob.root.right.right = new TreeNode(11);
        ob.root.left.left.left = new TreeNode(3);
        ob.root.left.left.right = new TreeNode(-1);

        /*
                        10
                     /      \
                    5       -3
                  /  \        \
                 3    2        11
                / \    \
               3  -1    1
        * */

        System.out.println(ob.countPaths(8));
    }
}
