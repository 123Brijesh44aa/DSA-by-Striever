package tree;

public class InorderTraversal {

    private static void inorder(Node node){
        if (node == null){
            return;
        }
        inorder(node.left);
        System.out.print(node.val+", ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(20);
        node.right = new Node(30);
        node.left.left = new Node(40);
        node.left.right = new Node(50);
        node.right.left = new Node(60);
        node.right.right = new Node(70);

        inorder(node);
    }
}
