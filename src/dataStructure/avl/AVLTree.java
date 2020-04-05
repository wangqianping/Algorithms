package avl;

/**
 * AVL树
 */
public class AVLTree {

    Node root;

    public void add(Node node) {
        if (root == null) {
            this.root = node;
        } else {
            root.add(node);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 9, 6, 7, 5, 4};
        AVLTree avlTree = new AVLTree();
        for (int i : arr) {
            avlTree.add(new Node(i));
        }
        //检查当前树的高度
        System.out.println(avlTree.root.height());
        System.out.println(avlTree.root.val);
    }

}
