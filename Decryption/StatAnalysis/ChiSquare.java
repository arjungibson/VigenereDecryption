package com.bigsomething.Decryption.StatAnalysis;

import com.bigsomething.Decryption.StatAnalysis.Frequencies.AlphabetFrequencies;
import com.bigsomething.Decryption.StatAnalysis.Frequencies.InputCharFrequencies;
import com.bigsomething.Decryption.StatAnalysis.Frequencies.Language;

import java.util.Map;


public class ChiSquare
{
    private static Map<Character, Integer> inputCharFrequenciesMap;
    private static Map<Character, Double> alphabetFrequenciesMap;


    public static double getChiSquareSum(String input, Language language)
    {
        setInputCharFrequenciesMap(input);
        setAlphabetFrequenciesMap(language);
        int sumChars = getSumOfChars();
        double chiSquareSum = 0;

        for (Character letter: alphabetFrequenciesMap.keySet())
        {

            if(inputCharFrequenciesMap.containsKey(letter))
            {
                double realValue = inputCharFrequenciesMap.get(letter);
                double frequenciesValue = alphabetFrequenciesMap.get(letter);

                double frequency = sumChars*frequenciesValue;

                double chiSquared = Math.pow(realValue-frequency, 2)/frequency;

                chiSquareSum += chiSquared;
            }

        }

        return chiSquareSum;
    }

    private static void setAlphabetFrequenciesMap(Language language)
    {
        AlphabetFrequencies alphabetFrequencies = new AlphabetFrequencies();

        switch (language)
        {
            case ENGLISH -> alphabetFrequenciesMap = alphabetFrequencies.getEnglishAlphabetFrequencies();
            case PORTUGUESE -> alphabetFrequenciesMap = alphabetFrequencies.getPortugueseAlphabetFrequencies();
            case DUTCH -> alphabetFrequenciesMap = alphabetFrequencies.getDutchAlphabetFrequencies();
            case DANISH -> alphabetFrequenciesMap = alphabetFrequencies.getDanishAlphabetFrequencies();
            case SPANISH -> alphabetFrequenciesMap = alphabetFrequencies.getSpanishAlphabetFrequencies();
            case GERMAN -> alphabetFrequenciesMap = alphabetFrequencies.getGermanAlphabetFrequencies();
            case FRENCH -> alphabetFrequenciesMap = alphabetFrequencies.getFrenchAlphabetFrequencies();
            case ITALIAN -> alphabetFrequenciesMap = alphabetFrequencies.getItalianAlphabetFrequencies();
        }
    }

    private static int getSumOfChars()
    {
        int sum = 0;

        for (char letter: alphabetFrequenciesMap.keySet())
        {
            if (inputCharFrequenciesMap.containsKey(letter)) {
                sum += inputCharFrequenciesMap.get(letter);
            }

        }

        return sum;
    }

    private static void setInputCharFrequenciesMap(String string)
    {
        InputCharFrequencies inputCharFrequenciesClass = new InputCharFrequencies();
        inputCharFrequenciesClass.setInputStringArray(string.toUpperCase().toCharArray());
        inputCharFrequenciesClass.createInputCharFrequencies();

        inputCharFrequenciesMap = inputCharFrequenciesClass.getInputCharFrequencies();
    }


}
