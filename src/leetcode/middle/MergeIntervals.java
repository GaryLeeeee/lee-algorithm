package leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @desc
 *  题目：56. 合并区间
 *  描述：以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *  链接：https://leetcode-cn.com/problems/merge-intervals/
 *  参考题解：https://leetcode-cn.com/problems/merge-intervals/solution/he-bing-qu-jian-by-leetcode-solution/
 *  难度(自己)：简单看题解后可完成
 * @author GaryLeeeee
 * @date 2021/06/13 19:19
 *
 */
public class MergeIntervals {
    /**
     * 解法：排序+数组
     * 思路：先排序区间，遍历区间数组将重叠部分合到一起
     * 步骤：
     *  1.根据区间左值排序
     *  2.遍历判断entry的左值与结果值前面一个pre的右值对比，如果大于则新增add，其他情况则修改pre的右值
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            //获取区间左右值
            int left = intervals[i][0], right = intervals[i][1];
            //获取前一个区间(第一个不用)
            if (result.isEmpty()) {
                result.add(new int[]{left, right});
            }
            int[] pre = result.get(result.size() - 1);
            //前后区间重叠则整合，不重叠则新增
            if (left > pre[1]) {
                result.add(new int[]{left, right});
            } else {
                //如果重合则修改原区间
                pre[1] = Math.max(right, pre[1]);
            }

        }

        return result.toArray(new int[result.size()][]);
    }

    /**
     * 例子：
     *  输入：[[1,3],[2,6],[8,10],[15,18]]
     *  输出：[[1,6],[8,10],[15,18]]
     */
    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };

        int[][] result = new MergeIntervals().merge(intervals);
        for (int[] i : result) {
            System.out.println(Arrays.toString(i));
        }
    }
}
