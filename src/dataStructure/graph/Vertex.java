package graph;

/**
 * 图结构的顶点
 */
public class Vertex {

    private String val;
    private boolean visited;

    public Vertex(String val){
        this.val=val;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return val;
    }
}
