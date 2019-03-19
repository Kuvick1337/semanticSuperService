package com.semantic;

import java.sql.Timestamp;

public class ServiceUtil {
    public static final int INDEX_NOT_FOUND = -1;

    public static int countMatches(final CharSequence str, final CharSequence sub) {
        if (isEmpty(str) || isEmpty(sub)) {
            return 0;
        }
        int count = 0;
        int idx = 0;
        while ((idx = indexOf(str, sub, idx)) != INDEX_NOT_FOUND) {
            count++;
            idx += sub.length();
        }
        return count;
    }

    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    static int indexOf(final CharSequence cs, final int searchChar, int start) {
        if (cs instanceof String) {
            return ((String) cs).indexOf(searchChar, start);
        }
        final int sz = cs.length();
        if (start < 0) {
            start = 0;
        }
        for (int i = start; i < sz; i++) {
            if (cs.charAt(i) == searchChar) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }


    static int indexOf(final CharSequence cs, final CharSequence searchChar, final int start) {
        return cs.toString().indexOf(searchChar.toString(), start);
    }

   public static Timestamp convertStringToTimestamp(String date) {
        Timestamp timeStamp = null;

        // Chrome sendet keine Sekunden mit --> Manuell anfügen
        if (ServiceUtil.countMatches(date, ":") == 1) {
            date += ":00";
        }

        // im String ist ein "T", welches die Konvertierung stoert
        timeStamp = Timestamp.valueOf(date.replace("T", " "));

        return timeStamp;
    }
}
