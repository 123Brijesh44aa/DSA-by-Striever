// file: BinaryTreeDemo.java

import java.util.*;

class BinaryTree {

    static class Node {

        int val;
        Node left, right;

        Node(int v) {
            val = v;
            left = right = null;
        }
    }
    Node root;

    // level-order insert
    public void insert(int v) {
        Node n = new Node(v);
        if (root == null) {
            root = n;
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.left == null) {
                cur.left = n;
                return;
            } else {
                q.add(cur.left);
            }
            if (cur.right == null) {
                cur.right = n;
                return;
            } else {
                q.add(cur.right);
            }
        }
    }

    public void preorder(Node r) {
        if (r == null) {
            return;
        
        }System.out.print(r.val + " ");
        preorder(r.left);
        preorder(r.right);
    }

    public void inorder(Node r) {
        if (r == null) {
            return;
        
        }inorder(r.left);
        System.out.print(r.val + " ");
        inorder(r.right);
    }

    public void postorder(Node r) {
        if (r == null) {
            return;
        
        }postorder(r.left);
        postorder(r.right);
        System.out.print(r.val + " ");
    }

    // delete: replace target's value by deepest node and remove deepest node
    private Node getDeepestParent() {
        if (root == null) {
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node prev = null, cur = null;
        while (!q.isEmpty()) {
            cur = q.poll();
            if (cur.left != null) {
                q.add(cur.left);
                prev = cur;
            }
            if (cur.right != null) {
                q.add(cur.right);
                prev = cur;
            }
        }
        return prev; // parent of deepest (null if root is deepest)
    }

    private Node getDeepest() {
        if (root == null) {
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node cur = null;
        while (!q.isEmpty()) {
            cur = q.poll();
            if (cur.left != null) {
                q.add(cur.left);
            
            }if (cur.right != null) {
                q.add(cur.right);
        
            }}
        return cur;
    }

    public void delete(int key) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (root.val == key) {
                root = null;
            }
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node toDelete = null, cur = null;
        while (!q.isEmpty()) {
            cur = q.poll();
            if (cur.val == key) {
                toDelete = cur;
            }
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
        if (toDelete == null) {
            return;
        }
        Node deepest = getDeepest();
        Node parentDeep = getDeepestParent();
        toDelete.val = deepest.val;
        if (parentDeep == null) {
            root = null;
        } else {
            if (parentDeep.right == deepest) {
                parentDeep.right = null; 
            }else if (parentDeep.left == deepest) {
                parentDeep.left = null;
            }
        }
    }

    public int countNodes(Node r) {
        if (r == null) {
            return 0;
        
        }return 1 + countNodes(r.left) + countNodes(r.right);
    }

    public int countLeaves(Node r) {
        if (r == null) {
            return 0;
        
        }if (r.left == null && r.right == null) {
            return 1;
        
        }return countLeaves(r.left) + countLeaves(r.right);
    }

    public int countInternal(Node r) {
        int tot = countNodes(r);
        int leaves = countLeaves(r);
        return (tot == 0 ? 0 : tot - leaves);
    }

    // sample main to test
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int[] vals = {1, 2, 3, 4, 5, 6};
        for (int v : vals) {
            bt.insert(v);
        }
        System.out.print("Preorder: ");
        bt.preorder(bt.root);
        System.out.println();
        System.out.print("Inorder: ");
        bt.inorder(bt.root);
        System.out.println();
        System.out.print("Postorder: ");
        bt.postorder(bt.root);
        System.out.println();
        System.out.println("Total nodes: " + bt.countNodes(bt.root));
        System.out.println("Leaf nodes: " + bt.countLeaves(bt.root));
        System.out.println("Internal nodes: " + bt.countInternal(bt.root));
        System.out.println("Deleting 2");
        bt.delete(2);
        System.out.print("Inorder after delete: ");
        bt.inorder(bt.root);
        System.out.println();
    }
}
