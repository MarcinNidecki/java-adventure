package com.kodilla.pacmanv2.pacmanBoard.statistic;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Ranking implements Serializable {


    @Override
    public String toString() {
        return "RankingMenu{}";
    }

    private static HashMap<String, Integer> ranking = new HashMap<>();
    private String rankingString = "";

    public String printRankingTop10() {

        TreeMap<String, Integer> sortedMap = sortMapByValue(ranking);
        int count = 0;
        rankingString = "";
        StringBuilder rankingBuilder = new StringBuilder();


        for (Map.Entry<String, Integer> e : sortedMap.entrySet()) {
            count++;

            if (count <= 10) {
                System.out.println("-----------------------------------------------------------");
                System.out.println("|  " + count + "  |     " + e.getKey() + " points:r " +
                        e.getValue());
                System.out.println("-----------------------------------------------------------");
                rankingBuilder.append("" + count + "    " + e.getKey() + " points:  " + e.getValue() + "\n");


            }
        }
        return rankingBuilder.toString();
    }

    private static TreeMap<String, Integer> sortMapByValue(HashMap<String, Integer> map) {
        Comparator<String> comparator = new ValueComparator(map);
        //TreeMap is a map sorted by its key.
        //The comparator is used to sort the TreeMap by key.
        TreeMap<String, Integer> result = new TreeMap<>(comparator);
        result.putAll(map);
        return result;
    }

    public HashMap<String, Integer> getRanking() {
        return ranking;
    }

    public void addToRanking(String userName) {

        if (ranking.containsKey(userName)) {
            ranking.put(userName, (ranking.get(userName) + 1));
        } else {
            ranking.put(userName, 1);
        }


    }

    public void saveRanking() {
        //write to file : "fileone"

        try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream((Objects.requireNonNull(getClass().getClassLoader().getResource("assets/text/ranking.txt"))).getFile()))) {

            o.writeObject(ranking);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }


    }

    public void readRanking() {


        //read from file
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(((Objects.requireNonNull(getClass().getClassLoader().getResource("assets/text/ranking.txt"))).getFile())))) {
            Object readObject = oi.readObject();
            if (!(readObject instanceof HashMap)) {
                throw new IOException("Data is not a hashmap");


            } else ranking = (HashMap) readObject;


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing ranking - NEW RANKIGN IS CRETED");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
