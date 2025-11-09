package tree;

public class PreorderTraversal {

    private static void preorder(Node node){
        if (node == null){
            return;
        }

        System.out.print(node.val+", ");
        preorder(node.left);
        preorder(node.right);
    }

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(20);
        node.right = new Node(30);
        node.left.left = new Node(40);
        node.left.right = new Node(50);
        node.right.left = new Node(60);
        node.right.right = new Node(70);

        preorder(node);
    }
}
