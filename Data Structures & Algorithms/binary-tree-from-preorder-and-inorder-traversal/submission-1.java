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

    private int preorderIndex = 0;

    private Map<Integer, Integer> inorderIndexMap = new HashMap<>();

    private int[] preorder;


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        this.preorder = preorder;

        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(0, inorder.length - 1);

    }


    private TreeNode build(int inStart, int inEnd) {

        if (inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preorderIndex];

        preorderIndex++;

        TreeNode root = new TreeNode(rootVal);

        int mid = inorderIndexMap.get(rootVal);

        root.left = build(inStart, mid - 1);

        root.right = build(mid + 1, inEnd);

        return root;

    }


}
