package com.example.fadirizktest;

import java.util.*;

public class LanguageUtils {
    public static List<LanguageData> data = new ArrayList<LanguageData>();

    public static void main(String[] args) {
        data.add(new LanguageData("US", Arrays.asList("en")));
        data.add(new LanguageData("BE", Arrays.asList("nl", "fr", "de")));
        data.add(new LanguageData("NL", Arrays.asList("nl", "fy")));
        data.add(new LanguageData("DE", Arrays.asList("de")));
        data.add(new LanguageData("ES", Arrays.asList("es")));

        try {
            run();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        int numCountries = getNumCountries();
        System.out.println("Number of countries: " + numCountries);

        String countryWithMostLanguages = getCountryWithMostLanguages();
        System.out.println("Country with most languages: " + countryWithMostLanguages);

        int totalLanguages = getTotalLanguages();
        System.out.println("Total number of languages: " + totalLanguages);

        String countryWithHighestNumLanguages = getCountryWithHighestNumLanguages();
        System.out.println("Country with highest number of languages: " + countryWithHighestNumLanguages);

        List<String> commonLanguages = getCommonLanguages();
        System.out.println("Most common languages: " + commonLanguages);
    }

    private static void run() throws IllegalArgumentException {
        validateData();
        int numCountries = getNumCountries();
        System.out.println("Number of countries: " + numCountries);

        String countryWithMostLanguages = getCountryWithMostLanguages();
        System.out.println("Country with most languages: " + countryWithMostLanguages);

        int totalLanguages = getTotalLanguages();
        System.out.println("Total number of languages: " + totalLanguages);

        String countryWithHighestNumLanguages = getCountryWithHighestNumLanguages();
        System.out.println("Country with highest number of languages: " + countryWithHighestNumLanguages);

        List<String> commonLanguages = getCommonLanguages();
        System.out.println("Most common languages: " + commonLanguages);
    }

    private static void validateData() throws IllegalArgumentException {
        for (LanguageData datum : data) {
            if (datum.country == null || datum.country.isEmpty()) {
                throw new IllegalArgumentException("Country name missing");
            }
            if (datum.languages == null || datum.languages.isEmpty()) {
                throw new IllegalArgumentException("Languages for country " + datum.country + " is missing");
            }
        }
    }

    public static int getNumCountries() {
        return data.size();
    }

    public static String getCountryWithMostLanguages() {
        String country = "";
        int maxLanguages = 0;

        for (LanguageData datum : data) {
            int numLanguages = 0;
            for (String language : datum.languages) {
                if (language.equals("de")) {
                    numLanguages++;
                }
            }

            if (numLanguages > maxLanguages) {
                maxLanguages = numLanguages;
                country = datum.country;
            }
        }

        return country;
    }

    public static int getTotalLanguages() {
        int total = 0;
        for (LanguageData datum : data) {
            total += datum.languages.size();
        }

        return total;
    }

    public static String getCountryWithHighestNumLanguages() {
        String country = "";
        int maxLanguages = 0;

        for (LanguageData datum : data) {
            if (datum.languages.size() > maxLanguages) {
                maxLanguages = datum.languages.size();
                country = datum.country;
            }
        }

        return country;
    }
    public static List<String> getCommonLanguages() {
        Map<String, Integer> languageCounts = new HashMap<String, Integer>();

        for (LanguageData datum : data) {
            for (String language : datum.languages) {
                int count = languageCounts.getOrDefault(language, 0);
                count++;
                languageCounts.put(language, count);
            }
        }

        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : languageCounts.entrySet()) {
            maxCount = Math.max(maxCount, entry.getValue());
        }

        List<String> commonLanguages = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : languageCounts.entrySet()) {
            if (entry.getValue() == maxCount) {
                commonLanguages.add(entry.getKey());
            }
        }

        return commonLanguages;
    }

}