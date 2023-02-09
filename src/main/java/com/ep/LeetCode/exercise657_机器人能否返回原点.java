package com.ep.LeetCode;

import java.util.HashMap;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-09 11:41
 */
public class exercise657_机器人能否返回原点 {
    public boolean judgeCircle(String moves) {
       int x = 0, y = 0;
       int length = moves.length();
        for (int i = 0; i < length; i++) {
            char move = moves.charAt(i);
            if (move == 'U') {
                y++;
            } else if (move == 'D') {
                y--;
            } else if (move == 'L') {
                x--;
            }else if (move == 'R') {
                x++;
            }
        }
        return x == 0 && y == 0;

    }
}
