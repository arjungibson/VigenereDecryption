package com.bigsomething.Decryption.StatAnalysis;

import com.bigsomething.Decryption.MultipleKeys.keysAndStringsHelper;
import com.bigsomething.Decryption.StatAnalysis.Frequencies.InputCharFrequencies;
import com.bigsomething.Decryption.StatAnalysis.Frequencies.Space;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Range;
import lombok.Setter;

import java.util.*;

public class TwistPlus {

    @Setter
    static Range<Integer> keyLengthRange;

    public static int findTwistKey(String input, Range<Integer> keyRange, Space space){

        setKeyLengthRange(keyRange);
        Map<Integer, Double> twistKeyMap = new HashMap<>();
        BiMap<Integer, Double> twistPlusKeyMap = HashBiMap.create();

        for (int keyLength = keyRange.lowerEndpoint(); keyLength < keyRange.upperEndpoint(); keyLength++) {

            Map<Integer, String> keysAndStringsMap = keysAndStringsHelper.setKeysAndStringsMap(keyLength, input, space);

            double twistKeyAnswer = getTwistKeyAnswer(keyLength, keysAndStringsMap);
            getTwistPlusMap(twistKeyMap, twistPlusKeyMap, keyLength, twistKeyAnswer);

            twistKeyMap.put(keyLength, twistKeyAnswer);
        }


        double max = Collections.max(twistPlusKeyMap.values());

        return twistPlusKeyMap.inverse().get(max);
    }

    private static void getTwistPlusMap(Map<Integer, Double> twistKeyMap, Map<Integer, Double> twistPlusKeyMap, int keyLength, double twistKeyAnswer) {
        double sum = 0.0;
        for (int length: twistKeyMap.keySet())
        {
            if(keyLength == keyLengthRange.lowerEndpoint()){
                break;
            } else {
                sum += twistKeyMap.get(length);
            }

        }

        double avg = sum/twistKeyMap.size();
        double twistPlus = Math.abs(twistKeyAnswer - avg);

        if(keyLength != keyLengthRange.lowerEndpoint()){
            twistPlusKeyMap.put(keyLength, twistPlus);
        }

    }

    private static double getTwistKeyAnswer(int keyLength, Map<Integer, String> keysAndStringsMap) {
        double diamondCSum = 0.0;
        for (Integer key : keysAndStringsMap.keySet()) {
            diamondCSum += getDiamondC(keysAndStringsMap.get(key));
        }

        return (100.0/keyLength) * diamondCSum;
    }

    private static double getDiamondC(String input) {
        String noSpaces = cleanString(input);
        char[] inputArray = noSpaces.toCharArray();

        InputCharFrequencies inputCharFrequencies = getInputCharFrequencies(inputArray);
        Map<Character, Integer> characterIntegerMap = inputCharFrequencies.getInputCharFrequencies();

        ArrayList<Integer> orderedCounter = getOrderedCounter(characterIntegerMap);
        ArrayList<Double> orderedFrequencies = getOrderedFrequency(orderedCounter);

        return calculateDiamondC(orderedFrequencies);
    }

    private static String cleanString(String inputString) {
        inputString = inputString.toUpperCase();
        String noSpaces = inputString.replaceAll(" ", "");
        noSpaces = noSpaces.replaceAll("[.,?!'\";:-]","");
        noSpaces = noSpaces.replaceAll("[^[a-zA-Z]+$]", "");
        return noSpaces;
    }

    private static InputCharFrequencies getInputCharFrequencies(char[] inputArray) {
        InputCharFrequencies inputCharFrequencies = new InputCharFrequencies();
        inputCharFrequencies.setInputStringArray(inputArray);
        inputCharFrequencies.createInputCharFrequencies();
        return inputCharFrequencies;
    }

    private static ArrayList<Integer> getOrderedCounter(Map<Character, Integer> characterIntegerMap)
    {
        ArrayList<Integer> orderedFrequencies = new ArrayList<>();

        for (char letter: characterIntegerMap.keySet()) {
            int frequency = characterIntegerMap.get(letter);
            orderedFrequencies.add(frequency);
        }

        Collections.sort(orderedFrequencies);

        return orderedFrequencies;
    }

    private static ArrayList<Double> getOrderedFrequency(ArrayList<Integer> orderedCounter)
    {
        double sum = orderedCounter.stream()
                .mapToDouble(a -> a)
                .sum();

        ArrayList<Double> orderedFrequency = new ArrayList<>();

        for (double count: orderedCounter) {

            double frequency = count/sum;
            orderedFrequency.add(frequency);

        }

        Collections.sort(orderedFrequency);

        return orderedFrequency;
    }

    private static double calculateDiamondC(ArrayList<Double> orderedFrequencies)
    {
        double smallSum = 0.0;
        double largeSum = 0.0;

        for (int i = 0; i < (orderedFrequencies.size()/2); i++)
        {
            smallSum += orderedFrequencies.get(i);
        }

        for (int i = (orderedFrequencies.size()/2); i < orderedFrequencies.size(); i++) {
            largeSum += orderedFrequencies.get(i);
        }

        return largeSum - smallSum;
    }
}
