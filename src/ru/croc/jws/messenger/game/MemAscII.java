package ru.croc.jws.messenger.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class MemAscII {
    private ArrayList<String> file = new ArrayList();
    private final Random rnd = new Random(System.currentTimeMillis());

    public String memView(String memName) {
            String string_read = "";
            try (Scanner string_new = new Scanner(new FileReader("game\\mem\\" + memName + ".txt"))) {
                while (string_new.hasNextLine()) {
                    string_read += "\n" + new String(string_new.nextLine());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
       return string_read;
    }

    void memView(){
       File dir = new File("game\\mem");
       // если объект представляет каталог
       if(dir.isDirectory())
       {
           // получаем все вложенные объекты в каталоге
           for(File item : dir.listFiles()){
               StringBuilder s = new StringBuilder(item.getName());
               s.delete(s.length()-4, s.length());
                   file.add(String.valueOf(s));
           }
       }
    }

    public String memRand(){
        int random_number = 0 + (int) (rnd.nextInt(3) * file.size());
        return file.get(random_number);
    }

    public MemAscII() {
        memView();
    }

    public ArrayList getFile() {
        return file;
    }
}
