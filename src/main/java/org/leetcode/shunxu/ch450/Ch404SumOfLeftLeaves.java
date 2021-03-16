package org.leetcode.shunxu.ch450;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import org.TreeNode;

/**
 * <p> 404. 左叶子之和
 *
 * <p>计算给定二叉树的所有左叶子之和。
 *
 * <p>示例：
 *
 * <p>    3
 * <p>   / \
 * <p>  9  20
 * <p>    /  \
 * <p>   15   7
 *
 * <p>在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 *
 * <p> 通过次数70,801
 * <p>提交次数125,001
 * <p>https://leetcode-cn.com/problems/sum-of-left-leaves/
 *
 * @author: wangrui
 * @date: 2021/3/3
 */
public class Ch404SumOfLeftLeaves {


  /**
   * <p>方法1:递归
   * <p>必须是左子树，而且必须是末节点。这样的节点才符合要求
   * <p>这种解法比较直接，对于这种问题，递归的方式比较容易理解。这里需要注意两点：
   * <p>一，必须是左边的叶子节点；
   * <p>二，如果数只有根节点，根节点不是叶子节点，更不是左叶子节点。
   *
   * @param root
   * @return
   */
  public int sumOfLeftLeaves(TreeNode root) {
    return sumOfLeftLeaves(root, false);
  }

  public int sumOfLeftLeaves(TreeNode root, Boolean isLeaf) {
    if (root == null) {
      return 0;
    }
    int sum = 0;
    if (root.left != null || root.right != null) {//非末节点
      sum += sumOfLeftLeaves(root.left, true);
      sum += sumOfLeftLeaves(root.right, true);
    } else if (isLeaf) {//末节点而且是左子树
      sum += root.val;
    }
    return sum;
  }

  /**
   * <p>方法2
   * <p>深度优先遍历（栈是实现深度优先遍历的非递归的方法）
   * <p>很多人不喜欢递归，认为性能不好，这里我再提供一种非递归的思路。一般来说，想用非递归的思路来实现递归的效果，就是使用栈（stack），
   * <p>因为递归的实现就是潜在地使用了栈的思路。这里，我们只需要使用深度优先的方式来遍历节点，并把所有节点放入栈（push）中，之后再取出（pop）即可。
   * <p>这里列出别人给出的方法：
   *
   * @param root
   * @return
   */
  public int sumOfLeftLeaves2(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int ans = 0;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);

    while (!stack.empty()) {
      TreeNode node = stack.pop();
      if (node.left != null) {
        if (node.left.left == null && node.left.right == null) {
          ans += node.left.val;
        } else {
          stack.push(node.left);
        }
      }
      if (node.right != null) {
        if (node.right.left != null || node.right.right != null) {
          stack.push(node.right);
        }
      }
    }
    return ans;
  }

  /**
   * <p>方法3:广度优先搜索(是用队列实现的)
   * <p>复杂度分析
   * <p>
   * 时间复杂度：O(n)，其中 n 是树中的节点个数。
   * <p>
   * 空间复杂度：O(n)。空间复杂度与广度优先搜索使用的队列需要的容量相关，为 O(n)。
   * <p>
   * <p>作者：LeetCode-Solution 链接：https://leetcode-cn.com/problems/sum-of-left-leaves/solution/zuo-xie-zi-zhi-he-by-leetcode-solution/
   * <p>来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param root
   * @return
   */
  public int sumOfLeftLeaves3(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    int ans = 0;
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node.left != null) {
        if (isLeafNode(node.left)) {
          ans += node.left.val;
        } else {
          queue.offer(node.left);
        }
      }
      if (node.right != null) {
        if (!isLeafNode(node.right)) {
          queue.offer(node.right);
        }
      }
    }
    return ans;
  }

  /**
   * <p>方法4：深度优先搜索
   * <p>一个节点为「左叶子」节点，当且仅当它是某个节点的左子节点，并且它是一个叶子结点。因此我们可以考虑对整棵树进行遍历，
   * <p>当我们遍历到节点 node 时，如果它的左子节点是一个叶子结点，那么就将它的左子节点的值累加计入答案。
   *
   * <p>遍历整棵树的方法有深度优先搜索和广度优先搜索，下面分别给出了实现代码。
   *
   *
   * <p>复杂度分析
   * <p>
   * 时间复杂度：O(n)，其中 n 是树中的节点个数。
   *
   * <p>   空间复杂度：O(n)。空间复杂度与深度优先搜索使用的栈的最大深度相关。在最坏的情况下，树呈现链式结构，深度为 O(n)，对应的空间复杂度也为 O(n)。
   *
   * <p>作者：LeetCode-Solution
   * <p>链接：https://leetcode-cn.com/problems/sum-of-left-leaves/solution/zuo-xie-zi-zhi-he-by-leetcode-solution/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param root
   * @return
   */
  public int sumOfLeftLeaves4(TreeNode root) {
    return root != null ? dfs(root) : 0;
  }

  public int dfs(TreeNode node) {
    int ans = 0;
    if (node.left != null) {
      ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
    }
    if (node.right != null && !isLeafNode(node.right)) {
      ans += dfs(node.right);
    }
    return ans;
  }

  public boolean isLeafNode(TreeNode node) {
    return node.left == null && node.right == null;
  }
}
