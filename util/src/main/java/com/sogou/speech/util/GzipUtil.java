package com.sogou.speech.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipUtil {
    private static final String TAG = GzipUtil.class.getSimpleName();
    private static final int BUFFER_SIZE = 4096;

    public static byte[] decompress(byte[] data) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            decompress(byteArrayInputStream, byteArrayOutputStream);
            data = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            byteArrayInputStream.close();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.loge(TAG, "decompress Exception:" + e.getMessage());
        }

        return null;

    }

    public static void decompress(InputStream is, OutputStream os) {
        try {
            GZIPInputStream gis = new GZIPInputStream(is);
            int count;
            byte data[] = new byte[BUFFER_SIZE];
            while ((count = gis.read(data, 0, BUFFER_SIZE)) != -1) {
                os.write(data, 0, count);
            }
            gis.close();
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.loge(TAG, "decompress Exception:" + e.getMessage());
        }


    }

    public static byte[] compress(byte[] data) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            compress(byteArrayInputStream, byteArrayOutputStream);

            byte[] output = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            byteArrayInputStream.close();
            return output;
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.loge(TAG, "compress Exception:" + e.getMessage());
        }
        return null;


    }


    public static void compress(InputStream is, OutputStream os) {
        try {
            GZIPOutputStream gos = new GZIPOutputStream(os);
            int count;
            byte data[] = new byte[BUFFER_SIZE];
            while ((count = is.read(data, 0, BUFFER_SIZE)) != -1) {
                gos.write(data, 0, count);
            }
            gos.finish();
            gos.flush();
            gos.close();
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.loge(TAG, "compress Exception:" + e.getMessage());
        }
    }

}
