package leetcode.middle;

/**
 * @desc
 *  题目：494. 目标和
 *  描述：给你一个整数数组 nums 和一个整数 target 。
向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。

 *  链接：https://leetcode-cn.com/problems/target-sum/
 *  参考题解：https://leetcode-cn.com/problems/target-sum/solution/mu-biao-he-by-leetcode-solution-o0cp/
 *  难度(自己)：还好，知道可以用回溯算法后醍醐灌顶(还是得重做多做，一开始没这思路)
 * @author GaryLeeeee
 * @date 2021/06/25 23:30
 *
 */
public class TargetSum {
    int count = 0;

    /**
     * 解法：数组+回溯
     * 思路：把对于后面一个数的+-当做左右子树，然后通过回溯算法即可遍历所有情况
     * 注意：每一个数都可以+-(包括第一个数)
     * 步骤：
     *  1.设置层级level(达到最后一个数就可判断sum)
     *  2.当前数操作下一个数
     *         1
     *      +/  \-
     *      1   1
     *      2.1 当前数+下一个数
     *      2.2 当前数-下一个数
     *  3.循环2 下一个数操作下下一个数。。。
     *          1
     *      +/    \-
     *      1      1
     *   +/  \- +/  \-
     *   1   1  1    1
     *  4.到达最后一个数(level=length)，判断sum==target(true则size++)
     *  5.返回size
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        this.backtrack(nums, target, 0, 0);//注意这里不是0开始
        return count;
    }

    /**
     *
     * @param nums
     * @param target
     * @param level 结束条件level==nums.length
     * @param sum 截止当前位置表达式总和
     */
    private void backtrack(int[] nums, int target, int level, int sum) {
        //结束条件判断(到达最后一个数)
        if (level == nums.length) {
            //判断最终表达式是否等于target
            if (sum == target) {
                count++;
            }
            return;
        }

        //要注意，第一层也是有+-的。。。
        //+
        this.backtrack(nums, target, level + 1, sum + nums[level]);
        //-
        this.backtrack(nums, target, level + 1, sum - nums[level]);
    }

    /**
     * 例子：
     *  输入：nums = [1,1,1,1,1], target = 3
     *  输出：3
     */
    public static void main(String[] args) {
        int nums[] = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(new TargetSum().findTargetSumWays(nums, target));
    }
}
