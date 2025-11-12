package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class IterativePostorder {
    private static List<Integer> postorder(Node root){
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty()){
            Node node = stack1.pop();

            stack2.push(node);

            if (node.left != null){
                stack1.push(node.left);
            }

            if (node.right != null){
                stack1.push(node.right);
            }
        }

        while (!stack2.isEmpty()){
            Node node = stack2.pop();
            result.add(node.val);
        }

        return result;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.left.right.left = new Node(5);
        root.left.right.right = new Node(6);

        System.out.println(Arrays.toString(postorder(root).toArray()));
    }
}
