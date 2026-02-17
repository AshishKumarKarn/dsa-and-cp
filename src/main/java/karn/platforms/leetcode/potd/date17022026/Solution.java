package karn.platforms.leetcode.potd.date17022026;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-watch/submissions/1921674014/?envType=daily-question&envId=2026-02-17
public class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        //own sol start from 00:00 to 11:59 and check if number of bits = turnedOn then add it to the result.
        List<String> result = new ArrayList<>();
        for (int hh = 0; hh < 12; hh++) {
            for (int mm = 0; mm < 60; mm++) {
                int bitsInHour = countSetBits(hh);
                int bitsInMinutes = countSetBits(mm);
                if (bitsInHour + bitsInMinutes == turnedOn) {
                    if ((mm / 10) > 0) {
                        result.add(hh + ":" + mm);
                    } else {
                        result.add(hh + ":0" + mm);
                    }
                }
            }
        }
        return result;
    }

    private int countSetBits(int time) {
        int count = 0;
        while (time > 0) {
            count += (time & 1);
            time >>= 1;
        }
        return count;
    }
}
