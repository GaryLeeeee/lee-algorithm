package leetcode.middle;

/**
 * @desc
 *  题目：5. 最长回文子串
 *  描述：给你一个字符串 s，找到 s 中最长的回文子串。
 *  链接：https://leetcode-cn.com/problems/longest-palindromic-substring/
 *  参考题解：https://leetcode-cn.com/problems/daily-temperatures/solution/leetcode-tu-jie-739mei-ri-wen-du-by-misterbooo/
 *  难度(自己)：简单看题解后可完成
 * @author GaryLeeeee
 * @date 2021/06/08 23:33
 *
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        //小于2的必是回文
        if(s.length()<2){
            return s;
        }

        char[] cs = s.toCharArray();
        //字符串长度
        int len = cs.length;
        //最长回文子串最长长度
        int maxLen = 0;
        int maxHead = 0;
        //遍历存放是否回文子串状态
        boolean[][] dp = new boolean[len][len];
        //只有一个字符必是回文串，先初始化
        for(int i=0;i<len;i++){
            dp[i][i] = true;
        }

        //遍历其他
        //i是开始，j是结束
        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){//这里注意是=i，而不是=0
                //如果j比i大，那么是非法的
                if(j<i){
                    break;//只是跳出内层for，以后内层后面的也都是一样结果
                }

                //如果当前头尾相等，则取里面的值
                //比如bcacb是回文，那么cac、a也是回文
                if(cs[i]==cs[j]){
                    //前提是3位及以上，因为单个就肯定是回文
                    //同时如果是两位的话就不需要往内取了
                    if(j-i+1<=2){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else{
                    dp[i][j] = false;
                }

                //如果是true则判断max
                if(dp[i][j]==true){
                    int curLen = j-i+1;
                    if(curLen>maxLen){
                        maxLen = curLen;
                        maxHead = i;
                    }
                }
            }
        }

        //这里需要注意substring是(beginIndex,endIndex)
        return s.substring(maxHead,maxLen+maxHead);
    }


    /**
     * 例子：
     *  输入：[73,74,75,71,69,72,76,73]
     *  输出：[1,1,4,2,1,1,0,0]
     */
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(s));
    }
}
