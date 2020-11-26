import java.util.*;

/**
 1370. 上升下降字符串
 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 重复步骤 2 ，直到你没法从 s 中选择字符。
 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 重复步骤 5 ，直到你没法从 s 中选择字符。
 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 请你返回将 s 中字符重新排序后的 结果字符串 。
 示例 1：
 输入：s = "aaaabbbbcccc"
 输出："abccbaabccba"
 解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
 第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
 第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
 第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
 第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"
 示例 2：
 输入：s = "rat"
 输出："art"
 解释：单词 "rat" 在上述算法重排序以后变成 "art"
 示例 3：
 输入：s = "leetcode"
 输出："cdelotee"
 示例 4：
 输入：s = "ggggggg"
 输出："ggggggg"
 示例 5：
 输入：s = "spo"
 输出："ops"
 提示：
 1 <= s.length <= 500
 s 只包含小写英文字母。

 */
public class IncreasingDecreasingString {
    public static void main(String[] args) {
    String src="aaaabbbbcccc";
        String des = sortString(src);
        System.out.println(des);
    }
    //笨方法：1排序 2遍历插入
//    public static String sortString(String s) {
//        if(s==null || s.length()==0){
//            return s;
//        }
//        char[] chars = s.toCharArray();
//        Arrays.sort(chars);
//        StringBuilder builder=new StringBuilder();
//        int change=0;
//        boolean flag=true;
//        while(change<chars.length){
//            char start='0';
//            if(flag){
//                for (int i = 0; i < chars.length; i++) {
//                    if(chars[i]>start){
//                        builder.append(chars[i]);
//                        start=chars[i];
//                        chars[i]='0';
//                        change++;
//                    }
//                }
//            }
//            if(!flag) {
//                for (int i = chars.length-1; i > -1; i--) {
//                    if((chars[i]<start && chars[i]!='0') || (start=='0'&& chars[i]!='0')){
//                        builder.append(chars[i]);
//                        start=chars[i];
//                        chars[i]='0';
//                        change++;
//                    }
//                }
//            }
//            flag=!flag;
//        }
//        return builder.toString();
//    }
    //都是小写字母，且要求按正序，逆序排序，
    public static  String sortString(String s){
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)-'a']++;
        }
        int change=0;
        StringBuffer buffer = new StringBuffer();
        while (change<s.length()){
            for (int i = 0; i < chars.length; i++) {
                if(chars[i]>0){
                    buffer.append((char)('a'+i));
                    chars[i]--;
                    change++;
                }
            }
            if(change<s.length()){
                for (int i = chars.length-1; i > -1; i--) {
                    if(chars[i]>0){
                        buffer.append((char)('a'+i));
                        chars[i]--;
                        change++;
                    }
                }
            }
        }
        return buffer.toString();
    }
}
