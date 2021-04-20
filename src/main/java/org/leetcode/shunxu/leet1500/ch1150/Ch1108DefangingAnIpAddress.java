package org.leetcode.shunxu.leet1500.ch1150;

/**
 * 1108. IP 地址无效化
 * <p>
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 * <p>
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：address = "1.1.1.1" 输出："1[.]1[.]1[.]1"
 * <p>
 * 示例 2：
 * <p>
 * 输入：address = "255.100.50.0" 输出："255[.]100[.]50[.]0"
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给出的 address 是一个有效的 IPv4 地址 https://leetcode-cn.com/problems/defanging-an-ip-address/
 *
 * @author: wangrui
 * @date: 2021/4/5
 */
public class Ch1108DefangingAnIpAddress {

  public String defangIPaddr(String address) {
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < address.length(); i++) {
      if (address.charAt(i) == '.') {
        stringBuffer.append("[.]");
      } else {
        stringBuffer.append(address.charAt(i));
      }
    }
    return new String(stringBuffer);
  }

  public String defangIPaddr_2(String address) {
    return address.replace(".", "[.]");
  }

  public String defangIPaddr_3(String address) {
    StringBuilder s = new StringBuilder(address);
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '.') {
        s.insert(i + 1, ']');// 先插入后面，此时 i 下标仍是'.'
        s.insert(i, '[');// 插入 '.' 前面，此时 i 下标是'[' ,i+2 下标为']'
        i += 3;// 故 i 直接加 3，为下一个字符，注意此时已经是原来 i+1 下标的字符了；
        //此次循环结束进入下次循环还会进行加 1，不过又因为 ip 地址格式的原因，不会有连续的两个 '.' 连着；
        //所以这个位置绝不可能是 '.'，所以再加 1，也没问题。
      }
    }
    return s.toString();
  }


  public String defangIPaddr_4(String address) {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < address.length(); i++) {
      if (address.charAt(i) == '.') {
        //s.append('[');
        //s.append('.');
        //s.append(']');
        s.append("[.]");
      } else {
        s.append(address.charAt(i));
      }
    }
    return s.toString();
  }


}


