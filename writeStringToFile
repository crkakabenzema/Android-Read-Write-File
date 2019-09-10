package com.example.version5;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.RandomAccessFile;

public class WriteTxtofPosition {
    public void writeData(String content, Context context) {
        String filePath = context.getFilesDir().getPath();
        String fileName = "positionData.txt";
        writeTxtToFile(content, filePath, fileName);
    }
    
    // write string to the txt document
    private void writeTxtToFile(String strcontent, String filePath, String fileName) {
        //after making directory, make file. If not, error.
        makeFilePath(filePath, fileName);

        String strFilePath = filePath + fileName;
        // each time wirte, change lines. 
        String strContent = strcontent + "\r\n";
        try {
            File file = new File(strFilePath);
            if (!file.exists()) {
                Log.d("TestFile", "Create the file:" + strFilePath);
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            RandomAccessFile raf = new RandomAccessFile(file, "rwd");
            raf.seek(file.length());
            raf.write(strContent.getBytes());
            raf.close();
        } catch (Exception e) {
            Log.e("TestFile", "Error on write File:" + e);
        }
    }

//make a file

    private File makeFilePath(String filePath, String fileName) {
        File file = null;
        makeRootDirectory(filePath);
        try {
            file = new File(filePath + fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

//make a directory

    private static void makeRootDirectory(String filePath) {
        File file = null;
        try {
            file = new File(filePath);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
            Log.i("error:", e + "");
        }
    }
}
