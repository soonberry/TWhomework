package parser;

/**
 * Created by shuwenli on 14-11-21.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Parser {

public List<String> parse(String fileName) {
    // TODO Auto-generated method stub
    String fileAddr="/home/shuwenli/IdeaProjects/ideaWorkspace/file/"+fileName;
    File file = new File(fileAddr);
    BufferedReader reader = null;
    List<String> itemList=new ArrayList<String>();
    String itemString = null;
    int line = 1;

    try {
//        System.out.println("以行为单位读取文件内容，一次读一整行：");
        reader = new BufferedReader(new FileReader(file));
        while ((itemString = reader.readLine()) != null) {
 //           System.out.println("Line" + line + ":" + itemString);
            itemList.add(itemString);
            line++;
        }
        reader.close();

    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } finally {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    return itemList;
}
//
//    protected List<V> analyseList(List itemList){
//        List<V> result=new ArrayList<List>();
//        List<String> everyLine=new ArrayList<String>();
//        for (String item:itemList){
//            //解析每一行
//            //用split解析
//            everyLine=item.split(/*正则表达式*/);
//            result.add(everyLine);
//        }
//        return result;
//    }



}
