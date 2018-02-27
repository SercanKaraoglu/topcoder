/*
 * TopCoder, Inc (c)2003
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 */

package com.topcoder.examples;

public class ABBA {
    private String reverse(String target) {
        int start = 0;
        int end = target.length() - 1;
        char[] chars = target.toCharArray();
        while (end > start) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            end--;
            start++;
        }
        return new String(chars);
    }

    public String canObtain(final String initial, final String target) {
        String t = target;
        for (int pos = target.length() - 1; pos >= 0; pos--) {
            if(t.equals(initial)){
                return "Possible";
            }
            char latest = t.charAt(pos);
            t = t.substring(0, pos);
            if (latest == 'B') {
                t = reverse(t);
            }
        }
        return "Impossible";
    }
}
