package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    private static List<List<Integer>> levelOrderTraversal(Node root){
        if (root == null){
            return new ArrayList<>();
        }
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.offer(root);
        int currentLevel = 0;
        while (!queue.isEmpty()){
            int len = queue.size();
            result.add(new ArrayList<>());
            for (int i = 0; i<len; i++){
                Node node = queue.poll();
                result.get(currentLevel).add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            currentLevel++;
        }
        return result;
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(12);
        root.right = new Node(13);

        root.left.left = new Node(7);
        root.left.right = new Node(14);

        root.right.right = new Node(2);

        root.left.left.left = new Node(17);
        root.left.left.right = new Node(23);

        root.left.right.left = new Node(27);
        root.left.right.right = new Node(3);

        root.right.right.left = new Node(8);
        root.right.right.right = new Node(11);

        List<List<Integer>> traversal = levelOrderTraversal(root);

        for (List<Integer> level : traversal){
            for (Integer val : level){
                System.out.print(val+" , ");
            }
            System.out.println();
        }
    }
}
