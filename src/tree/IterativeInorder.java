package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class IterativeInorder {
    private static List<Integer> inorder(Node root){
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (true){
            if (node != null){
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty()){
                    break;
                }
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
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

        System.out.println(Arrays.toString(inorder(root).toArray()));
    }
}
