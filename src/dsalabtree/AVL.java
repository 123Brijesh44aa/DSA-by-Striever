// file: AVLDemo.java

class AVL {

    static class Node {

        int key, height;
        Node left, right;

        Node(int k) {
            key = k;
            height = 1;
        }
    }
    Node root;

    int height(Node n) {
        return n == null ? 0 : n.height;
    }

    int balance(Node n) {
        return n == null ? 0 : height(n.left) - height(n.right);
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }
        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            return node;
        }
        node.height = 1 + Math.max(height(node.left), height(node.right));
        int bal = balance(node);
        // LL
        if (bal > 1 && key < node.left.key) {
            return rightRotate(node);
        }
        // RR
        if (bal < -1 && key > node.right.key) {
            return leftRotate(node);
        }
        // LR
        if (bal > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // RL
        if (bal < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    void inorder(Node r) {
        if (r == null) {
            return;

        }
        inorder(r.left);
        System.out.print(r.key + " ");
        inorder(r.right);
    }

    public static void main(String[] args) {
        AVL tree = new AVL();
        int[] vals = {10, 20, 30, 40, 50, 25};
        for (int v : vals) {
            tree.root = tree.insert(tree.root, v);
        }
        System.out.print("AVL inorder: ");
        tree.inorder(tree.root);
        System.out.println();
    }
}
