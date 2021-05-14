package org.company.meituan.all.week01.doing;

import java.net.*;
import java.util.regex.Pattern;


/**
 * <p>468. 验证IP地址
 *
 * <p>编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址。
 *
 * <p>    如果是有效的 IPv4 地址，返回 "IPv4" ；
 * <p>    如果是有效的 IPv6 地址，返回 "IPv6" ；
 * <p>    如果不是上述类型的 IP 地址，返回 "Neither" 。
 *
 * <p>IPv4 地址由十进制数和点来表示，每个地址包含 4 个十进制数，其范围为 0 - 255， 用(".")分割。比如，172.16.254.1；
 *
 * <p>同时，IPv4 地址内的数不会以 0 开头。比如，地址 172.16.254.01 是不合法的。
 *
 * <p>IPv6 地址由 8 组 16 进制的数字来表示，每组表示 16 比特。这些组数字通过 (":")分割。比如,  2001:0db8:85a3:0000:0000:8a2e:0370:7334
 * 是一个有效的地址。而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。所以， 2001:db8:85a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址 (即，忽略 0
 * 开头，忽略大小写)。
 *
 * <p>然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。 比如， 2001:0db8:85a3::8A2E:0370:7334 是无效的 IPv6 地址。
 *
 * <p>同时，在 IPv6 地址中，多余的 0 也是不被允许的。比如， 02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：IP = "172.16.254.1"
 * <p>输出："IPv4"
 * <p>解释：有效的 IPv4 地址，返回 "IPv4"
 *
 * <p>示例 2：
 *
 * <p>输入：IP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * <p>输出："IPv6"
 * <p>解释：有效的 IPv6 地址，返回 "IPv6"
 *
 * <p>示例 3：
 *
 * <p>输入：IP = "256.256.256.256"
 * <p>输出："Neither"
 * <p>解释：既不是 IPv4 地址，又不是 IPv6 地址
 *
 * <p>示例 4：
 *
 * <p>输入：IP = "2001:0db8:85a3:0:0:8A2E:0370:7334:"
 * <p>输出："Neither"
 *
 * <p>示例 5：
 *
 * <p>输入：IP = "1e1.4.5.6"
 * <p>输出："Neither"
 *
 *
 *
 * <p>提示：
 *
 * <p>    IP 仅由英文字母，数字，字符 '.' 和 ':' 组成。
 *
 * <p>通过次数19,047
 * <p>提交次数78,968
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/validate-ip-address/
 * <p>@author: wangrui
 * <p>@date: 2021/5/10
 */
public class ACh026_468ValidateIpAddress验证IP地址 {


  public String validIPAddress_1(String IP) {
    try {
      return (InetAddress.getByName(IP) instanceof Inet6Address) ? "IPv6" : "IPv4";
    } catch (Exception e) {
    }
    return "Neither";
  }


  String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
  Pattern pattenIPv4 =
      Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");

  String chunkIPv6 = "([0-9a-fA-F]{1,4})";
  Pattern pattenIPv6 =
      Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");

  /**
   * 复杂度分析
   * <p>
   * 时间复杂度：O(1)。
   * <p>
   * 空间复杂度：O(1)
   *
   * @param IP
   * @return
   */
  public String validIPAddress_2(String IP) {
    if (IP.contains(".")) {
      return (pattenIPv4.matcher(IP).matches()) ? "IPv4" : "Neither";
    } else if (IP.contains(":")) {
      return (pattenIPv6.matcher(IP).matches()) ? "IPv6" : "Neither";
    }
    return "Neither";
  }

  /**
   * <p>方法二：分治法
   * 复杂度分析
   * <p>
   * 时间复杂度：O(1)。
   * <p>
   * 空间复杂度：O(1)
   *
   * @param IP
   * @return
   */
  public String validIPAddress_3(String IP) {
    if (IP.chars().filter(ch -> ch == '.').count() == 3) {
      return validateIPv4(IP);
    } else if (IP.chars().filter(ch -> ch == ':').count() == 7) {
      return validateIPv6(IP);
    } else {
      return "Neither";
    }
  }


  public String validateIPv4(String IP) {
    String[] nums = IP.split("\\.", -1);
    for (String x : nums) {
      // Validate integer in range (0, 255):
      // 1. length of chunk is between 1 and 3
      if (x.length() == 0 || x.length() > 3) {
        return "Neither";
      }
      // 2. no extra leading zeros
      if (x.charAt(0) == '0' && x.length() != 1) {
        return "Neither";
      }
      // 3. only digits are allowed
      for (char ch : x.toCharArray()) {
        if (!Character.isDigit(ch)) {
          return "Neither";
        }
      }
      // 4. less than 255
      if (Integer.parseInt(x) > 255) {
        return "Neither";
      }
    }
    return "IPv4";
  }

  public String validateIPv6(String IP) {
    String[] nums = IP.split(":", -1);
    String hexdigits = "0123456789abcdefABCDEF";
    for (String x : nums) {
      // Validate hexadecimal in range (0, 2**16):
      // 1. at least one and not more than 4 hexdigits in one chunk
      if (x.length() == 0 || x.length() > 4) {
        return "Neither";
      }
      // 2. only hexdigits are allowed: 0-9, a-f, A-F
      for (Character ch : x.toCharArray()) {
        if (hexdigits.indexOf(ch) == -1) {
          return "Neither";
        }
      }
    }
    return "IPv6";
  }


}


