package avl;

public class Node {

    Node left;
    Node right;
    int val;

    public Node(int val) {
        this.val = val;
    }

    /**
     * 返回当前节点的高度
     *
     * @return
     */
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    public int leftHight() {
        if (left == null) {
            return 0;
        }

        return left.height();
    }


    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
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

        //检查是否平衡
        //右旋转
        if (leftHight() - rightHeight() > 1) {
            //双旋转
            if (left != null && left.leftHight() < left.rightHeight()) {
                left.leftRotate();
                rightRotate();
            } else {
                rightRotate();
            }
        }
        //左旋转
        if (leftHight() - rightHeight() < -1) {
            //双旋转
            if (right != null && right.leftHight() < right.rightHeight()) {
                right.rightRotate();
                leftRotate();
            } else {
                leftRotate();
            }
        }

    }

    //左旋转的具体不走
    private void leftRotate() {
        //创建一个新节点，值为当前节点的值
        Node node = new Node(this.val);
        //当前节点的左子树当作新节点的左子树
        node.left = this.left;
        //把新节点的右子树设置为当前节点的右子树的左子树
        node.right = this.right.left;
        //把当前节点的值设置为当前节点的右子节点的值
        this.val = this.right.val;
        //把当前节点的右子树设置为当前节点的右子树右子树(相当于删掉当前节点的右子树)
        this.right = right.right;
        //当前节点的左子树设置为新节点
        this.left = node;
    }

    //右旋转的具体步骤
    private void rightRotate() {
        //创建一个新节点，值为当前节点的值
        Node node = new Node(this.val);
        //当前节点的右子树当作新节点的右子树
        node.right = this.right;
        //当前节点的左子树的右子树作为新节点的左子树
        node.left = this.left.right;
        //把当前节点的值设置为当前节点的左子节点的值
        this.val = this.left.val;
        //把当前节点的左子树设置为当前节点的左子树的左子树(相当于删掉当前节点的左子树)
        this.left = left.left;
        //当前节点的右子树设置为新节点
        this.right = node;
    }
}
