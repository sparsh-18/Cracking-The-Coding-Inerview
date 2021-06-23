import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q1_PathBetweenNodes {
    ArrayList<ArrayList<Integer>> adjlist;
    boolean visited[];

    public Q1_PathBetweenNodes(int noOfNodes) {
        adjlist = new ArrayList<>();
        for (int i=0; i<noOfNodes; i++)
            adjlist.add(new ArrayList<>());
        visited = new boolean[noOfNodes];
    }

    public void addAdj(int a, int b) {
        adjlist.get(a).add(b);
    }

    public boolean allvisited() {
        for (boolean v: visited) {
            if (!v) return false;
        }
        return true;
    }

    public boolean isPresentBFS(int a, int b) {
        Queue<Integer> q = new LinkedList<>();
        if (!visited[a])
            q.add(a);

        while (q.size() != 0) {
            int v = q.remove();
            if (v==b) return true;
            visited[v] = true;
            for (int adj: adjlist.get(v)) {
                if (!visited[adj])
                    q.add(adj);
            }
        }
        return false;
    }

    public boolean isPresentDFS(int a, int b) {
        if (!visited[a] && a==b) return true;

        visited[a] = true;

        for (int adj: adjlist.get(a)) {
            if (!visited[adj] && isPresentDFS(adj,b))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Q1_PathBetweenNodes obiwan = new Q1_PathBetweenNodes(4);
        obiwan.addAdj(0,1);
        obiwan.addAdj(1,2);
        obiwan.addAdj(1,3);

        System.out.println(obiwan.isPresentBFS(2,3));

        Q1_PathBetweenNodes obito = new Q1_PathBetweenNodes(4);
        obito.addAdj(0,1);
        obito.addAdj(1,2);
        obito.addAdj(1,3);

        System.out.println(obito.isPresentDFS(1,2));
    }
}
