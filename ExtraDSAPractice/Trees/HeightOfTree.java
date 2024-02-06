import java.util.*;

public class HeightOfTree {
    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;
        TreeNode() {}
        TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static int heightOfTree(TreeNode node) {
        if(node == null) return 0;
        int leftHeight = heightOfTree(node.left);
        int rightHeight = heightOfTree(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String [] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(heightOfTree(root));
    }
}