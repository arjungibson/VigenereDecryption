package com.bigsomething.Decryption.StatAnalysis;

import com.bigsomething.Decryption.StatAnalysis.Frequencies.InputCharFrequencies;

import java.util.Map;

public class IndexOfCoincidence
{
    public static double setIndexOfCoincidence(String inputString)
    {
        String noSpaces = cleanString(inputString);
        char[] inputArray = noSpaces.toCharArray();

        InputCharFrequencies inputCharFrequencies = getInputCharFrequencies(inputArray);
        Map<Character, Integer> characterIntegerMap = inputCharFrequencies.getInputCharFrequencies();

        double frequencySum = getFrequencySum(characterIntegerMap);

        double denominator = noSpaces.length() * (noSpaces.length() - 1);

        return frequencySum/denominator;

    }

    private static String cleanString(String inputString) {
        inputString = inputString.toUpperCase();
        String noSpaces = inputString.replaceAll(" ", "");
        noSpaces = noSpaces.replaceAll("[.,?!'\";:-]","");
        noSpaces = noSpaces.replaceAll("[^[a-zA-Z]+$]", "");
        return noSpaces;
    }

    private static double getFrequencySum(Map<Character, Integer> characterIntegerMap) {
        double frequencySum = 0;
        for (char letter: characterIntegerMap.keySet())
        {
            double letterCount = characterIntegerMap.get(letter);
            frequencySum += letterCount * (letterCount-1);
        }
        return frequencySum;
    }

    private static InputCharFrequencies getInputCharFrequencies(char[] inputArray) {
        InputCharFrequencies inputCharFrequencies = new InputCharFrequencies();
        inputCharFrequencies.setInputStringArray(inputArray);
        inputCharFrequencies.createInputCharFrequencies();
        return inputCharFrequencies;
    }

    public static double getFriedmanMethod(String input)
    {
        double IoC = setIndexOfCoincidence(input);

        String cleanInput = cleanString(input);
        double textLength = cleanInput.length();

        double expectedCoincidence = .067;
        double inverseAlphabetSize = 1.0/26.0;

        double numerator = (expectedCoincidence - (inverseAlphabetSize)) * textLength;
        double denominator = ((textLength - 1) * IoC) - (textLength * inverseAlphabetSize) + expectedCoincidence;

        return numerator/denominator;
    }
}
