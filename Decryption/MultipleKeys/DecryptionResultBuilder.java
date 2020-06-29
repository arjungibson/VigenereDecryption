package com.bigsomething.Decryption.MultipleKeys;

import com.bigsomething.Decryption.MultipleKeys.OneKey.ShiftedAlphabetHelper;
import com.bigsomething.Decryption.StatAnalysis.Frequencies.Space;
import lombok.Setter;

import java.util.Map;

public class DecryptionResultBuilder
{
    

    @Setter private static int keyLength;
    @Setter private static String encryptedString;
    @Setter private static Map<Integer, String> keysAndStringsMap;
    
    public static String buildDecryptionResult(int keyLength, String encryptedString, Map<Integer, String> keysAndStringsMap, Space space)
    {
        setEncryptedString(encryptedString);
        setKeyLength(keyLength);
        setKeysAndStringsMap(keysAndStringsMap);

        String decryptedString;
        switch (space)
        {
            case SPACE -> decryptedString = buildDecryptionResultSpace();
            case NoSPACE -> decryptedString = buildDecryptionResultNoSpace();
            default -> throw new IllegalStateException("Unexpected value: " + space);
        }
        
        return decryptedString;
    }

    public static String buildDecryptionResultSpace()
    {
        int arrayPosition = 0;
        StringBuilder decryptedBuilder = new StringBuilder();

        for (int index = 0; index < encryptedString.length(); index++) {

            int splitKey = index % keyLength;
            String[] subString = keysAndStringsMap.get(splitKey).split("");

            decryptedBuilder.append(subString[arrayPosition]);

            if(index > 0 && splitKey == (keyLength - 1))
            {
                arrayPosition++;
            }

        }

        return decryptedBuilder.toString();
    }

    public static String buildDecryptionResultNoSpace()
    {
        int arrayPosition = 0;
        int splitKey = 0;

        StringBuilder decryptedBuilder = new StringBuilder();

        for (int index = 0; index < encryptedString.length(); index++) {

            String[] subString = keysAndStringsMap.get(splitKey).split("");
            String[] encryptedStringArray = encryptedString.toUpperCase().split("");

            if (ShiftedAlphabetHelper.getAlphabet().contains(encryptedStringArray[index]))
            {
                if(arrayPosition < subString.length)
                {
                    decryptedBuilder.append(subString[arrayPosition]);
                }
                splitKey++;

            } else {
                decryptedBuilder.append(encryptedStringArray[index]);
            }

            if(splitKey == keyLength)
            {
                splitKey = 0;
                arrayPosition++;
            }

        }

        return decryptedBuilder.toString();
    }
}
