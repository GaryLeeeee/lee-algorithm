package leetcode.middle;

import java.util.Stack;

/**
 * @desc
 *  题目：739. 每日温度
 *  描述：给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
          使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
          注意：答案中不可以包含重复的三元组。
 *  链接：https://leetcode-cn.com/problems/daily-temperatures/
 *  参考题解：https://leetcode-cn.com/problems/daily-temperatures/solution/leetcode-tu-jie-739mei-ri-wen-du-by-misterbooo/
 *  难度(自己)：简单看题解后可完成
 * @author GaryLeeeee
 * @date 2021/06/07 00:21
 *
 */
public class DailyTemperatures {
    /**
     * 解法：单调栈
     * 思路：将每一天的温度(存下标)压入栈，后面压入的时候把前面低于的取出来计算天数(保证栈底到栈顶是递增的)
     */
    public int[] dailyTemperatures(int[] temperatures) {
        //可以参考左视图，如果一个温度把之前的温度的盖住了，说明比他高，就可以赋值了，并移除状态
        //存下标吧，存value有问题
        Stack<Integer> stack = new Stack<>();
        //初始化个结果吧，默认值是0(不要直接操作原数组，会多一个for操作)
        int result[] = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            //当栈不为空时，从上取比当前数小的取出并设置result
            while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                //计算相隔天数并写入result
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }

        return result;
    }

    /**
     * 例子：
     *  输入：[73,74,75,71,69,72,76,73]
     *  输出：[1,1,4,2,1,1,0,0]
     */
    public static void main(String[] args) {
        int nums[] = new int[]{73,74,75,71,69,72,76,73};
        int result[] = new DailyTemperatures().dailyTemperatures(nums);
        for(int i:result){
            System.out.print(i+",");
        }
    }
}
