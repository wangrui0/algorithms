package org.leetcode.shunxu.leet1000.ch1000;

/**
 * <p>997. 找到小镇的法官
 *
 * <p>在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
 *
 * <p>如果小镇的法官真的存在，那么：
 *
 * <p>    小镇的法官不相信任何人。
 * <p>    每个人（除了小镇法官外）都信任小镇的法官。
 * <p>    只有一个人同时满足属性 1 和属性 2 。
 *
 * <p>给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
 *
 * <p>如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：N = 2, trust = [[1,2]]
 * <p>输出：2
 *
 * <p>示例 2：
 *
 * <p>输入：N = 3, trust = [[1,3],[2,3]]
 * <p>输出：3
 *
 * <p>示例 3：
 *
 * <p>输入：N = 3, trust = [[1,3],[2,3],[3,1]]
 * <p>输出：-1
 *
 * <p>示例 4：
 *
 * <p>输入：N = 3, trust = [[1,2],[2,3]]
 * <p>输出：-1
 *
 * <p>示例 5：
 *
 * <p>输入：N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * <p>输出：3
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= N <= 1000
 * <p>    trust.length <= 10000
 * <p>    trust[i] 是完全不同的
 * <p>    trust[i][0] != trust[i][1]
 * <p>    1 <= trust[i][0], trust[i][1] <= N
 *
 * <p>通过次数28,381
 * <p>提交次数55,253
 * <p>@author: wangrui
 * <p>@date: 2021/4/2
 */
public class Ch997FindTheTownJudge {

  public int findJudge(int N, int[][] trust) {
    if (trust.length == 0 && N == 1) {
      return 1;
    }
    int[] votes = new int[N + 1];
    for (int i = 0; i < trust.length; i++) {
      int[] ans = trust[i];
      votes[ans[1]]++;
      votes[ans[0]]--;
    }
    for (int i = 0; i < votes.length; i++) {
      if (votes[i] == N - 1) {
        return i;
      }
    }
    return -1;
  }

  /**
   * <p>算法分析
   *
   * <p>设trust矩阵有m行，2列。
   *
   * <p> 时间复杂度max{O(m×2),O(N)}.
   *
   * <p> 空间复杂度O(N).
   *
   * @param N
   * @param trust
   * @return
   */
  public int findJudge_1(int N, int[][] trust) {
    int[] degree = new int[N + 1];    // 总票数

    for (int[] relation : trust) {
      degree[relation[1]]++;          // 获得投票
      degree[relation[0]]--;          // 投出一票
    }

    int judge = -1;
    for (int i = 1; i <= N; i++) {
      // 为了成为全镇最靓的仔，他没有给其他人投过票
      if (degree[i] == N - 1) {
        judge = i;
        break;
      }
    }
    return judge;   // C位出道
  }

}
