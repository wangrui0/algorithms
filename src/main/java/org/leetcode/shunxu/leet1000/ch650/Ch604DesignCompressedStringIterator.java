package org.leetcode.shunxu.leet1000.ch650;


/**
 * <p>给定一个压缩字符串，格式是字符 + 数字 + 字符 + 数字这样，每个字符后面跟一个数字，表示这个字符重复了多少次。要求设计遍历其的迭代器。
 * <p>如果在hasNext()为false的情况下调用了next()，则返回空格。
 * <p>https://leetcode-cn.com/problems/design-compressed-string-iterator/
 * <p>将这个字符串按字符 + 数字的小组合分组，依次遍历它们即可。代码如下：
 *
 * @Author: shenpei
 * @Date: 2021/3/17 10:12 下午
 */
public class Ch604DesignCompressedStringIterator {

  public static void main(String[] args) {
    Ch604DesignCompressedStringIterator s = new Ch604DesignCompressedStringIterator("a3s4t1u8");
    while (s.hasNext()) {
      System.out.print(s.next());
    }
  }

  //    a3s4t1u8
  private String s;
  // index记录下一组字符+数字这个子串的首字符下标，count记录当前遍历的字符还剩多少个
  private int index, count;
  // 记录当前遍历的组合的字符
  private char cur;

  public Ch604DesignCompressedStringIterator(String compressedString) {
    this.s = compressedString;
  }

  public char next() {
    if (!hasNext()) {
      return ' ';
    }

    if (this.count == 0) {
      this.cur = this.s.charAt(this.index);
      int j = this.index + 1;
      while (j < this.s.length() && Character.isDigit(this.s.charAt(j))) {
        j++;
      }

      this.count = Integer.parseInt(s.substring(this.index + 1, j));
      this.index = j;
    }

    this.count--;
    return this.cur;
  }

  public boolean hasNext() {
    return this.index < this.s.length() || this.count > 0;
  }
}
