package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2023-01-07 16:22
 */
public class exercise467_数字的补数 {
    public static int findComplement(int num) {
        String bin_num = Integer.toBinaryString(num);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bin_num.length(); i++) {
            int c = bin_num.charAt(i) - '0';
            if (c == 1) {
                stringBuffer.append(0);
            }else {
                stringBuffer.append(1);
            }
        }

        return Integer.parseInt(stringBuffer.toString(),2);
    }

    // 答案解法：位运算
    // 例如，num的二进制是101，找对最高位的1（第二位），那么mask就是二进制的 （1000（1在第三位） - 1）二进制相减111
    // 本质就是这个数的二进制为和长度相等的二进制位全为1的数异或，就是相反
    public int findComplement2(int num) {
        int highbit = 0;
        for (int i = 1; i <=30 ; i++) {
            if (num >= 1 << i) {
                highbit = i;
            } else {
                break;
            }
        }
        // 101
        // mask  = 1000  -1 0111

        int mask = highbit == 30 ? 0x7fffffff : (1 << (highbit + 1)) - 1;
        // 与二进制位全是1的异或相当于取反
        return num ^ mask;
    }

    public static void main(String[] args) {
        System.out.println(findComplement(1));
    }
}
