package leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @desc
 *  题目：15. 三数之和
 *  描述：给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
          注意：答案中不可以包含重复的三元组。
 *  链接：https://leetcode-cn.com/problems/3sum/
 *  参考题解：https://leetcode-cn.com/problems/3sum/solution/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
 * @author GaryLeeeee
 * @date 2021/06/06 20:21
 *
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        //少于3个直接返回(不存在符合要求结果)
        if(length<3){
            return result;
        }

        //可以直接暴力遍历，但是会有很多次无效判断，所以看看能不能尽可能跳过这无效判断
        //排序数组
        Arrays.sort(nums);
        //双指针
        int left;
        int right;
        for(int i=0;i<length-2;i++){//注意边界处理
            //如果nums[i]==nums[i-1]，则不用处理(去重)
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }

            left = i + 1;
            right = length - 1;
            //循环到左右指针相遇即可停
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum==0){
                    //符合要求，存起来
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    //左移右移不能等于当前值(结果要去重) 不能越界
                    while(left<right && nums[left+1]==nums[left]){
                        left++;
                    }
                    left++;
                    while(right>left && nums[right-1]==nums[right]){
                        right--;
                    }
                    right--;
                }else if(sum<0){
                    left++;
                }else if(sum>0){
                    right--;
                }
            }
        }

        return result;

    }

    /**
     * 例子：
     *  输入：nums = [-1,0,1,2,-1,-4]
     *  输出：[[-1,-1,2],[-1,0,1]]
     */
    public static void main(String[] args) {
        int nums[] = new int[]{-1,0,1,2,-1,-4};
        System.out.println(new ThreeSum().threeSum(nums));
    }
}
