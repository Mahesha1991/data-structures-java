package org.mahesha.bst;

public class BSTOps {

    private BSTNode root;

    public BSTOps() {
        root = null;
    }

    public boolean insert(int data) {
        if (root == null) {
            root = new BSTNode(data);
            return true;
        }
        return add(root, data);
    }

    private boolean add(BSTNode temp, int data) {

        if (temp.data < data) {
            if (temp.right == null) {
                temp.right = new BSTNode(data);
                return true;
            }
            add(temp.right, data);
        } else if (temp.data > data) {
            if (temp.left == null) {
                temp.left = new BSTNode(data);
                return true;
            }
            add(temp.left, data);
        } else {
            return false;
        }
        return true;
    }

    public void inOrder(BSTNode temp) {
        if (temp != null) {
            inOrder(temp.left);
            System.out.print(temp.data + " ");
            inOrder(temp.right);
        }
    }

    public BSTNode getRoot() {
        return root;
    }

    public void setRoot(BSTNode temp) {
        root = temp;
    }

    public void preOrder(BSTNode temp) {
        if (temp != null) {
            System.out.print(temp.data + " ");
            preOrder(temp.left);
            preOrder(temp.right);
        }
    }

    public void postOrder(BSTNode temp) {
        if (temp != null) {
            postOrder(temp.left);
            postOrder(temp.right);
            System.out.print(temp.data + " ");
        }
    }

    public BSTNode minValueNode(BSTNode temp) {

        while (temp != null && temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    public BSTNode remove(BSTNode temp, int data) {
        if (temp == null) {
            return null;
        }

        if (data > temp.data) {
            temp.right = remove(temp.right, data);
        } else if (data < temp.data) {
            temp.left = remove(temp.left, data);
        } else {
            if (temp.left == null) {
                return temp.right;
            } else if (temp.right == null) {
                return temp.left;
            } else {
                BSTNode minNode = minValueNode(temp.right);
                temp.data = minNode.data;
                temp.right = remove(temp.right, temp.data);
            }
        }
        return temp;
    }
}
