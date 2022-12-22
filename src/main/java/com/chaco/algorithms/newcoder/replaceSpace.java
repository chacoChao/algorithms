package com.chaco.algorithms.nowcoder;

import java.util.Objects;

/**
 * https://www.nowcoder.com/practice/0e26e5551f2b489b9f58bc83aa4b6c68
 * 请实现一个函数，将一个字符串s中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * <p>
 * 数据范围:0 \le len(s) \le 1000 \0≤len(s)≤1000 。
 * 保证字符串中的字符为大写英文字母、小写英文字母和空格中的一种。
 * <p>
 * 输入："We Are Happy"
 * 返回值："We%20Are%20Happy"
 * <p>
 * 示例2
 * 输入：" "
 * 返回值："%20"
 */
public class replaceSpace {
    public static void main(String[] args) {
        String s = replaceSpace.replaceSpace("We Are Happy");
        System.out.println("replaceSpace.main:" + s);

        String s1 = replaceSpace.replaceSpace(" ");
        System.out.println("replaceSpace.main:" + s1);
    }

    public static String replaceSpace(String s) {
        String replaceStr = "%20";
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (Character c : chars) {
            if (Objects.equals(c, ' ')) {
                sb.append(replaceStr);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}