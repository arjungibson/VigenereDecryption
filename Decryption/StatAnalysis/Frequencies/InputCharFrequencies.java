package com.bigsomething.Decryption.StatAnalysis.Frequencies;


import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class InputCharFrequencies {

    private char[] inputStringArray;

    private Map<Character, Integer> inputCharFrequencies = new HashMap<>();

    public void createInputCharFrequencies()
    {
        for (char letter : inputStringArray) {
            if (inputCharFrequencies.containsKey(letter)) {
                inputCharFrequencies.computeIfPresent(letter, (key, val) -> val + 1);
            } else {
                inputCharFrequencies.put(letter, 1);
            }
        }
    }
}
