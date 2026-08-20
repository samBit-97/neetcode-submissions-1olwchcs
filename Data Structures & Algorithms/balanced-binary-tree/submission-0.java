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
    private class Result {
        boolean balanced;
        int height;

        public Result(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }
    }
 
    public boolean isBalanced(TreeNode root) {
        Result res = helper(root);
        return res.balanced == true;
    }

    private Result helper(TreeNode root) {
        if (root == null) {
            return new Result(true, 0);
        }

        Result left = helper(root.left);
        Result right = helper(root.right);

        boolean balanced =
                left.balanced 
                && right.balanced 
                && Math.abs(left.height - right.height) <= 1;
        int height = 1 + Math.max(left.height, right.height);

        return new Result(balanced, height);
    }
}
