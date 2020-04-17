package com.sogou.speech.util;

import java.util.ArrayList;

public class ShortByteUtil {

    /**
     * 短整型与字节的转换，一个short是2个字节
     * @param
     * @return 两位的字节数组
     */
    public static byte[] shortToByte(short number) {
        int temp = number;
        byte[] b = new byte[2];
        for (int i = 0; i < b.length; i++) {
            b[i] = new Integer(temp & 0xff).byteValue();// 将最低位保存在最低位
            temp = temp >> 8; // 向右移8位
        }
        return b;
    }

    /**
     * 字节的转换与短整型
     * @param
     * @return 短整型
     */
    public static short byteToShort(byte[] b) {
        short s = 0;
        short s0 = (short) (b[0] & 0xff);// 最低位
        short s1 = (short) (b[1] & 0xff);
        s1 <<= 8;
        s = (short) (s0 | s1);
        return s;
    }

    /**
     * 将一个字节数组转换为short数组
     * @param b
     */
    public static short[] byteArray2ShortArray(byte[] b) {
        int len = b.length / 2;
        int index = 0;
        short[] re = new short[len];
        byte[] buf = new byte[2];
        for (int i = 0; i < b.length;) {
            buf[0] = b[i];
            buf[1] = b[i + 1];
            short st = byteToShort(buf);
            re[index] = st;
            index++;
            i += 2;
        }
        return re;
    }

    /**
     * 将一个short数组反转为字节数组
     * @param b
     */
    public static byte[] shortArray2ByteArray(short[] b) {
        byte[] rebt = new byte[b.length * 2];
        int index = 0;
        for (int i = 0; i < b.length; i++) {
            short st = b[i];
            byte[] bt = shortToByte(st);
            rebt[index] = bt[0];
            rebt[index + 1] = bt[1];
            index += 2;
        }
        return rebt;
    }

    public static byte[] addBytes(byte[] data1, byte[] data2) {
        byte[] data3 = new byte[data1.length + data2.length];
        System.arraycopy(data1, 0, data3, 0, data1.length);
        System.arraycopy(data2, 0, data3, data1.length, data2.length);
        return data3;

    }

    public static byte[] byteMergeAll(ArrayList<byte[]> values) {
        if (values != null) {
            int length_byte = 0;
            int listSize = values.size();
            if (listSize > 0) {
                for (int i = 0; i < listSize; i++) {
                    byte[] bytes = values.get(i);
                    if (bytes != null) {
                        length_byte += bytes.length;
                    }

                }
                byte[] all_byte = new byte[length_byte];
                int countLength = 0;
                for (int i = 0; i < listSize; i++) {
                    byte[] b = values.get(i);
                    if (b != null) {
                        System.arraycopy(b, 0, all_byte, countLength, b.length);
                        countLength += b.length;
                    }
                }
                return all_byte;
            }

        }

        return null;

    }

    /**
     * int转byte，一个int是4个字节，即32bit
     * @param num
     * @return
     */
    public static byte[] int2Bytes(int num) {
        byte[] bytes = new byte[4];
        bytes[0] = (byte)(num & 0x000000ff);//得到num的低八位
        bytes[1] = (byte)(num & 0x0000ff00);
        bytes[2] = (byte)(num & 0x00ff0000);
        bytes[3] = (byte)(num & 0xff000000);//得到num的高八位
        return bytes;
    }

    public static int bytes2Int(byte[] b) {
        int res = 0;
        for(int i=0;i<b.length;i++){
            res += (b[i] & 0xff) << (i*8);
        }
        return res;
    }
}
