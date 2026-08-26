/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {

        return dfs(root, null, null);
        
    }


    private boolean dfs(TreeNode node, Integer min, Integer max) {

        if (node == null) {
            return true;
        }

        if (min != null && node.val <= min) {
            return false;
        }


        if (max != null && node.val >= max) {
            return false;
        }


        boolean leftValid = dfs(node.left, min, node.val);

        boolean rightValid = dfs(node.right, node.val, max);

        return rightValid & leftValid;

    }
}
