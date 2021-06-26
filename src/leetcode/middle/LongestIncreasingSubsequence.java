package leetcode.middle;

/**
 * @desc
 *  题目：300. 最长递增子序列
 *  描述：给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *  链接：https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *  参考题解：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti/
 *  难度(自己)：简单看题解会思路即可做(可以再重做)
 * @author GaryLeeeee
 * @date 2021/06/26 18:12
 *
 */
public class LongestIncreasingSubsequence {
    /**
     * 解法：回溯算法
     * 思路：遍历数组从左到右，用dp[]数组存储截止当前位置的max值
     * 解法：
     *  1.遍历数组，判断当前数和之前数大小
     *  2.如果之前数没有比当前数大的，则当前位置dp[i]=1(代表最长子序列长度为1)
     *  3.如果之前数有比当前数大的，就判断之前数dp[i]=Math.max(dp[pre],dp[i])
     *  4.每遍历一次数组，就更新max=Math.max(max,dp[i])
     *  5.返回max
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        //遍历数组，用dp数组存截止某个位置的最长递增子序列长度即可
        int dp[] = new int[nums.length];
        //结果(最长递增子序列)
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            //判断前面是否有比当前数小的递增子序列
            for (int j = 0; j < i; j++) {
                //如果之前数比当前数小，说明加上当前数是一个递增子序列，记录大小
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }

            //加上当前位置
            dp[i] = dp[i] + 1;
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    /**
     * 例子：
     *  输入：nums = [10,9,2,5,3,7,101,18]
     *  输出：4
     */
    public static void main(String[] args) {
        int nums[] = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));
    }
}
