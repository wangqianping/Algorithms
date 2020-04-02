package huffmanCode;

public class Node {

    Byte date;  //值
    int weight;//权值
    Node left;
    Node right;


    public Node(Byte data,int weight){
        this.date = data;
        this.weight = weight;
    }
}
