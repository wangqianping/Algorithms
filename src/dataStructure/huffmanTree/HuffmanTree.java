package huffmanTree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 赫夫曼树
 */
public class HuffmanTree {

    //创建赫夫曼树
    public Node creatHuffmanTree(int[] arr){

        List<Node> nodes = new ArrayList<>();
        for(int val : arr){
            nodes.add(new Node(val));
        }

        while(nodes.size()>1){
            //1.排序
            nodes.sort(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return -(o1.val-o2.val);//降序
                }
            });
            //2.取出权值最小的两个二叉树构建新的二叉树
            Node left = nodes.get(nodes.size()-1);
            Node right = nodes.get(nodes.size()-2);
            Node newNode = new Node(left.val+right.val);
            newNode.left=left;
            newNode.right=right;
            //3.除掉取出的两个小的二叉树，将新的二叉树放进原数组,循环直到最后nodes中只有一个node
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(newNode);
        }
        return nodes.get(0);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,7,8,29,5,11,23,14};
        HuffmanTree huffmanTree = new HuffmanTree();
        Node node = huffmanTree.creatHuffmanTree(arr);
        System.out.println(node);
    }


}
