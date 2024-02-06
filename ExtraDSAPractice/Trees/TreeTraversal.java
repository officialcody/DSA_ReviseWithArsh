import java.util.*;

class TreeTraversal {
    private static class TreeNode {
        TreeNode left, right;
        int data;
        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        
        System.out.println("Pre-Order Traversal: ");
        printPreOrderTraversalTree(root);
        System.out.println();
        System.out.println("Post-Order Traversal: ");
        printPostOrderTraversalTree(root);
        System.out.println();
        System.out.println("In-Order Traversal: ");
        printInOrderTraversalTree(root);
        System.out.println();
        System.out.println("Level-Order Traversal: ");
        printLevelOrderTraversalTree(root);
    }

    // DFS -> Depth First Search -> Inorder
    public static void printInOrderTraversalTree(TreeNode root) {
        if(root == null) return;
        printInOrderTraversalTree(root.left);
        System.out.print(root.data + " ");
        printInOrderTraversalTree(root.right);
    }

    // DFS -> Depth First Search -> Preorder
    public static void printPreOrderTraversalTree(TreeNode root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        printPreOrderTraversalTree(root.left);
        printPreOrderTraversalTree(root.right);
    }

    // DFS -> Depth First Search -> Postorder
    public static void printPostOrderTraversalTree(TreeNode root) {
        if(root == null) return;
        printPostOrderTraversalTree(root.left);
        printPostOrderTraversalTree(root.right);
        System.out.print(root.data + " ");
    }

    // BFS -> Breadth First Seach -> Level Order
    public static void printLevelOrderTraversalTree(TreeNode root) {
        int height = calculateHeightOfTree(root);
        for(int i=1;i<=height;i++) {
            printCurrentLevelTreeNodes(root, i);
        }
    }

    public static int calculateHeightOfTree(TreeNode root) {
        if(root == null) return 0;
        int leftSubTreeHeight = calculateHeightOfTree(root.left);
        int rightSubTreeHeight = calculateHeightOfTree(root.right);
        if(leftSubTreeHeight > rightSubTreeHeight) {
            return leftSubTreeHeight + 1;
        }
        return rightSubTreeHeight + 1;
    }

    public static void printCurrentLevelTreeNodes(TreeNode root, int level) {
        if(root == null) return;
        if(level == 1) {
            System.out.print(root.data + " ");
        } else if(level > 1) {
            printCurrentLevelTreeNodes(root.left, level - 1);
            printCurrentLevelTreeNodes(root.right, level - 1);
        }
    }
}