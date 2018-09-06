package de.valor.ranner.main;

import de.valor.ranner.config.ConfigRetriever;
import de.valor.ranner.config.ConfigRetrieverException;

public class Main {

    public static void main(String[] args) {

        try {
            ConfigRetriever cv = new ConfigRetriever("ravendb.properties");
            System.out.println(cv.getProperty("ip"));
        } catch (ConfigRetrieverException e) {
            e.printStackTrace();
        }

    }
}
