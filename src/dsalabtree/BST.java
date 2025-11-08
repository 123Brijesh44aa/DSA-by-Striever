// file: BSTDemo.java

class BST {

    static class Node {

        int key;
        Node left, right;

        Node(int k) {
            key = k;
        }
    }
    Node root;

    public Node insert(Node r, int key) {
        if (r == null) {
            return new Node(key);
        }
        if (key < r.key) {
            r.left = insert(r.left, key);
        } else if (key > r.key) {
            r.right = insert(r.right, key);
        }
        return r;
    }

    public Node search(Node r, int key) {
        if (r == null || r.key == key) {
            return r;
        }
        return key < r.key ? search(r.left, key) : search(r.right, key);
    }

    public Node findMin(Node r) {
        if (r == null) {
            return null;

        }
        while (r.left != null) {
            r = r.left;

        }
        return r;
    }

    public Node findMax(Node r) {
        if (r == null) {
            return null;

        }
        while (r.right != null) {
            r = r.right;

        }
        return r;
    }

    public Node delete(Node r, int key) {
        if (r == null) {
            return null;
        }
        if (key < r.key) {
            r.left = delete(r.left, key);
        } else if (key > r.key) {
            r.right = delete(r.right, key);
        } else {
            if (r.left == null) {
                return r.right;
            } else if (r.right == null) {
                return r.left;
            } else {
                Node succ = findMin(r.right);
                r.key = succ.key;
                r.right = delete(r.right, succ.key);
            }
        }
        return r;
    }

    public void inorder(Node r) {
        if (r == null) {
            return;

        }
        inorder(r.left);
        System.out.print(r.key + " ");
        inorder(r.right);
    }

    public static void main(String[] args) {
        BST t = new BST();
        int[] vals = {50, 30, 70, 20, 40, 60, 80};
        for (int v : vals) {
            t.root = t.insert(t.root, v);
        }
        System.out.print("BST inorder: ");
        t.inorder(t.root);
        System.out.println();
        System.out.println("Min: " + t.findMin(t.root).key);
        System.out.println("Max: " + t.findMax(t.root).key);
        System.out.println("Delete 50");
        t.root = t.delete(t.root, 50);
        System.out.print("Inorder after delete: ");
        t.inorder(t.root);
        System.out.println();
        System.out.println("Search 60: " + (t.search(t.root, 60) != null));
    }
}
