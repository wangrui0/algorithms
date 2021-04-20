package org.leetcode.shunxu.leet1000.ch700;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p> 690. 员工的重要性
 * <p>  给定一个保存员工信息的数据结构，它包含了员工 唯一的 id ，重要度 和 直系下属的 id 。
 *
 * <p>  比如，员工 1 是员工 2 的领导，员工 2 是员工 3 的领导。他们相应的重要度为 15 , 10 , 5 。那么员工 1 的数据结构是 [1, 15, [2]] ，员工 2的 数据结构是 [2, 10, [3]]
 * ，员工 3 的数据结构是 [3, 5, []] 。注意虽然员工 3 也是员工 1 的一个下属，但是由于 并不是直系 下属，因此没有体现在员工 1 的数据结构中。
 *
 * <p> 现在输入一个公司的所有员工信息，以及单个员工 id ，返回这个员工和他所有下属的重要度之和。
 *
 *
 *
 * <p> 示例：
 *
 * <p> 输入：[[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * <p> 输出：11
 * <p> 解释：
 * <p> 员工 1 自身的重要度是 5 ，他有两个直系下属 2 和 3 ，而且 2 和 3 的重要度均为 3 。因此员工 1 的总重要度是 5 + 3 + 3 = 11 。
 * <p> https://leetcode-cn.com/problems/employee-importance/
 *
 * @Author: shenpei
 * @Date: 2021/3/18 11:31 下午
 */
public class Ch690EmployeeImportance {

  int ans = 0;

  /**
   * slef
   *
   * @param employees
   * @param id
   * @return
   */
  public int getImportance(List<Employee> employees, int id) {
    Map<Integer, Employee> map = new HashMap<>();
    for (Employee e : employees) {
      map.put(e.id, e);
    }
    search(map, id);
    return ans;
  }

  public void search(Map<Integer, Employee> map, Integer id) {
    Employee e = map.get(id);
    int importance = e.importance;
    ans += importance;
    for (Integer eId : e.subordinates) {
      search(map, eId);
    }
  }


  /**
   * <p>复杂度分析
   *
   * <p>  时间复杂度：O(N)。其中 N 是员工人数。我们可以在 DFS 中查询每个员工。
   * <p>  空间复杂度：O(N)，计算 DFS 时隐式调用堆栈的大小。
   *
   * @param employees
   * @param queryid
   * @return
   */
  Map<Integer, Employee> emap;

  public int getImportance2(List<Employee> employees, int queryid) {
    emap = new HashMap();
    for (Employee e : employees) {
      emap.put(e.id, e);
    }
    return dfs2(queryid);
  }

  public int dfs2(int eid) {
    Employee employee = emap.get(eid);
    int ans = employee.importance;
    for (Integer subid : employee.subordinates) {
      ans += dfs2(subid);
    }
    return ans;
  }
}

class Employee {

  public int id;
  public int importance;
  public List<Integer> subordinates;
};
