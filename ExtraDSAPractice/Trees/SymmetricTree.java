import java.util.*;

class SymmetricTree {
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
    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return checkSymmetry(root.left, root.right);
    }
    
    public static boolean checkSymmetry(TreeNode head1, TreeNode head2) {
        if(head1 == null && head2 == null) return true;
        if(head1 == null || head2 == null || head1.data != head2.data) return false;
        boolean leftSubTree = checkSymmetry(head1.left, head2.right);
        boolean rightSubTree = checkSymmetry(head1.right, head2.left)
        return leftSubTree && rightSubTree;
    }
}