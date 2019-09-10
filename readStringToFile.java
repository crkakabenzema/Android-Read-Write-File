package com.example.version5;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class ReadTxtofPosition {
    public ReadTxtofPosition(){

    }

    public List<String> Txt(Context context) {
        //save each line from the data in List
        String filePath = context.getFilesDir().getPath() + "positionData.txt";

        List newList=new ArrayList<String>();
        try {
            File file = new File(filePath);
            int count = 0;//initialize key value
            if (file.isFile() && file.exists()) {//file exists
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
                BufferedReader br = new BufferedReader(isr);
                String lineTxt = null;
                while ((lineTxt = br.readLine()) != null) {
                    if (!"".equals(lineTxt)) {
                        String reds = lineTxt.split("\\+")[0];  //java regx
                        newList.add(count, reds);
                        count++;
                    }
                }
                isr.close();
                br.close();
            }else {
                WriteTxtofPosition writeTxtofPosition = new WriteTxtofPosition();
                writeTxtofPosition.writeData("" + 0, context);
                Log.e(TAG,"create a file");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newList;
    }
}
