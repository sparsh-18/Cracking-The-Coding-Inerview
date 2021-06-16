import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

class GraphNode {
    ArrayList<GraphNode> dependency;

    int dependentCount;
    String name;

    //for detecting cycle dfs
    public enum State {
        BLANK, PARTIAL,COMPLETE;
    }

    State state;

    public GraphNode(String name) {
        this.name = name;
        dependency = new ArrayList<>();
        dependentCount = 0;

        state = State.BLANK;
    }
}

public class Q7_BuildOrder {

    ArrayList<GraphNode> ar;
    HashMap<String, GraphNode> m;

    public Q7_BuildOrder() {
        ar = new ArrayList<>();
        m = new HashMap<>();
    }

    public void createGraph(String allNodes[], String dependencies[][]) {
        for(String eachNode : allNodes){
            addtoGraph(eachNode);
        }
        for (String eachDepeneddency[] : dependencies) {
            adddependency(eachDepeneddency[0], eachDepeneddency[1]);
        }
    }

    private void addtoGraph(String eachNode) {
        if(!m.containsKey(eachNode)) {
            GraphNode g = new GraphNode(eachNode);
            ar.add(g);
            m.put(eachNode, g);
        }
    }

    private void adddependency(String x, String y) {
        if (m.containsKey(x) && m.containsKey(y)) {
            GraphNode xKey = m.get(x);
            GraphNode yKey = m.get(y);

            xKey.dependency.add(yKey);

            yKey.dependentCount++;
        }
    }

    public ArrayList<String> createBuildOrder(){
        ArrayList<String> buildOrder = new ArrayList<>();
        while(ar.size() != 0) {
            ArrayList<GraphNode> toremove = new ArrayList<>();
            for (GraphNode g : ar) {
                if (g.dependentCount == 0) {
                    for (GraphNode child : g.dependency) {
                        child.dependentCount--;
                    }
                    buildOrder.add(g.name);
                    toremove.add(g);
                }
            }
            ar.removeAll(toremove);
        }
        return buildOrder;
    }

    // dfs way
    public String createBuildOrderDfs() {
        LinkedList<String> buildordr = new LinkedList<>();
        for (GraphNode g: ar) {
            if(g.state == GraphNode.State.BLANK) {
                if (!dfs(g, buildordr)) return null; // cycle found
            }
        }
        String res = "";
        for (String s: buildordr) {
            res = res + " " + s;
        }
        return  res;
    }

    public boolean dfs(GraphNode g, LinkedList<String> buildordr) {
        if (g.state == GraphNode.State.PARTIAL)
            return false;

        if (g.state == GraphNode.State.BLANK){
            g.state = GraphNode.State.PARTIAL;

            ArrayList<GraphNode> children = g.dependency;

            for (GraphNode child: children) {
                if (child.state != GraphNode.State.COMPLETE){
                    if(!dfs(child,buildordr)) return false;
                }
            }

            buildordr.addFirst(g.name);
            g.state = GraphNode.State.COMPLETE;
        }

        return true;
    }
}


// {"a","b","c","d","e","f"}
//{{"f","a"},{"f","b"},{"a","d"},{"b","d"},{"d","c"}}