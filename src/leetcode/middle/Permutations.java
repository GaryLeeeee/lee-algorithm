package leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc
 *  题目：46. 全排列
 *  描述：给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *  链接：https://leetcode-cn.com/problems/permutations/
 * @author GaryLeeeee
 * @date 2021/06/06 18:04
 *
 */
public class Permutations {
    /**
     * 解法：回溯算法
     * 1.通过变量path记录路径，result记录结果，nums记录选择列表
     * 2.结束条件：到达决策树底层，无法再做选择的条件(本题是到叶子结点视为结束)
     * 3.通过做选择和撤销选择实现决策树的回溯
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> path = new ArrayList<>();

        this.backtrack(path, nums, result);

        return result;
    }

    /**
     * 回溯算法
     * 结束条件，path.size()=nums.length(到达叶子结点)
     * @param path 路径
     * @param nums 选择列表
     * @param result 结果集
     */
    public void backtrack(
            List<Integer> path,
            int[] nums,
            List<List<Integer>> result
    ){
        //触发结束的条件
        if(path.size() == nums.length){//这里是path不是result
            result.add(new ArrayList<>(path));//!!!!这里需要new，否则会动到原数据
            return;
        }

        for(int i=0;i<nums.length;i++){
            //去重
            if(path.contains(nums[i])){
                continue;
            }

            //做选择
            path.add(nums[i]);

            //进入下一层决策树
            backtrack(path, nums, result);

            //撤销选择
            path.remove(path.size()-1);
        }

    }

    /**
     * 例子：
     *  输入：nums = [1,2,3]
     *  输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(new Permutations().permute(nums));
    }
}
