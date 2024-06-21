package DSA.other;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public boolean isIsomorphicV2(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Character> sourceToTargetMap = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char sourceChar = str1.charAt(i);
            char targetChar = str2.charAt(i);

            if (!sourceToTargetMap.containsKey(sourceChar)) {
                if (sourceToTargetMap.containsValue(targetChar)) {
                    return false;
                }
                sourceToTargetMap.put(sourceChar, targetChar);
            } else {
                Character expectedTargetChar = sourceToTargetMap.get(sourceChar);
                if (targetChar != expectedTargetChar) {
                    return false;
                }
            }
        }

        return true;
    }
}
