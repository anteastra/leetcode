package org.leetcode.problem1615;

import java.util.*;

public class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, Set<Integer>> roadsTo = new HashMap<>();
        TreeMap<Integer, Set<Integer>> mapOfSize = new TreeMap<>();

        for(int i = 0; i < roads.length; i++) {
            int valueA = roads[i][0];
            int valueB = roads[i][1];
            if (!roadsTo.containsKey(valueA)) {
                roadsTo.put(valueA, new HashSet<>());
            }
            if (!roadsTo.containsKey(valueB)) {
                roadsTo.put(valueB, new HashSet<>());
            }
            Set<Integer> cityA = roadsTo.get(valueA);
            Set<Integer> cityB = roadsTo.get(valueB);
            cityA.add(valueB);
            cityB.add(valueA);

            if (!mapOfSize.containsKey(cityA.size())) {
                mapOfSize.put(cityA.size(), new HashSet<>());
            }
            if (!mapOfSize.containsKey(cityB.size())) {
                mapOfSize.put(cityB.size(), new HashSet<>());
            }
            mapOfSize.get(cityA.size()).add(valueA);
            mapOfSize.get(cityB.size()).add(valueB);
        }


        System.out.println(roadsTo);
        System.out.println(mapOfSize);

        Iterator<Integer> iterator = mapOfSize.descendingKeySet().iterator();

        int bestCity = -1;
        while (iterator.hasNext()) {
            int roadNumberCheck = iterator.next();
            Set<Integer> cities = mapOfSize.get(roadNumberCheck);
            if (bestCity == -1 && cities.size() > 1) {
                List<Integer> citiesList = new ArrayList<>(cities);
                int roadAmount;
                for (int i=0; i < citiesList.size() -1 ; i++) {
                    for (int j=i+1; j<citiesList.size(); j++) {
                        int cityA = citiesList.get(i);
                        int cityB = citiesList.get(j);
                        Set<Integer> roadsToA = roadsTo.get(cityA);
                        if (!roadsToA.contains(cityB)) {
                            return roadsToA.size() * 2;
                        }
                    }
                }
                return roadNumberCheck*2 -1 ;
            }
            if (bestCity == -1 && cities.size() == 1) {
                bestCity = cities.iterator().next();

                while(true) {
                    roadNumberCheck = iterator.next();

                    Set<Integer> smallerCities = mapOfSize.get(roadNumberCheck);
                    if (smallerCities.size() > 1) {
                        break;
                    }
                }

                Set<Integer> smallerCities = mapOfSize.get(roadNumberCheck);
                int smallerSize = roadNumberCheck;

                List<Integer> citiesList = new ArrayList<>(smallerCities);
                for (int i = 0; i < citiesList.size(); i++) {
                    if (citiesList.get(i) != bestCity && !roadsTo.get(citiesList.get(i)).contains(bestCity)) {
                        return roadsTo.get(bestCity).size() + smallerSize;
                    }
                }
                return roadsTo.get(bestCity).size() + smallerSize -1 ;
            }
        }

//        mapOfSize.keySet().stream().sorted(Comparator.reverseOrder())
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 28;
        int[][] roads = {{13,5},{22,17},{22,4},{26,8},{27,13},{27,9},{20,19},{19,5},{15,1},{10,24},{19,22},{19,13},{4,10},{13,3},{6,9},{9,16},{9,12},{15,8},{26,12},{16,5},{14,15},{2,10},{4,18},{13,21},{22,9},{10,22},{25,27},{21,1},{6,20},{17,0},{6,11},{0,26},{11,5},{21,23},{3,10},{19,17},{18,21},{14,18},{8,23},{1,25},{0,16},{18,9},{1,3},{20,8},{13,2},{7,0},{16,21},{18,27},{8,21},{2,11},{0,3},{24,12},{5,0},{1,4},{26,16},{23,14},{0,19},{7,24},{5,27},{23,0},{6,2},{3,26},{5,23},{25,24},{23,3},{9,3},{22,21},{14,3},{3,15},{25,6},{6,10},{12,3},{2,19},{26,18},{20,22},{9,26},{17,5},{8,3},{1,14},{21,2},{7,1},{27,3},{11,0},{27,23},{14,10},{27,26},{24,20},{25,16},{17,6},{14,17},{21,10},{2,22},{9,2},{1,6},{22,14},{21,25},{7,25},{11,25},{15,23},{11,24},{3,17},{20,10},{27,17},{23,2},{21,20},{3,2},{12,27},{22,12},{1,22},{7,17},{4,24},{27,24},{12,11},{10,7},{5,24},{5,4},{8,14},{15,11},{6,7},{2,8},{20,1},{9,24},{20,0},{22,24},{17,24},{9,20},{10,9},{3,7},{14,4},{18,0},{27,7},{22,16},{16,15},{20,16},{16,8},{13,10},{20,12},{14,25},{19,24},{20,5},{3,19},{27,16},{26,13},{13,17},{17,21},{8,19},{1,2},{23,13},{7,12},{4,15},{5,1},{23,9},{23,12},{18,25},{21,3},{10,19},{18,3},{5,26},{15,18},{7,15},{4,13},{22,27},{10,17},{14,6},{25,15},{4,0},{26,23},{18,19},{13,12},{26,4}};
        int result = solution.maximalNetworkRank(n, roads);
        System.out.println(result);
    }
}
