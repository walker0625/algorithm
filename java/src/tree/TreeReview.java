package tree;

import java.util.AbstractMap.SimpleEntry;
import java.util.LinkedList;
import java.util.Queue;

public class TreeReview {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(searchTreeDepthByBfs(root));
        System.out.println(searchTreeDepthByDfs(root));
    }

    private static int searchTreeDepthByBfs(TreeNode root) {

        int maxDepth = 0;

        Queue<SimpleEntry> q = new LinkedList<>();
        q.add(new SimpleEntry(root, 1));

        while (!q.isEmpty()) {
            SimpleEntry nodeAndDepth = q.poll();
            TreeNode curNode = (TreeNode) nodeAndDepth.getKey();
            int curDepth = (int) nodeAndDepth.getValue();

            maxDepth = Math.max(maxDepth, curDepth);

            if(curNode.left != null) {
                q.add(new SimpleEntry(curNode.left, curDepth + 1));
            }

            if(curNode.right != null) {
                q.add(new SimpleEntry(curNode.right, curDepth + 1));
            }

        }

        return maxDepth;
    }

    private static int searchTreeDepthByDfs(TreeNode root) {

        // base case
        if (root == null) {
            return 0;
        }

        // 점화식
        int leftDepth = searchTreeDepthByDfs(root.left);
        int rightDepth = searchTreeDepthByDfs(root.right);

        // 구할 값
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
