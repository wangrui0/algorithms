package org.leetcode.shunxu.leet1000.ch950;

import java.util.HashSet;
import java.util.Set;

/**
 * <p> 929. 独特的电子邮件地址
 *
 * <p>每封电子邮件都由一个本地名称和一个域名组成，以 @ 符号分隔。
 *
 * <p>例如，在 alice@leetcode.com中， alice 是本地名称，而 leetcode.com 是域名。
 *
 * <p>除了小写字母，这些电子邮件还可能包含 '.' 或 '+'。
 *
 * <p>如果在电子邮件地址的本地名称部分中的某些字符之间添加句点（'.'），则发往那里的邮件将会转发到本地名称中没有点的同一地址。例如，"alice.z@leetcode.com” 和 “alicez@leetcode.com”
 * 会转发到同一电子邮件地址。 （请注意，此规则不适用于域名。）
 *
 * <p>如果在本地名称中添加加号（'+'），则会忽略第一个加号后面的所有内容。这允许过滤某些电子邮件，例如 m.y+name@email.com 将转发到 my@email.com。 （同样，此规则不适用于域名。）
 *
 * <p>可以同时使用这两个规则。
 *
 * <p>给定电子邮件列表 emails，我们会向列表中的每个地址发送一封电子邮件。实际收到邮件的不同地址有多少？
 *
 *
 *
 * <p>示例：
 *
 * <p>输入：["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * <p>输出：2
 * <p>解释：实际收到邮件的是 "testemail@leetcode.com" 和 "testemail@lee.tcode.com"。
 * <p>https://leetcode-cn.com/problems/unique-email-addresses/
 * <p>@author: wangrui
 * <p>@date: 2021/3/21
 */
public class Ch929UniqueEmailAddresses {

  public int numUniqueEmails(String[] emails) {
    Set<String> set = new HashSet<>();
    for (int i = 0; i < emails.length; i++) {
      String email = emails[i];
      int index = email.indexOf("@");
      String sub1 = email.substring(0, index);
      if (sub1.contains("+")) {
        sub1 = sub1.substring(0, sub1.indexOf("+"));
      }
      sub1 = sub1.replaceAll("\\.", "");
      String sub2 = email.substring(index);
      set.add(sub1 + sub2);
    }
    return set.size();
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(C)，其中 C 是电子邮件地址的数目。
   *
   * <p> 空间复杂度：O(C)。
   *
   * @param emails
   * @return
   */
  public int numUniqueEmails2(String[] emails) {
    Set<String> seen = new HashSet();
    for (String email : emails) {
      int i = email.indexOf('@');
      String local = email.substring(0, i);
      String rest = email.substring(i);
      if (local.contains("+")) {
        local = local.substring(0, local.indexOf('+'));
      }
      // Note: one should escape the specific character '.',
      // since it is treated as a regex expression.
      local = local.replaceAll("\\.", "");
      seen.add(local + rest);
    }

    return seen.size();
  }
}
