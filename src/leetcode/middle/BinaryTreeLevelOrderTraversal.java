package leetcode.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @desc
 *  题目：102. 二叉树的层级遍历
 *  描述：给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *  链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *  参考题解：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/er-cha-shu-de-ceng-xu-bian-li-by-leetcode-solution/
 *  难度(自己)：简单看题解后可完成
 *  备注：一开始不清楚有这种解法，后面看到可以这么解就会了
 * @author GaryLeeeee
 * @date 2021/06/14 18:10
 *
 */
public class BinaryTreeLevelOrderTraversal {
    /**
     * 解法：广度优先搜索
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        //定义队列，使每次都取同一层的出来(见下面ps1)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //每次while遍历时queue都是新的一层
        while (!queue.isEmpty()) {
            //存放全一层的node
            List<Integer> level = new ArrayList<>();
            //需要单独声明，不然queue size会变化
            int size = queue.size();
            //ps1 当前while循环只取当前层数的，然后存下一层的
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            result.add(level);
        }

        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 例子：
     *  输入：[3,9,20,null,null,15,7]
     *  输出：[
     [3],
     [9,20],
     [15,7]
     ]
     */
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(treeNode));

    }
}
