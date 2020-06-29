package com.bigsomething.Decryption.MultipleKeys;

import com.bigsomething.Decryption.StatAnalysis.Frequencies.Space;

import java.util.HashMap;
import java.util.Map;

public class keysAndStringsHelper {

    public static Map<Integer, String> setKeysAndStringsMap(int keyLength, String encryptedString, Space space)
    {
        Map<Integer, String> keysAndStringsMap = new HashMap<>();

        switch (space)
        {
            case SPACE -> keysAndStringsMap = getKeysAndStringsMap(keyLength, encryptedString);
            case NoSPACE -> keysAndStringsMap = getKeysAndStringsMapNoSpace(keyLength, encryptedString);
        }

        return keysAndStringsMap;
    }


    public static Map<Integer, String> getKeysAndStringsMapNoSpace(int keyLength, String encryptedString)
    {
        encryptedString = encryptedString.replaceAll(" ", "");
        encryptedString = encryptedString.replaceAll("[.,?!'\";:-]","");
        encryptedString = encryptedString.replaceAll("[^[a-zA-Z]+$]", "");
        return getKeysAndStringsMap(keyLength, encryptedString);
    }

    private static Map<Integer, String> getKeysAndStringsMap(int keyLength, String encryptedString) {
        String[] encryptedArray = encryptedString.split("");
        Map<Integer, String> keysAndStringsMap = new HashMap<>();

        for (int i = 0; i < encryptedString.length(); i++)
        {
            int splitKey = i % keyLength;

            if(keysAndStringsMap.containsKey(splitKey))
            {
                String original = keysAndStringsMap.get(splitKey);
                keysAndStringsMap.put(splitKey, original + encryptedArray[i]);
            } else {
                keysAndStringsMap.putIfAbsent(splitKey, encryptedArray[i]);
            }
        }

        return keysAndStringsMap;
    }
}
