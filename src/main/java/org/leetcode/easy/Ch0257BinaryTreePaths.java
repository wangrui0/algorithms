package org.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.leetcode.TreeNode;

/**
 * <p>257. 二叉树的所有路径
 *
 * <p>给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * <p>说明: 叶子节点是指没有子节点的节点。
 *
 * <p> 示例:
 *
 * <p> 输入:
 *
 * <p>    1
 * <p>  /   \
 * <p> 2     3
 * <p>  \
 * <p>   5
 *
 * <p>输出: ["1->2->5", "1->3"]
 *
 * <p>解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * <p>https://leetcode-cn.com/problems/binary-tree-paths/
 *
 * @author: wangrui
 * @date: 2021/1/31
 */
public class Ch0257BinaryTreePaths {

  /**
   * <p>深度优先：
   *
   * <p>复杂度分析
   *
   * <p>     时间复杂度：O(N^2)，其中 N 表示节点数目。在深度优先搜索中每个节点会被访问一次且只会被访问一次，每一次会对 path 变量进行拷贝构造，时间代价为
   * <p>)O(N)，故时间复杂度为 O(N^2)。
   * <p>
   * <p>     空间复杂度：O(N^2)，其中 NNN 表示节点数目。除答案数组外我们需要考虑递归调用的栈空间。在最坏情况下，当二叉树中每个节点只有一个孩子节点时，即整棵二叉树呈一个链状，此时递归的层数为
   * <p>N，此时每一层的 path 变量的空间代价的总和为O(N^2)
   *
   * <p> 作者：LeetCode-Solution
   * <p> 链接：https://leetcode-cn.com/problems/binary-tree-paths/solution/er-cha-shu-de-suo-you-lu-jing-by-leetcode-solution/
   * <p> 来源：力扣（LeetCode）
   * <p> 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param root
   * @return
   */
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> paths = new ArrayList<String>();
    constructPaths(root, "", paths);
    return paths;
  }

  public void constructPaths(TreeNode root, String path, List<String> paths) {
    if (root != null) {
      StringBuffer pathSB = new StringBuffer(path);
      pathSB.append(Integer.toString(root.val));
      if (root.left == null && root.right == null) {  // 当前节点是叶子节点
        paths.add(pathSB.toString());  // 把路径加入到答案中
      } else {
        pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
        constructPaths(root.left, pathSB.toString(), paths);
        constructPaths(root.right, pathSB.toString(), paths);
      }
    }
  }

  /**
   * <p> 广度优先算法（采用队列的方式）：
   * <p> 复杂度分析
   *
   * <p>     时间复杂度：O(N^2)，其中 N 表示节点数目。分析同方法一。
   * <p>     空间复杂度：O(N^2)，其中 N 表示节点数目。在最坏情况下，队列中会存在 N 个节点，保存字符串的队列中每个节点的最大长度为 N，故空间复杂度为
   * <p>O(N^2)。
   *
   * <p> 作者：LeetCode-Solution
   * <p> 链接：https://leetcode-cn.com/problems/binary-tree-paths/solution/er-cha-shu-de-suo-you-lu-jing-by-leetcode-solution/
   * <p> 来源：力扣（LeetCode）
   * <p> 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param root
   * @return
   */
  public List<String> binaryTreePaths2(TreeNode root) {
    List<String> paths = new ArrayList<String>();
    if (root == null) {
      return paths;
    }
    Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
    Queue<String> pathQueue = new LinkedList<String>();

    nodeQueue.offer(root);
    pathQueue.offer(Integer.toString(root.val));

    while (!nodeQueue.isEmpty()) {
      TreeNode node = nodeQueue.poll();
      String path = pathQueue.poll();

      if (node.left == null && node.right == null) {
        paths.add(path);
      } else {
        if (node.left != null) {
          nodeQueue.offer(node.left);
          pathQueue.offer(new StringBuffer(path).append("->").append(node.left.val).toString());
        }

        if (node.right != null) {
          nodeQueue.offer(node.right);
          pathQueue.offer(new StringBuffer(path).append("->").append(node.right.val).toString());
        }
      }
    }
    return paths;
  }














}
