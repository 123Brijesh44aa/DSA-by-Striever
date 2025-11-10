package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class IterativePreorder {
   private static List<Integer> preorder(Node root){
       List<Integer> preorder = new ArrayList<>();
       Stack<Node> stack = new Stack<>();
       if (root == null) {
           return preorder;
       }
       stack.push(root);
       while (!stack.isEmpty()){
           Node node = stack.pop();
           preorder.add(node.val);
           if (node.right != null){stack.push(node.right);}
           if (node.left != null){stack.push(node.left);}
       }
       return preorder;
   }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.left.right.left = new Node(5);
        root.left.right.right = new Node(6);

        System.out.println(Arrays.toString(preorder(root).toArray()));
    }
}
