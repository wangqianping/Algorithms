package binarySortTree;

/**
 * 二叉排序树
 */
public class BinarySortTree {

    Node root;

    public void add(Node node) {
        if (root == null) {
            this.root = node;
        } else {
            root.add(node);
        }
    }

    /**
     * 中序遍历二叉排序树
     * 结果刚好是从小到大排列
     */
    public void midShow() {
        if (root == null) {
            return;
        }
        root.midShow(root);
    }

    public Node search(int val) {

        if (root != null) {
            return root.search(val);
        }
        return null;
    }

    public void delete(int val) {

        if (root == null) {
            return;
        } else {
            Node node = root.search(val);
            if (node == null) {
                return;
            }
            Node parent = root.searchParent(val);
            //要删除的节点是叶子节点
            if (node.left == null && node.right == null) {
                //如果是左节点
                if (parent.left.val == val) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else if (node.left != null && node.right != null) {
                //要删除的节点有两个子节点:则只需删除右子树中最小的节点并将该节点的值赋给要删除的点
                int min = this.deleteMin(node.right);
                node.val = min;
            }else{
                //要删除的节点只有一个子节点
                if(node.left!=null){
                    if (parent.left.val == val) {
                        parent.left = node.left;
                    } else {
                        parent.right = node.left;
                    }
                }else{
                    if (parent.left.val == val) {
                        parent.left = node.right;
                    } else {
                        parent.right = node.right;
                    }
                }

            }

        }
    }

    /**
     * 删除一棵树中最小的节点
     * @param node
     * @return
     */
    private int deleteMin(Node node) {

        Node target = node;

        while(target.left!=null){
            target = target.left;
        }

        delete(target.val);

        return target.val;
    }

    /**
     * 寻找父节点
     *
     * @param val
     */
    public Node searchParent(int val) {
        return root.searchParent(val);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i : arr) {
            binarySortTree.add(new Node(i));
        }
        binarySortTree.midShow();

        Node node = binarySortTree.search(10);
        System.out.println(node);
        Node node1 = binarySortTree.search(20);
        System.out.println(node1);

        binarySortTree.delete(3);
        binarySortTree.midShow();

    }

}
