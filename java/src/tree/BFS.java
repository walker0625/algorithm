package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public static List seachTreeByBfs(TreeNode node) {
        List<Integer> visited = new ArrayList<>();

        if (node == null) {
            return visited;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll(); // 앞부분 pop() <-> remove() : 뒤부터 pop()
            visited.add(curNode.value);

            if(curNode.left != null) {
                queue.add(curNode.left);
            }
            if(curNode.right != null) {
                queue.add(curNode.right);
            }
        }

        return visited;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        seachTreeByBfs(root).forEach(System.out::println);
    }

}
