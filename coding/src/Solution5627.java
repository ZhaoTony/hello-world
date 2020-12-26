class Solution {
    public int stoneGameVII(int[] stones) {
        int len = stones.length;
        //dp数组，dp[i][j]表示从i到j两人最后的最大差值
        int[][] dp = new int[len][len];
        //pre数组，为的是求拿去stones[i]或stones[j]之后元素的和
        //pre[i + 1]表示stones[0] + stones[1] + stones[2] + ... + stones[i] (i的范围:[0, len - 1])
        int[] pre = new int[len + 1];
        for(int i = 0; i < len; i++)
            pre[i + 1] = pre[i] + stones[i];

        //dp数组初始化：len = j - i + 1 = 1
        //dp[i][j]
        //可以注释掉，便于理解暂时不注释掉
        for(int i = 0; i < len; i++)
            dp[i][i] = 0;

        //len >= 2
        for(int k = 2; k <= len; k++) {
            for(int i = 0; i + k - 1 <= len - 1; i++) {
                //根据i和长度计算j
                int j = i + k - 1;
                //第一个人：[0, j] - [0, i] ==> (i, j]
                //第二个人：dp[i + 1][j]
                //第一个人：[0, j - 1] - [0, i - 1] ==> [i, j)
                //第二个人：dp[i][j - 1]
                //计算差值
                dp[i][j] = Math.max(pre[j + 1] - pre[i + 1] - dp[i + 1][j], pre[j] - pre[i] - dp[i][j - 1]);
            }
        }
        return dp[0][len - 1];
    }
}