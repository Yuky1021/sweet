package com.aaa.imageOCR;
import java.io.File;
import net.sourceforge.tess4j.*;

public class TesseractExample1 {
    public static void main(String[] args) {

        //2
//        File imageFile = new File("C:\\Users\\Administrator\\Desktop\\mgd.jpg");
//        ITesseract instance = new Tesseract();  // JNA Interface Mapping
////         ITesseract instance = new Tesseract1(); // JNA Direct Mapping
//        instance.setDatapath("D:\\tessdata");
////        instance.setLanguage("chi_sim");//添加中文字库
//        try {
//            String result = instance.doOCR(imageFile);
//            System.out.println(result);
//        } catch (TesseractException e) {
//            System.err.println(e.getMessage());
//        }

        // 识别图片的路径（修改为自己的图片路径）
        String path = "D:\\S1\\sweet\\src\\main\\java\\com\\aaa\\imageOCR\\mgd.jpg";

        // 语言库位置（修改为跟自己语言库文件夹的路径）
        String lagnguagePath = "D:\\tessdata";


        File file = new File(path);
        System.out.println(file.exists());
        ITesseract instance = new Tesseract();

        //设置训练库的位置
        instance.setDatapath(lagnguagePath);

        //chi_sim ：简体中文， eng    根据需求选择语言库
        instance.setLanguage("chi_sim");
        String result = null;
        try {
            long startTime = System.currentTimeMillis();
            result =  instance.doOCR(file);
            long endTime = System.currentTimeMillis();
            System.out.println("Time is：" + (endTime - startTime) + " 毫秒");
        } catch (TesseractException e) {
            e.printStackTrace();
        }

        System.out.println("result: ");
        System.out.println(result);
    }
}
