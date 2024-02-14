/**
 * QUES 6 -> Trim a binary search tree (LEETCODE - 669)
 * 
 * Company - Adobe
 * 
 * #revisewitharsh
 * #6companies30dayschallenge
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        if (root.val < low) {
            return root.right;
        }

        if (root.val > high) {
            return root.left;
        }
        return root;
    }
}