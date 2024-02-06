import java.util.*;

// Solution 1: Using Height and Diameter Pair Class
class DiameterOfTree {
    class Solution1 {
        private class DiaPair {
            int height;
            int diameter;

            public DiaPair() {
            }

            public DiaPair(int height, int diameter) {
                this.height = height;
                this.diameter = diameter;
            }
        }

        public int diameter(Node root) {
            if (root == null)
                return 0;
            DiaPair ans = findDiameter(root);
            return ans.diameter + 1;
        }

        public DiaPair findDiameter(Node root) { // O(n)
            if (root == null)
                return new DiaPair(-1, 0);

            DiaPair lhs = findDiameter(root.left);
            DiaPair rhs = findDiameter(root.right);

            DiaPair myPair = new DiaPair();
            myPair.diameter = Math.max(lhs.height + rhs.height + 2, Math.max(lhs.diameter, rhs.diameter));
            myPair.height = Math.max(lhs.height, rhs.height) + 1;

            return myPair;
        }
    }

    class Solution2 {
        int dia = 0;

        // Function to find the diameter of a Binary Tree.
        public int calculateDiameter(Node root) {
            // if node becomes null, we return 0.
            if (root == null)
                return 0;

            // calling the calculateDiameter function recursively for the left and
            // right subtrees to find their heights.
            int l = calculateDiameter(root.left);
            int r = calculateDiameter(root.right);

            // storing the maximum possible value of l+r+1 in diameter.
            if (l + r + 1 > dia)
                dia = l + r + 1;

            // returning height of subtree.
            return 1 + Math.max(l, r);
        }

        // Function to return the diameter of a Binary Tree.
        public int diameter(Node root) {
            // calling the function to find the result.
            calculateDiameter(root);
            // returning the result.
            return dia;
        }

    }
}