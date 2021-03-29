package org.leetcode.shunxu.ch800;

/**
 * <p>RGB 颜色用十六进制来表示的话，每个大写字母都代表了某个从 0 到 f 的 16 进制数。
 *
 * <p>RGB 颜色 “#AABBCC” 可以简写成 “#ABC” 。例如，"#15c" 其实是 “#1155cc” 的简写。
 *
 * <p>现在，假如我们分别定义两个颜色 "#ABCDEF" 和 "#UVWXYZ"，则他们的相似度可以通过这个表达式 -(AB - UV)^2 - (CD - WX)^2 - (EF - YZ)^2 来计算。
 *
 * <p>那么给定颜色 “#ABCDEF”，请你返回一个与 #ABCDEF 最相似的 7 个字符代表的颜色，并且它是可以被简写形式表达的。（比如，可以表示成类似 “#XYZ” 的形式）
 *
 *
 * <p>示例 1：
 * <p>输入：color = "#09f166"
 * <p>输出："#11ee66"
 * <p>解释：
 * <p>因为相似度计算得出 -(0x09 - 0x11)^2 -(0xf1 - 0xee)^2 - (0x66 - 0x66)^2 = -64 -9 -0 = -73
 * <p>这已经是所有可以简写的颜色中最相似的了
 *
 * <p>注意：
 * <p>color 是一个长度为 7 的字符串
 * <p>color 是一个有效的 RGB 颜色：对于仍和 i > 0，color[i] 都是一个在 0 到 f 范围的 16 进制数
 * <p>假如答案具有相同的（最大）相似度的话，都是可以被接受的
 * <p>所有输入、输出都必须使用小写字母，并且输出为 7 个字符
 * https://leetcode-cn.com/problems/similar-rgb-color/
 * <p>@author: wangrui
 * <p>@date: 2021/3/26
 */
public class Ch800SimilarRgbColor {

  /**
   * <p> 解题思路
   * <p>  首先，能简写的颜色说明是两个一样字符组成的十六进制数字，比如：00、aa、dd等。
   *
   * <p>  通过相似度的计算表达式可知，RGB三种颜色的独立的，因此可以对三种颜色单独计算，然后拼接即可。
   * <p>
   *  <p> 先分析16进制的 0x00、0x11、0x22、…、0xff 的规律，发现每一个元素都是上一个加了一个 0x11，也就是十进制的 17。
   * <p>
   *  <p> 也就是说，可以简写的颜色数值其实都是十进制数 17 的倍数。
   * <p>
   *   <p>为了编程方便，一律把十六进制转成十进制再计算。
   * <p>
   *  <p> 假设颜色为 0xbc，转成十进制为 188，把它除以 17，结果为 11 余 1。
   * <p>
   *   <p>学过除法的我们知道，被除数为 17，那么余数只能是 1-16。
   * <p>
   *   <p>1-16 的中间值为 8 ，也就是说，如果余数小于 8 ，那么除数距离上一个数近一点，如果余数大于 8 ，那么除数距离下一个数近一点。
   * <p>
   *   <p>0xbc 除以 17 后，余数为 1，也就是说，如果把 0xbc 减去 1，就刚好是 17 的倍数，即 0xbb，可以化简。
   * <p>
   *   <p>0xa6 除以 17 后，余数为 13，也就是说，如果把 0xa6 加上 4，就刚好是 17 的倍数，即 0xaa，可以化简。
   * <p>
   *  <p> 有了上面的结论，我们对 RGB 分别进行单独计算，把结果进行拼接。
   *
   * @param color
   * @return
   */
  public String similarRGB(String color) {
    // color = "#XXYYZZ"
    return "#" +
        f(color.substring(1, 3)) +  // XX
        f(color.substring(3, 5)) +  // YY
        f(color.substring(5));  // ZZ
  }

  public String f(String comp) {
    int decComp = Integer.parseInt(comp, 16); // 16 进制转 10 进制
    int integral = decComp / 17;    // 整数值
    int remainder = decComp % 17;   // 余数值
    int multiple;
    if (remainder > 8) {
      multiple = integral + 1;
    } else {
      multiple = integral;
    }
    int decResult = multiple * 17; // 前面除以 17，现在乘回来
//    %02x
//    x 表示以十六进制形式输出
//    02 表示不足两位,，前面补0输出，如果超过两位，则以实际输出
    String hexResult = String.format("%02x", decResult);    // 转成16进制字符串
    return hexResult;
  }
}
