import java.util.*;

class MirrorTree {
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

    void mirror(TreeNode node) {
        if(node == null) return;
        if(node.left != null) {
            mirror(node.left);
        }
        if(node.right != null) {
            mirror(node.right);
        }
        Node temp = node.right;
        node.right = node.left;
        node.left = temp;
    }


}