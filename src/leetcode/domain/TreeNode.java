package leetcode.domain;

/**
 * @desc 官方定义树结构
 * @author GaryLeeeee
 * @date 2021/06/21 23:46
 *
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) { this.val = val; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
