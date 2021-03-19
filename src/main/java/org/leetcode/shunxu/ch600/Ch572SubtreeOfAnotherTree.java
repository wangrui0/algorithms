package org.leetcode.shunxu.ch600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.TreeNode;

/**
 *
 * 仔细想想kmp 算法
 * <p>572. 另一个树的子树
 *
 * <p>给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * <p>示例 1:
 * <p>给定的树 s:
 *
 * <p>     3
 * <p>    / \
 * <p>   4   5
 * <p>  / \
 * <p> 1   2
 *
 * <p>给定的树 t：
 *
 * <p>   4
 * <p>  / \
 * <p> 1   2
 *
 * <p>返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 *
 * <p>示例 2:
 * <p>给定的树 s：
 *
 * <p>     3
 * <p>    / \
 * <p>   4   5
 * <p>  / \
 * <p> 1   2
 * <p>    /
 * <p>   0
 *
 * <p>给定的树 t：
 *
 *
 * <p>   4
 * <p>  / \
 * <p> 1   2
 *
 * <p>返回 false。
 * <p>通过次数61,665
 * <p>提交次数130,425
 * <p>在真实的面试中遇到过这道题？
 * <p>hps://leetcode-cn.com/problems/subtree-of-another-tree/
 * <p>@author: wangrui
 * <p>@date: 2021/3/17
 */
public class Ch572SubtreeOfAnotherTree {

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：对于每一个 s 上的点，都需要做一次深度优先搜索来和 t 匹配，匹配一次的时间代价是 O(∣t∣)，那么总的时间代价就是 O(∣s∣×∣t∣)。故渐进时间复杂度为 O(∣s∣×∣t∣)。
   * <p>   空间复杂度：假设 s 深度为 ds​，t 的深度为 dt​，任意时刻栈空间的最大使用代价是 O(max{ds​,dt​})。故渐进空间复杂度为 O(max{ds​,dt​})。
   *
   * <p>作者：LeetCode-Solution
   * <p>链接：hps://leetcode-cn.com/problems/subtree-of-another-tree/solution/ling-yi-ge-shu-de-zi-shu-by-leetcode-solution/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param s
   * @param t
   * @return
   */
  public boolean isSubtree(TreeNode s, TreeNode t) {
    return dfs(s, t);
  }

  public boolean dfs(TreeNode s, TreeNode t) {
    if (s == null) {
      return false;
    }
    return check(s, t) || dfs(s.left, t) || dfs(s.right, t);
  }

  public boolean check(TreeNode s, TreeNode t) {
    if (s == null && t == null) {
      return true;
    }
    if (s == null || t == null || s.val != t.val) {
      return false;
    }
    return check(s.left, t.left) && check(s.right, t.right);
  }


  List<Integer> sOrder = new ArrayList<Integer>();
  List<Integer> tOrder = new ArrayList<Integer>();
  int maxElement, lNull, rNull;

  public boolean isSubtree2(TreeNode s, TreeNode t) {
    maxElement = Integer.MIN_VALUE;
    getMaxElement2(s);
    getMaxElement2(t);
    lNull = maxElement + 1;
    rNull = maxElement + 2;

    getDfsOrder2(s, sOrder);
    getDfsOrder2(t, tOrder);

    return kmp();
  }

  public void getMaxElement2(TreeNode t) {
    if (t == null) {
      return;
    }
    maxElement = Math.max(maxElement, t.val);
    getMaxElement2(t.left);
    getMaxElement2(t.right);
  }

  public void getDfsOrder2(TreeNode t, List<Integer> tar) {
    if (t == null) {
      return;
    }
    tar.add(t.val);
    if (t.left != null) {
      getDfsOrder2(t.left, tar);
    } else {
      tar.add(lNull);
    }
    if (t.right != null) {
      getDfsOrder2(t.right, tar);
    } else {
      tar.add(rNull);
    }
  }

  //j i
  //gggtgcf
  //0123456
  public boolean kmp() {
    int sLen = sOrder.size(), tLen = tOrder.size();
    int[] fail = new int[tOrder.size()];
    Arrays.fill(fail, -1);
    //组装next
    for (int i = 1, j = -1; i < tLen; ++i) {
      while (j != -1 && !(tOrder.get(i).equals(tOrder.get(j + 1)))) {
        j = fail[j];
      }
      if (tOrder.get(i).equals(tOrder.get(j + 1))) {
        ++j;
      }
      fail[i] = j;
    }
    //j 是实际匹配的长度,kmp 算法
    for (int i = 0, j = -1; i < sLen; ++i) {
      while (j != -1 && !(sOrder.get(i).equals(tOrder.get(j + 1)))) {
        j = fail[j];
      }
      if (sOrder.get(i).equals(tOrder.get(j + 1))) {
        ++j;
      }
      if (j == tLen - 1) {
        return true;
      }
    }
    return false;
  }
}
