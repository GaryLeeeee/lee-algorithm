package leetcode.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc
 *  题目：560. 和为K的子数组
 *  描述：给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *  链接：https://leetcode-cn.com/problems/subarray-sum-equals-k/
 *  参考题解：https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/he-wei-kde-zi-shu-zu-by-leetcode-solution/
 *  难度(自己)：没思路，看了很久题解也不是很会做
 *  备注：前缀和，需要重做
 * @author GaryLeeeee
 * @date 2021/06/24 23:34
 *
 */
public class SubarraySumEqualsK {

    /**
     * 解法：前缀和+数组+哈希表
     * 思路：如果双重遍历时间复杂度会很高，所以在这基础上引入前缀和和哈希表，可以避免多次不必要的计算
     * 步骤：
     *  1.提供数组nums=[1 2 3 5 8]、k=8
     *  2.A:-------- <---k--->
     *    B:------------------
     *    如AB所示，我们要计算有k长度的连续数组，完全可以通过B-A，其中A、B都是当前位置的前缀和(*)
     *  3.由2我们可列出前缀和[1 3 6 11 19]
     *  4.由2和3我们知道3就是对应2的B，因为A+k=B，所以我们只要找A=B-k的A是否存在(B和k已知)
     *
     *
     * @param nums 提供的整数数组
     * @param k 连续子数组和
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        //结果
        int count = 0;
        //当前和
        int pre = 0;
        //key是和，value是次数
        Map<Integer, Integer> map = new HashMap<>();
        //是为了那种从0-i下标就是符合连续子数组和的
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            //计算前缀和
            pre += nums[i];
            //如果存在前缀和
            int num = pre - k;
            if (map.containsKey(num)) {
                //意思就是连上之前的情况也可以有对应count
                //比如nums=[3,-3,2,-2,0,3]、k=0
                //对应的前缀和为sums=[3,0,2,0,0,3]
                //所以符合条件的连续子数组会有[3,-3][2,-2][0]由于连上的情况就可以有[3,-3,2,-2][3,-3,2,-2,0][2,-2,0[
                count += map.get(num);
            }

            //如果没存在过，就初始化1，存在就加1(给上边提供count+=)
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return count;
    }

    /**
     * 例子：
     *  输入：[1,1,1]
     *  输出：2
     */
    public static void main(String[] args) {
        int nums[] = new int[]{1, 1, 1};
        int k = 2;
        System.out.println(new SubarraySumEqualsK().subarraySum(nums, k));
    }
}
