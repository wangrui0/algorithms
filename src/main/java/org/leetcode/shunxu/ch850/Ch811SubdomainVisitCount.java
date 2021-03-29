package org.leetcode.shunxu.ch850;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>811. 子域名访问计数
 *
 * <p>一个网站域名，如"discuss.leetcode.com"，包含了多个子域名。作为顶级域名，常用的有"com"，下一级则有"leetcode.com"，最低的一级为"discuss.leetcode.com"。当我们访问域名"discuss.leetcode.com"时，也同时访问了其父域名"leetcode.com"以及顶级域名
 * "com"。
 *
 * <p>给定一个带访问次数和域名的组合，要求分别计算每个域名被访问的次数。其格式为访问次数+空格+地址，例如："9001 discuss.leetcode.com"。
 *
 * <p>接下来会给出一组访问次数和域名组合的列表cpdomains 。要求解析出所有域名的访问次数，输出格式和输入格式相同，不限定先后顺序。
 *
 * <p>示例 1:
 * <p>输入:
 * <p>["9001 discuss.leetcode.com"]
 * <p>输出:
 * <p>["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
 * <p>说明:
 * <p>例子中仅包含一个网站域名："discuss.leetcode.com"。按照前文假设，子域名"leetcode.com"和"com"都会被访问，所以它们都被访问了9001次。
 *
 * <p>示例 2
 * <p>输入:
 * <p>["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
 * <p>输出:
 * <p>["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
 * <p>说明:
 * <p>按照假设，会访问"google.mail.com" 900次，"yahoo.com" 50次，"intel.mail.com" 1次，"wiki.org" 5次。
 * <p>而对于父域名，会访问"mail.com" 900+1 = 901次，"com" 900 + 50 + 1 = 951次，和 "org" 5 次。
 *
 * <p>注意事项：
 *
 * <p>     cpdomains 的长度小于 100。
 * <p>    每个域名的长度小于100。
 * <p>    每个域名地址包含一个或两个"."符号。
 * <p>    输入中任意一个域名的访问次数都小于10000。
 *
 * <p>通过次数13,338
 * <p>提交次数19,181
 * <p>在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/subdomain-visit-count/
 * <p>@author: wangrui
 * <p>@date: 2021/3/26
 */
public class Ch811SubdomainVisitCount {

  public static void main(String[] args) {
    System.out.println(
        subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
  }

  public static List<String> subdomainVisits(String[] cpdomains) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : cpdomains) {
      String[] split = word.split("\\s+");
      Integer num = Integer.parseInt(split[0]);
      String[] yu = split[1].split("\\.");
      String cur = "";
      for (int i = yu.length - 1; i >= 0; i--) {
        cur = yu[i] + (i == yu.length - 1 ? "" : ".") + cur;
        map.put(cur, map.getOrDefault(cur, 0) + num);
      }
    }
    List<String> list = new ArrayList<>();
    for (String key : map.keySet()) {
      list.add(map.get(key) + " " + key);
    }
    return list;

  }

  /**
   * <p>复杂度分析
   *
   * <p> 时间复杂度：O(N)，其中 NNN 是数组 cpdomains 的长度，这里假设 cpdomains 中每个元素的长度都是常数级别的。
   *
   * <p>空间复杂度：O(N)，用于存储哈希映射。
   *
   * @param cpdomains
   * @return
   */
  public List<String> subdomainVisits_2(String[] cpdomains) {
    Map<String, Integer> counts = new HashMap();
    for (String domain : cpdomains) {
      String[] cpinfo = domain.split("\\s+");
      String[] frags = cpinfo[1].split("\\.");
      int count = Integer.valueOf(cpinfo[0]);
      String cur = "";
      for (int i = frags.length - 1; i >= 0; --i) {
        cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
        counts.put(cur, counts.getOrDefault(cur, 0) + count);
      }
    }

    List<String> ans = new ArrayList();
    for (String dom : counts.keySet()) {
      ans.add("" + counts.get(dom) + " " + dom);
    }
    return ans;
  }

}
