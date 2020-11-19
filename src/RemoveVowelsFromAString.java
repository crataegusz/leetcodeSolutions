import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1119. 删去字符串中的元音
 * 给你一个字符串 S，请你删去其中的所有元音字母（ 'a'，'e'，'i'，'o'，'u'），并返回这个新字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入："leetcodeisacommunityforcoders"
 * 输出："ltcdscmmntyfrcdrs"
 * 示例 2：
 *
 * 输入："aeiou"
 * 输出：""
 *
 *
 * 提示：
 *
 * S 仅由小写英文字母组成。
 * 1 <= S.length <= 1000
 * https://leetcode-cn.com/problems/remove-vowels-from-a-string/
 */
public class RemoveVowelsFromAString {
    public static void main(String[] args) {
        System.out.println(removeVowels("leetcodeisacommunityforcoders"));
        System.out.println(removerVowelsAPI("leetcodeisacommunityforcoders"));
    }
    //一逐个判断，可不使用API，拆分成单个字符
    public static String removeVowels(String S) {
        char[] chars = S.toCharArray();
        List<Character> characters = Arrays.asList('a', 'e', 'i', 'o', 'u');
        StringBuilder buffer = new StringBuilder("");
        for (char c : chars) {
            if(characters.contains(c)){
                continue;
            }
            buffer.append(c);
        }
        return buffer.toString();
    }
    //二 使用api的正则表达式
    public static String removerVowelsAPI(String S){
        return S.replaceAll("[aeiou]","");
    }
}
