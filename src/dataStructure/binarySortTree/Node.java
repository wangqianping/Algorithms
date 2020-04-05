package binarySortTree;

public class Node {

    Node left;
    Node right;
    int val;

    public Node(int val) {
        this.val = val;
    }

    /**
     * 添加一个节点
     *
     * @param node
     */
    public void add(Node node) {

        if (node == null) {
            return;
        }

        if (node.val < this.val) {

            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }

        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }

    }

    /**
     * 中序遍历二叉排序树
     * 结果刚好是从小到大排列
     */
    public void midShow(Node node) {

        if (node != null) {
            midShow(node.left);
            System.out.println(node.val);
            midShow(node.right);
        }
    }

    /**
     * 查找
     *
     * @param val
     * @return
     */
    public Node search(int val) {

        if (val == this.val) {
            return this;
        } else if (val < this.val) {
            if (left == null) {
                return null;
            }
            return this.left.search(val);
        } else {
            if (right == null) {
                return null;
            }
            return this.right.search(val);
        }

    }

    public Node searchParent(int val) {
        if ((this.left != null && this.left.val == val) || (this.right != null && this.right.val == val)) {
            return this;
        } else {
            if (this.val > val) {
                if (this.left != null) {
                    return this.left.searchParent(val);
                }
            } else {
                if (this.right != null) {
                    return this.right.searchParent(val);
                }
            }
        }

        return null;
    }
}
