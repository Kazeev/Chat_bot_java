package ru.croc.jws.messenger.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

/* НЕ РОБИТ
*
*
*
*
*/

public class Weather {

    public ArrayList<String> temp() {
        String query = "https://yandex.ru/pogoda/moscow?from=serp_title";
        //private Map<String,Integer> temperature = new HashMap();
        ArrayList<String> temperature = new ArrayList();

        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL(query).openConnection();

            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setConnectTimeout(250);
            connection.setReadTimeout(250);
            connection.connect();

            StringBuilder stringBuilder = new StringBuilder();

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = in.readLine()) != null) {
                    stringBuilder.append(line + "\n");
                }
                System.out.println(stringBuilder.toString());
                String strings = String.valueOf(stringBuilder);
                String[] temp = strings.split("<span class=\"temp__value\">");
                for (int i = 1; i < temp.length; i++) {
                    temp[i] = temp[i].substring(0, 4);
                    char[] s =  temp[i].toCharArray();
                    String ret = "";
                    for (int j = 0; j < s.length; j++) {
                        if(s[j] == '<') break;
                            ret += s[j];
                    }
                    temperature.add(ret);
                }
                return temperature;
            } else System.out.println("Error");

        } catch (Throwable cause) {
            cause.printStackTrace();
        } finally {
            if (connection == null) connection.disconnect();
        }
        return null;

    }

}


