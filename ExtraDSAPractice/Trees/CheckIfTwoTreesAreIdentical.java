import java.util.*;

public class CheckIfTwoTreesAreIdentical {
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

    public static boolean isIdentical(TreeNode root1, TreeNode root2) {
        // if leaf nodes of both trees are null
        if(root1 == null && root2 == null) {
	        return true;
	    }
        // if leaf node of any one tree is null
	    if(root1 == null || root2 == null) {
	        return false;
	    }
        // if nodes data is not same
        if(root1.data != root2.data) {
	        return false;
	    }
	    boolean leftSubTree = isIdentical(root1.left, root2.left);
	    boolean rightSubTree = isIdentical(root1.right, root2.right);
	    return leftSubTree && rightSubTree;
    }
}