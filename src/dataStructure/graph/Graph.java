package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 图结构
 */
public class Graph {

    private Vertex[] vertices;
    private int currentSize;
    private int[][] adjmat;

    public Graph(int size) {
        vertices = new Vertex[size];
        adjmat = new int[size][size];
    }


    public void add(Vertex vertex) {
        vertices[currentSize++] = vertex;
    }

    /**
     * 增加一条边
     *
     * @param v1
     * @param v2
     */
    public void addEdge(String v1, String v2) {

        int index1 = 0;
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].getVal().equals(v1)) {
                index1 = i;
            }
        }

        int index2 = 0;
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].getVal().equals(v2)) {
                index2 = i;
            }
        }

        adjmat[index1][index2] = 1;
        adjmat[index2][index1] = 1;
    }


    private Stack stack = new Stack();
    private int currentIndex;

    /**
     * 深度优先搜索算法遍历图
     */
    public void dfs() {
        //把第0个顶点标记为已读
        vertices[0].setVisited(true);
        //把第0个顶点的下标存储起来
        stack.push(0);
        //打印
        System.out.println(vertices[0].getVal());
        //遍历
        out:
        while (!stack.isEmpty()) {
            for (int i = currentIndex + 1; i < vertices.length; i++) {
                if (adjmat[currentIndex][i] == 1 && vertices[i].isVisited() == false) {
                    //把下一个元素压入栈中
                    stack.push(i);
                    vertices[i].setVisited(true);
                    System.out.println(vertices[i].getVal());
                    continue out;
                }
            }
            //弹出栈顶元素
            stack.pop();

            if (!stack.isEmpty()) {
                currentIndex = (int) stack.peek();
            }
        }
    }


    public static void main(String[] args) {
        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");
        Vertex v5 = new Vertex("E");

        Graph graph = new Graph(5);
        graph.add(v1);
        graph.add(v2);
        graph.add(v3);
        graph.add(v4);
        graph.add(v5);

        //增加边
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("A", "B");
        graph.addEdge("B", "D");
        graph.addEdge("B", "E");

        for (int[] a : graph.adjmat) {
            System.out.println(Arrays.toString(a));
        }

        graph.dfs();

    }

}
