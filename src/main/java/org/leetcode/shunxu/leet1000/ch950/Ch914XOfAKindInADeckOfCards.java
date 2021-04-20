package org.leetcode.shunxu.leet1000.ch950;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>914. 卡牌分组
 *
 * <p>给定一副牌，每张牌上都写着一个整数。
 *
 * <p>此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *
 * <p>    每组都有 X 张牌。
 * <p>    组内所有的牌上都写着相同的整数。
 *
 * <p>仅当你可选的 X >= 2 时返回 true。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：[1,2,3,4,4,3,2,1]
 * <p>输出：true
 * <p>解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 *
 * <p>示例 2：
 *
 * <p>输入：[1,1,1,2,2,2,3,3]
 * <p>输出：false
 * <p>解释：没有满足要求的分组。
 *
 * <p>示例 3：
 *
 * <p>输入：[1]
 * <p>输出：false
 * <p>解释：没有满足要求的分组。
 *
 * <p>示例 4：
 *
 * <p>输入：[1,1]
 * <p>输出：true
 * <p>解释：可行的分组是 [1,1]
 *
 * <p>示例 5：
 *
 * <p>输入：[1,1,2,2,2,2]
 * <p>输出：true
 * <p>解释：可行的分组是 [1,1]，[2,2]，[2,2]
 *
 *
 * <p>提示：
 *
 * <p>    1 <= deck.length <= 10000
 * <p>    0 <= deck[i] < 10000
 *
 *
 * <p>通过次数45,347
 * <p>提交次数116,497
 * <p>在真实的面试中遇到过这道题？
 * <p> https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/
 * <p>@author: wangrui
 * <p>@date: 2021/3/21
 */
public class Ch914XOfAKindInADeckOfCards {

  public boolean hasGroupsSizeX(int[] deck) {
    int[] count = new int[10000];
    for (int x : deck) {
      count[x]++;
    }
    int g = -1;
    for (int i = 0; i < 10000; i++) {
      if (count[i] != 0) {
        if (g == -1) {
          g = count[i];
        } else {
          g = gcd(g, count[i]);
        }
      }
    }
    return g >= 2;
  }

  public int gcd(int x, int y) {
    return x == 0 ? y : gcd(y % x, x);
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(NlogC)，其中 N 是卡牌的个数，C 是数组 deck 中数的范围，在本题中 C 的值为 10000。
   * <p>    求两个数最大公约数的复杂度是 O(logC)，需要求最多 N−1 次。
   *
   * <p>   空间复杂度：O(N+C) 或 O(N)
   *
   * <p>作者：LeetCode-Solution
   * <p>链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/solution/qia-pai-fen-zu-by-leetcode-solution/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param deck
   * @return
   */
  public boolean hasGroupsSizeX2(int[] deck) {
    int[] count = new int[10000];
    for (int c : deck) {
      count[c]++;
    }

    int g = -1;
    for (int i = 0; i < 10000; ++i) {
      if (count[i] > 0) {
        if (g == -1) {
          g = count[i];
        } else {
          g = gcd(g, count[i]);
        }
      }
    }
    return g >= 2;
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(N2)，其中 N 是卡牌个数。最多枚举 N 个可能的 X，对于每个 X，要遍历的数字 i 最多有 N 个。
   *
   * <p> 空间复杂度：O(N+C) 或 O(N)，其中 C 是数组 deck 中数的范围，在本题中 C 的值为 10000。在 C++ 和 Java 代码中，
   * <p>我们先用频率数组 count 存储了每个数字 i 出现的次数 count[i]，随后将所有超过零的次数转移到数组 values 中，
   * <p>方便进行遍历，因此需要使用长度为 C 的 count 数组以及长度不超过 N 的 values 数组，空间复杂度为 O(N+C)。
   * <p>在 Python 代码中，我们直接使用哈希映射存储每个数字 i 以及出现的次数，因此空间复杂度为 O(N)。
   *
   * <p>作者：LeetCode-Solution
   * <p>链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/solution/qia-pai-fen-zu-by-leetcode-solution/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param deck
   * @return
   */
  public boolean hasGroupsSizeX3(int[] deck) {
    int N = deck.length;
    int[] count = new int[10000];
    for (int c : deck) {
      count[c]++;
    }

    List<Integer> values = new ArrayList<Integer>();
    for (int i = 0; i < 10000; ++i) {
      if (count[i] > 0) {
        values.add(count[i]);
      }
    }

    for (int X = 2; X <= N; ++X) {
      if (N % X == 0) {
        boolean flag = true;
        for (int v : values) {
          if (v % X != 0) {
            flag = false;
            break;
          }
        }
        if (flag) {
          return true;
        }
      }
    }

    return false;
  }

}
