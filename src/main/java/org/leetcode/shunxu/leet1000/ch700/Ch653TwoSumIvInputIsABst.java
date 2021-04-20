package org.leetcode.shunxu.leet1000.ch700;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import org.TreeNode;

/**
 * <p>653. 两数之和 IV - 输入 BST
 *
 * <p>给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * <p>案例 1:
 *
 * <p>输入:
 * <p>    5
 * <p>   / \
 * <p>  3   6
 * <p> / \   \
 * <p>2   4   7
 *
 * <p>Target = 9
 *
 * <p>输出: True
 *
 *
 *
 * <p>案例 2:
 *
 * <p>输入:
 * <p>    5
 * <p>   / \
 * <p>  3   6
 * <p> / \   \
 * <p>2   4   7
 *
 * <p>Target = 28
 *
 * <p>输出: False
 *
 * <p>https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 * <p>通过次数28,772
 * <p>提交次数49,500
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/3/18
 */
public class Ch653TwoSumIvInputIsABst {

  /**
   * <p>方法一：使用 HashSet【通过】
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(n)，其中 NNN 是节点的数量。最坏的情况下，整棵树被遍历一次。
   *
   * <p>    空间复杂度：O(n)。最坏的情况下，set 存储 n 个节点的值
   *
   * <p> 作者：LeetCode
   * <p>链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/solution/liang-shu-zhi-he-iv-by-leetcode/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param root
   * @param k
   * @return
   */
  public boolean findTarget(TreeNode root, int k) {
    Set<Integer> set = new HashSet();
    return find(root, k, set);
  }

  public boolean find(TreeNode root, int k, Set<Integer> set) {
    if (root == null) {
      return false;
    }
    if (set.contains(k - root.val)) {
      return true;
    }
    set.add(root.val);
    return find(root.left, k, set) || find(root.right, k, set);
  }

  /**
   * <p>方法二：使用 BFS 和 HashSet【通过】
   * <p>BFS一般指宽度优先搜索。宽度优先搜索算法（又称广度优先搜索）是最简便的图的搜索算法之一
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(n)，其中 n 是树中节点的数量。最坏的情况下，需要遍历整棵树。
   *
   * <p>  空间复杂度：O(n)。最坏的情况下，set 存储 n 个节点的值。
   *
   * <p> 作者：LeetCode
   * <p> 链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/solution/liang-shu-zhi-he-iv-by-leetcode/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  public boolean findTarget2(TreeNode root, int k) {
    Set<Integer> set = new HashSet();
    Queue<TreeNode> queue = new LinkedList();
    queue.add(root);
    while (!queue.isEmpty()) {
      if (queue.peek() != null) {
        TreeNode node = queue.remove();
        if (set.contains(k - node.val)) {
          return true;
        }
        set.add(node.val);
        queue.add(node.right);
        queue.add(node.left);
      } else {
        queue.remove();
      }
    }
    return false;
  }

  /**
   * 方法三：使用 BST【通过】 复杂度分析(二叉搜索)
   * <p>
   * 时间复杂度：O(n)，其中 n 是树中节点的数量。本方法需要中序遍历整棵树。
   * <p>
   * 空间复杂度：O(n)，list 中存储 n 个元素。
   * <p>
   * <p>作者：LeetCode 链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/solution/liang-shu-zhi-he-iv-by-leetcode/
   * <p>来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param root
   * @param k
   * @return
   */
  public boolean findTarget3(TreeNode root, int k) {
    List<Integer> list = new ArrayList();
    inorder(root, list);
    int l = 0, r = list.size() - 1;
    while (l < r) {
      int sum = list.get(l) + list.get(r);
      if (sum == k) {
        return true;
      }
      if (sum < k) {
        l++;
      } else {
        r--;
      }
    }
    return false;
  }

  public void inorder(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    inorder(root.left, list);
    list.add(root.val);
    inorder(root.right, list);
  }
}


