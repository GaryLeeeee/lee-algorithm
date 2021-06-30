package leetcode.middle;

/**
 * @desc
 *  题目：79. 单词搜索
 *  描述：
给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *  链接：https://leetcode-cn.com/problems/word-search/
 *  参考题解：https://leetcode-cn.com/problems/word-search/solution/su-kan-dfsjian-dan-yi-dong-by-rain-ru-xnwe/
 *  难度(自己)：思路很清晰，就是步骤(主要是判断)会比较多
 * @author GaryLeeeee
 * @date 2021/06/29 23:18
 *
 */
public class WordSearch {

    /**
     * 解法：回溯算法
     * 思路：理解为三叉树即可，然后参考全排列
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        //这种有结束条件的一般都要想到回溯
        char[] words = new char[word.length()];

        //找到第一个字符
        char first = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //找到起点
                if (board[i][j] == first) {
                    //还是得设置一个boolean数组
                    boolean[][] isUsed = new boolean[board.length][board[0].length];
                    boolean isExist = this.backtrack(board, words, isUsed, i, j, 0, word);
                    //只要有一条路径符合即可
                    if (isExist) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //words存放路径
    //board记录走过的(设置0即可)
    //word存放需要走的单词

    /**
     * 回溯算法
     * @param board 二维字符网络(条件给的，不变)
     * @param words 路径
     * @param isUsed 网络字符使用情况(路径走过置为true)
     * @param x
     * @param y
     * @param wordsSize
     * @param word
     * @return
     */
    public boolean backtrack(char[][] board, char[] words, boolean[][] isUsed, int x, int y, int wordsSize, String word) {
        //判断是否在便捷了
        if (x < 0 || x > isUsed.length - 1 || y < 0 || y > isUsed[0].length - 1) {
            return false;
        }

        //使用过也返回false
        if (isUsed[x][y]) {
            return false;
        }


        //判断是否可以连上
        if (board[x][y] != word.charAt(wordsSize)) {
            return false;
        } else {
            words[wordsSize] = board[x][y];
            wordsSize++;
            isUsed[x][y] = true;

            if (wordsSize == word.length()) {
                return true;
            }
        }


        //前后左右看
        boolean left = this.backtrack(board, words, isUsed, x - 1, y, wordsSize, word);
        boolean right = this.backtrack(board, words, isUsed, x + 1, y, wordsSize, word);
        boolean up = this.backtrack(board, words, isUsed, x, y - 1, wordsSize, word);
        boolean down = this.backtrack(board, words, isUsed, x, y + 1, wordsSize, word);

        //回溯算法关键，需要往回回滚数据
        isUsed[x][y] = false;

        //只要有一个有true即可
        return left || right || up || down;
    }

    /**
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     输出：true
     * @param args
     */
    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(new WordSearch().exist(board, word));
    }
}
