package ru.croc.jws.messenger.game;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Words {
    private ArrayList<String> say = new ArrayList<>();
    private ArrayList<String> words1 = new ArrayList<>();
    private char ch = ' ';

    public String getWord(String word) {
        char[] strToArray = word.toCharArray();
        for (int i = 0; i < words1.size(); i++) {
            char[] strWords = words1.get(i).toCharArray();
            if(say.contains(word))return "Слово уже было";
            if(!words1.contains(word))return "Нет такого слова " + word;
            if(ch != strToArray[0] && say.size() != 0)return "Слово должно начинаться с " + ch;
            if((strToArray[strToArray.length-1]+"" ).equalsIgnoreCase(" "+strWords[0])){
                //say.add(word);
                say.add(words1.get(i));
                ch = (strWords[strWords.length-1]);
                return words1.get(i);
            }
        }
        return null;
    }

    public Words() {
        try {
            readWords();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void clear(){
        System.out.println("Clear");
        say.clear();
    }

    private void readWords() throws FileNotFoundException {
        try (Scanner string_new = new Scanner(new FileReader("game\\words\\cities.txt"))) {
            while (string_new.hasNextLine()){
                words1.add(string_new.nextLine());
            }
        }
    }

}
