package leetcode.middle;

/**
 * @desc
 *  题目：198. 打家劫舍
 *  描述：给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *  链接：https://leetcode-cn.com/problems/house-robber/
 *  参考题解：无
 *  难度(自己)：简单
 * @author GaryLeeeee
 * @date 2021/06/13 22:37
 *
 */
public class HouseRobber {
    /**
     * 解法：动态规划
     * 思路：遍历数组每一步存当前最大值即可
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        //应该是截止最大值
        int[] result = new int[nums.length];

        int cur = nums[0];
        int max = cur;
        for (int i = 0; i < nums.length; i++) {
            if (i <= 1) {
                cur = nums[i];
            } else {
                cur = Math.max(result[i - 2] + nums[i], result[i - 1]);
            }

            //注意这两步不能颠倒(不然比如2,0,0,2就会有问题)
            max = Math.max(max, cur);
            result[i] = max;

        }

        return max;
    }

    /**
     * 例子：
     *  输入：[1,2,3,1]
     *  输出：4
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(new HouseRobber().rob(nums));
    }
}
