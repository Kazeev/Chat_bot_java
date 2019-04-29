package ru.croc.jws.messenger.game;

import java.io.*;
import java.util.*;

public class Сities {
    private ArrayList<String> say = new ArrayList<>();
    private ArrayList<String> words = new ArrayList<>();
    private char ch = ' ';

    public String getWord(String word) {
        char[] strToArray = word.toCharArray();
        for (int i = 0; i < words.size(); i++) {
            char[] strWords = words.get(i).toCharArray();
            if (say.contains(word)) return "Город уже был";
            if (!words.contains(word)) return "В россии нет города " + word;
            if (ch != strToArray[0] && say.size() != 0) return "Город должн начинаться с " + ch;
            if (word.equalsIgnoreCase("хз")) return "Ты проиграл )";
            if (((strToArray[strToArray.length - 1] + "").equalsIgnoreCase("" + strWords[0])) && strWords[strWords.length - 1] != 'ь' && strToArray[strToArray.length - 1] != 'ь') {
                return getString(word, i, strWords);
            } else if (((strToArray[strToArray.length - 2] + "").equalsIgnoreCase("" + strWords[0])) && strToArray[strToArray.length - 1] != 'ь') {
                return getString(word, i, strWords);
            } else if (((strToArray[strToArray.length - 2] + "").equalsIgnoreCase("" + strWords[0])) && strWords[strWords.length - 1] != 'ь') {
                say.add(word);
                say.add(words.get(i));
                ch = (strWords[strWords.length - 2]);
                return words.get(i);
            }
        }
        return null;
    }

    private String getString(String word, int i, char[] strWords) {
        say.add(word);
        say.add(words.get(i));
        ch = (strWords[strWords.length - 1]);
        return words.get(i);
    }

    public Сities() {
        try {
            readWords();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void clear() {
        System.out.println("Clear");
        say.clear();
    }

    private void readWords() throws FileNotFoundException {
        try (Scanner string_new = new Scanner(new FileReader("game\\words\\words.txt"))) {
            while (string_new.hasNextLine()) {
                words.add(string_new.nextLine());
            }
        }
    }

}
