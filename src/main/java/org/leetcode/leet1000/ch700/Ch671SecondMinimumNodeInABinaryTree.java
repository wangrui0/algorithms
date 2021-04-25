package org.leetcode.leet1000.ch700;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import org.TreeNode;

/**
 * <p>671. 二叉树中第二小的节点
 * <p>给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 *
 * <p>更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 *
 * <p>给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 *
 *
 * <p>示例 1：
 *
 *
 * <p>输入：root = [2,2,5,null,null,5,7]
 * <p>输出：5
 * <p>解释：最小的值是 2 ，第二小的值是 5 。
 * <p>示例 2：
 *
 *
 * <p>输入：root = [2,2,2]
 * <p>输出：-1
 * <p>解释：最小的值是 2, 但是不存在第二小的值。
 *
 *
 * <p>提示：
 *
 * <p>树中节点数目在范围 [1, 25] 内
 * <p>1 <= Node.val <= 231 - 1
 * <p>对于树中每个节点 root.val == min(root.left.val, root.right.val)
 * <p>通过次数22,418提交次数48,452
 * <p>在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/
 *
 * @Author: shenpei
 * @Date: 2021/3/18 11:24 下午
 */
public class Ch671SecondMinimumNodeInABinaryTree {

  long ans = Long.MAX_VALUE;

  /**
   * <p>方法一：暴力法 [通过]
   *
   * <p>算法：
   *
   * <p>    通过深度优先搜索遍历树，并使用集合结构唯一性记录树中的每个唯一值。
   * <p>    然后，我们将查看第二个最小值的记录值。第一个最小值必须是 root.val。
   *
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(N)。其中 N 是给定树中的节点总数。我们只访问每个节点一次。
   * <p>   空间复杂度：O(N)，存储在 uniques 中的信息。
   *
   * <p>作者：LeetCode
   * <p>链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/solution/er-cha-shu-zhong-di-er-xiao-de-jie-dian-by-leetcod/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param root
   * @return
   */
  public int findSecondMinimumValue(TreeNode root) {
    if (root == null) {
      return -1;
    }
    int minval = root.val;
    dfs(root, minval);
    if (ans == Long.MAX_VALUE) {
      return -1;
    }
    return (int) ans;
  }

  private void dfs(TreeNode root, int minval) {
    if (root == null) {
      return;
    }
    if (root.val > minval && root.val < ans) {
      ans = root.val;
    }
    dfs(root.left, minval);
    dfs(root.right, minval);
  }

  ////////////////////////////////

  /**
   * <p> 方法二：
   *
   * <p>算法：
   *
   * <p>    让 min1 = root.val。当遍历结点 node，如果 node.val > min1，我们知道在 node 处的子树中的所有值都至少是
   * node.val，因此在该子树中不此存在第二个最小值。因此，我们不需要搜索这个子树。
   * <p>   此外，由于我们只关心第二个最小值 ans，因此我们不需要记录任何大于当前第二个最小值的值，因此与方法 1 不同，我们可以完全不用集合存储数据。
   *
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(N)。其中 N 是给定树中的节点总数。我们最多访问每个节点一次。
   * <p>    空间复杂度：O(N)，存储在 ans 和 min1 中的信息为 O(1)，但我们的深度优先搜索可能会在调用堆栈中存储多达
   * O(h)=O(N) 的信息，其中 h 是树的高度。
   *
   * <p>作者：LeetCode
   * <p>链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/solution/er-cha-shu-zhong-di-er-xiao-de-jie-dian-by-leetcod/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param root
   * @return
   */
  public int findSecondMinimumValue2(TreeNode root) {
    if (root == null) {
      return -1;
    }
    int minval = root.val;
    dfs(root, minval);
    if (ans == Long.MAX_VALUE) {
      return -1;
    }
    return (int) ans;
  }

  private void dfs2(TreeNode root, int minval) {
    if (root == null) {
      return;
    }
    if (root.val > minval && root.val < ans) {
      ans = root.val;
    }
    if (root.left != null && root.left.val < ans) {
      dfs2(root.left, minval);
    }
    if (root.right != null && root.right.val < ans) {
      dfs2(root.right, minval);
    }
  }

  /////////////方法三/////////////
  int min;
  int second = Integer.MAX_VALUE;

  public int findSecondMinimumValue3(TreeNode root) {
    min = root.val;
    helper(root);
    if (min == second) {
      return -1;
    }
    return second == Integer.MAX_VALUE ? -1 : second;
  }

  public void helper(TreeNode node) {
    if (node == null) {
      return;
    }
    if (node.val > min && node.val < second) {
      second = node.val;
    } else if (node.val == min) {
      helper(node.left);
      helper(node.right);
    }
  }

  ///////////////////////////////
  public int findSecondMinimumValue4(TreeNode root) {
    Set<Integer> set = new HashSet<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode temp = stack.pop();
      set.add(temp.val);
      if (temp.left != null) {
        stack.push(temp.left);
      }
      if (temp.right != null) {
        stack.push(temp.right);
      }
    }
    int min = Integer.MAX_VALUE;
    int second = Integer.MAX_VALUE;
    for (int value : set) {
      if (value < min) {
        second = min;
        min = value;
      } else if (value < second) {
        second = value;
      }
    }
    if (min == second) {
      return -1;
    }
    return second == Integer.MAX_VALUE ? -1 : second;
  }

  //////////////方法五//////////////
  public int findSecondMinimumValue5(TreeNode root) {
    int min = root.val;
    int second = Integer.MAX_VALUE;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      if (node.val > min && node.val < second) {
        second = node.val;
      } else if (node.val == min) {
        if (node.left != null) {
          stack.push(node.left);
        }
        if (node.right != null) {
          stack.push(node.right);
        }
      }
    }
    if (min == second) {
      return -1;
    }
    return second == Integer.MAX_VALUE ? -1 : second;
  }

  //////////////方法六//////////////
  public int findSecondMinimumValue6(TreeNode root) {
    Set<Integer> set = new HashSet<Integer>();
    helper(root, set);
    int min = Integer.MAX_VALUE;
    int second = Integer.MAX_VALUE;
    for (int value : set) {
      if (value < min) {
        second = min;
        min = value;
      } else if (value < second) {
        second = value;
      }
    }
    if (min == second) {
      return -1;
    }
    return second == Integer.MAX_VALUE ? -1 : second;
  }

  public void helper(TreeNode node, Set<Integer> set) {
    if (node == null) {
      return;
    }
    set.add(node.val);
    helper(node.left, set);
    helper(node.right, set);
  }
}
