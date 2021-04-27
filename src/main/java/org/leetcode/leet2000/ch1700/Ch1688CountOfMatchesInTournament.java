package org.leetcode.leet2000.ch1700;

/**
 * <p>1688. 比赛中的配对次数
 *
 * <p>给你一个整数 n ，表示比赛中的队伍数。比赛遵循一种独特的赛制：
 *
 * <p>    如果当前队伍数是 偶数 ，那么每支队伍都会与另一支队伍配对。总共进行 n / 2 场比赛，且产生 n / 2 支队伍进入下一轮。
 * <p>    如果当前队伍数为 奇数 ，那么将会随机轮空并晋级一支队伍，其余的队伍配对。总共进行 (n - 1) / 2 场比赛，且产生 (n - 1) / 2 + 1 支队伍进入下一轮。
 *
 * <p>返回在比赛中进行的配对次数，直到决出获胜队伍为止。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：n = 7
 * <p>输出：6
 * <p>解释：比赛详情：
 * <p>- 第 1 轮：队伍数 = 7 ，配对次数 = 3 ，4 支队伍晋级。
 * <p>- 第 2 轮：队伍数 = 4 ，配对次数 = 2 ，2 支队伍晋级。
 * <p>- 第 3 轮：队伍数 = 2 ，配对次数 = 1 ，决出 1 支获胜队伍。
 * <p>总配对次数 = 3 + 2 + 1 = 6
 *
 * <p>示例 2：
 *
 * <p>输入：n = 14
 * <p>输出：13
 * <p>解释：比赛详情：
 * <p>- 第 1 轮：队伍数 = 14 ，配对次数 = 7 ，7 支队伍晋级。
 * <p>- 第 2 轮：队伍数 = 7 ，配对次数 = 3 ，4 支队伍晋级。
 * <p>- 第 3 轮：队伍数 = 4 ，配对次数 = 2 ，2 支队伍晋级。
 * <p>- 第 4 轮：队伍数 = 2 ，配对次数 = 1 ，决出 1 支获胜队伍。
 * <p>总配对次数 = 7 + 3 + 2 + 1 = 13
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= n <= 200
 *
 * <p>通过次数15,911
 * <p>提交次数19,845
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/count-of-matches-in-tournament/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 7:33 下午
 */
public class Ch1688CountOfMatchesInTournament {

  public static int numberOfMatches_self(int n) {
    int ans = 0;
    while (n > 1) {
      if ((n & 1) == 0) {
        n >>= 1;
        ans += n;
      } else {
        n = (n - 1) >> 1;
        ans += n;
        n += 1;
      }
    }
    return ans;
  }

  public int numberOfMatches(int n) {
    int tmp = 0;
    while (n != 1) {
      if (n % 2 == 0) {
        tmp = tmp + n / 2;
        n = n / 2;
      } else {
        tmp = tmp + (n - 1) / 2;
        n = (n - 1) / 2 + 1;
      }
    }
    return tmp;
  }
}
