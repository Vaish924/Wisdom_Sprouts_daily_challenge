// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class SymmetricTree {

    // Main function to check symmetry
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true; // Empty tree is symmetric
        return isMirror(root.left, root.right);
    }

    // Helper function to check if two trees are mirror images
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;  // Both null → symmetric
        if (t1 == null || t2 == null) return false; // Only one null → not symmetric

        // Check value + mirror structure
        return (t1.val == t2.val)
                && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }

    // Example usage
    public static void main(String[] args) {
        SymmetricTree tree = new SymmetricTree();

        // Build sample tree: [1,2,2,3,4,4,3]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(tree.isSymmetric(root)); // Output: true
    }
}
