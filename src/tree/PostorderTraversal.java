package tree;

public class PostorderTraversal {
    private static void postorder(Node node){
        if (node == null){
            return;
        }

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.val+", ");
    }
    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(20);
        node.right = new Node(30);
        node.left.left = new Node(40);
        node.left.right = new Node(50);
        node.right.left = new Node(60);
        node.right.right = new Node(70);

        postorder(node);
    }
}
