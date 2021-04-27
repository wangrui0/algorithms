package org.leetcode.leet2000.ch1700;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>1700. 无法吃午餐的学生数量
 *
 * <p>学校的自助午餐提供圆形和方形的三明治，分别用数字 0 和 1 表示。所有学生站在一个队列里，每个学生要么喜欢圆形的要么喜欢方形的。
 * <p>餐厅里三明治的数量与学生的数量相同。所有三明治都放在一个 栈 里，每一轮：
 *
 * <p>    如果队列最前面的学生 喜欢 栈顶的三明治，那么会 拿走它 并离开队列。
 * <p>    否则，这名学生会 放弃这个三明治 并回到队列的尾部。
 *
 * <p>这个过程会一直持续到队列里所有学生都不喜欢栈顶的三明治为止。
 *
 * <p>给你两个整数数组 students 和 sandwiches ，其中 sandwiches[i] 是栈里面第 i​​​​​​ 个三明治的类型（i = 0 是栈的顶部）， students[j] 是初始队列里第 j​​​​​​
 * 名学生对三明治的喜好（j = 0 是队列的最开始位置）。请你返回无法吃午餐的学生数量。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：students = [1,1,0,0], sandwiches = [0,1,0,1]
 * <p>输出：0
 * <p>解释：
 * <p>- 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [1,0,0,1]。
 * <p>- 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [0,0,1,1]。
 * <p>- 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = [0,1,1]，三明治栈为 sandwiches = [1,0,1]。
 * <p>- 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [1,1,0]。
 * <p>- 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = [1,0]，三明治栈为 sandwiches = [0,1]。
 * <p>- 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [0,1]。
 * <p>- 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = [1]，三明治栈为 sandwiches = [1]。
 * <p>- 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = []，三明治栈为 sandwiches = []。
 * <p>所以所有学生都有三明治吃。
 *
 * <p>示例 2：
 *
 * <p>输入：students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
 * <p>输出：3
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= students.length, sandwiches.length <= 100
 * <p>    students.length == sandwiches.length
 * <p>    sandwiches[i] 要么是 0 ，要么是 1 。
 * <p>    students[i] 要么是 0 ，要么是 1 。
 *
 * <p>通过次数4,817
 * <p>提交次数6,676
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/number-of-students-unable-to-eat-lunch/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 7:34 下午
 */
public class Ch1700NumberOfStudentsUnableToEatLunch {

  /**
   * 很巧妙啊，有一个不符合，说明就不用往后走了
   * @param students
   * @param sandwiches
   * @return
   */
  public static int countStudents(int[] students, int[] sandwiches) {
    int stu[] = new int[2];
    for (int i = 0; i < students.length; i++) {
      stu[students[i]]++;
    }
    for (int i = 0; i < sandwiches.length; i++) {
      if (stu[sandwiches[i]] > 0) {
        stu[sandwiches[i]]--;
      } else {
        break;
      }
    }

    return stu[0] + stu[1];
  }

  public int countStudents_2(int[] students, int[] sandwiches) {
    LinkedList<Integer> linkedList = new LinkedList<>();
    for (int i = 0; i < students.length; i++) {
      linkedList.add(students[i]);
    }
    int z = 0;
    int temp = 0;
    for (int i = 0; i < linkedList.size(); i++) {
      int j = linkedList.getFirst();
      if (sandwiches[z] != j) {
        linkedList.removeFirst();
        linkedList.addLast(j);
        i = -1;
        temp++;
        if (temp == linkedList.size()) {
          return temp;
        }
        continue;
      } else {
        temp = 0;
        z++;
        linkedList.removeFirst();
        i = -1;
      }
    }
    return linkedList.size();
  }

  public int countStudents_3(int[] students, int[] sandwiches) {
    if (students == null || students.length == 0) {
      return 0;
    }
    if (sandwiches == null || sandwiches.length == 0) {
      return students.length;
    }
    //  因为涉及到学生从队头移动到队尾，使用队列
    Queue<Integer> stu = new LinkedList<>();
    for (int student : students) {
      stu.offer(student);
    }
    for (int i = 0; i < sandwiches.length; i++) {
      // 队列为空，说明所有学生都满足了
      if (stu.isEmpty()) {
        return 0;
      }
      // 记录学生队列的长度，防止学生无限制转圈下去
      int size = stu.size();
      boolean like = false;
      for (int s = 0; s < size; s++) {
        int poll = stu.poll();
        if (poll != sandwiches[i]) {
          // 学生移动到队尾
          stu.offer(poll);
        } else {
          // 顶层的三明治有人喜欢，停止遍历，继续判断下一块三明治（这跟拍卖似的^_^）
          like = true;
          break;
        }
      }
      if (!like) {
        // 顶层的三明治没有人喜欢，结束，返回不能满足的学生数
        return size;
      }
    }
    return stu.size();
  }


  public int countStudents_4(int[] students, int[] sandwiches) {
    if (students == null || students.length == 0) {
      return 0;
    }
    if (sandwiches == null || sandwiches.length == 0) {
      return students.length;
    }
    // stuLike[0] 喜欢圆形的学生数，stuLike[1]喜欢方形的学生数
    int[] stuLike = new int[2];
    for (int student : students) {
      stuLike[student]++;
    }
    for (int i = 0; i < sandwiches.length; i++) {
      if (stuLike[sandwiches[i]] == 0) {
        // 学生是转圈来的，此时说明喜欢圆形或者方形的学生已经没有了，顶部的三明治没人取走了。
        break;
      }
      // 对应的学生满足一个，减少一个
      stuLike[sandwiches[i]]--;
    }
    return stuLike[0] + stuLike[1];
  }
}
