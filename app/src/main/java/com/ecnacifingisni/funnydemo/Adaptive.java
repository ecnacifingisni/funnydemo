package com.ecnacifingisni.funnydemo;

import android.support.annotation.NonNull;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * 屏幕适配（dp）
 * 使用方法:
 * 1,找到自己使用的宽高，替换 baseWidth（宽），baseHeight（高）.
 * 2，选择自己要适配的屏幕宽放入 dppath中（别用非整数，如果屏幕不是整数，就向下取整）
 * 3，在自己的Test创建对象并调用main方法一次
 * 在项目中的运用，使用时都用这里面的替换dp。如：20dp就写成@dimens/dp_20
 * 好处，在项目开始时，只要将生成自己的baseWidth的文件使用，
 * 等最后适配时，根据需要的添加需要的尺寸进行适配。
 * <p>
 * 提示：如果自己项目不是默认的app，修改pathAdd的拼接,生成的文件默认是不添加到git等云平台的
 * 需要自己手动添加一次
 * <p>
 * <p>
 * Created by sjw on 2017/11/15.
 */

public class Adaptive {
    @NonNull
    private double[] dpPath = {360, 480, 720};//需要适配的宽
    private double baseWidth = 360;//默认的宽度
    private double baseHeight = 640;//默认的高度
    private String resPath = "";//res的绝对路径(一般不用改)
    @NonNull
    private String pathAdd = "\\app\\src\\main\\res\\";

    /**
     * 调用主函数
     */
    public static void main() {
        Adaptive ad = new Adaptive();
        ad.startCreate();
    }

    @NonNull
    public double[] getDpPath() {
        return dpPath;
    }

    public void setDpPath(@NonNull double[] dpPath) {
        this.dpPath = dpPath;
    }

    public double getBaseWidth() {
        return baseWidth;
    }

    public void setBaseWidth(double baseWidth) {
        this.baseWidth = baseWidth;
    }

    public double getBaseHeight() {
        return baseHeight;
    }

    public void setBaseHeight(double baseHeight) {
        this.baseHeight = baseHeight;
    }

    public String getResPath() {
        return resPath;
    }

    public void setResPath(String resPath) {
        this.resPath = resPath;
    }

    @NonNull
    public String getPathAdd() {
        return pathAdd;
    }

    public void setPathAdd(@NonNull String pathAdd) {
        this.pathAdd = pathAdd;
    }

    private void startCreate() {
        System.out.println("msg");
        if (resPath == null || "".equals(resPath)) {
            File file = new File("");
            String path = file.getAbsolutePath();
            resPath = path + pathAdd;
        }

        try {
            for (int i = 0; i < dpPath.length; i++) {
                initCreateOne(dpPath[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

}

    private void initCreateOne(double dpSize) throws IOException {
        System.out.println(dpSize + "dp---begin");
        String msg = getMessge(dpSize);
        int dirNameSize = (int) dpSize;
        String path = resPath + "values-w" + dirNameSize + "dp";
        String name = "dimens.xml";
        File fileDir = new File(path);
        if (!fileDir.exists()) {
            boolean b = fileDir.mkdir();
            System.out.println("create==" + b);
        }
        File file = new File(path, name);
        System.out.println("path==" + file.getPath());
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(msg);
        bufferedWriter.close();
        System.out.println(dpSize + "dp,done");

    }


    private int scale = 2;//设置位数
    private int roundingMode = 4;//表示四舍五入，可以选择其他舍值方式，例如去尾，等等.

    private String getMessge(double dpSize) {
        StringBuffer sb = new StringBuffer();
        sb.append(messageHead);
        double bese = dpSize / baseWidth;


        for (int i = 0; i <= baseHeight; i++) {
            double iBase = bese * i;
            if (i == 0) {
                String msg = "<dimen name=\"dp_" + i + "\">0dp</dimen>\n";
                sb.append(msg);
            } else {
                BigDecimal bd = new BigDecimal(iBase);
                bd = bd.setScale(scale, roundingMode);
                double d = bd.doubleValue();
                String msg = "<dimen name=\"dp_" + i + "\">" + d + "dp</dimen>\n";
                sb.append(msg);
            }

        }
        sb.append(messageFoot);
        return new String(sb);
    }

    @NonNull
    private String messageHead = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<resources>\n";
    @NonNull
    private String messageFoot = "</resources>";
}
