package org;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: wangrui
 * @date: 2021/3/29
 */
public class Test {


  /**
   * 方法3
   *
   * @param root
   * @return
   */
  public int sumRootToLeaf_3(TreeNode root) {
    int res = 0;
    Queue<TreeNode> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
    queue1.offer(root);
    queue2.offer(root.val);
    while (!queue1.isEmpty()) {
      TreeNode poll = queue1.poll();
      Integer value = queue2.poll();
      if (poll.left == null && poll.right == null) {
        res += value;
      } else if (poll.left != null) {
        queue1.offer(poll.left);
        queue2.offer((value << 1) + poll.left.val);
      } else {
        queue1.offer(poll.right);
        queue2.offer((value << 1) + poll.right.val);
      }
    }
    return res;
  }


}
