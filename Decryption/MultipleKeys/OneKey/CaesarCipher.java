package com.bigsomething.Decryption.MultipleKeys.OneKey;

import com.google.common.collect.ImmutableList;


public class CaesarCipher
{

    public static String createEncryption(int key, String decryptedString)
    {
        final ImmutableList<String> shiftedAlphabet = ShiftedAlphabetHelper.shiftAlphabet(key);
        final ImmutableList<String> alphabet = ShiftedAlphabetHelper.getAlphabet();

        String decryptedStringUpperCase = decryptedString.toUpperCase();
        String[] decryptedArray = decryptedStringUpperCase.split("");
        StringBuilder encryptedBuilder = new StringBuilder();

        for (String letter : decryptedArray) {

            if (alphabet.contains(letter)) {

                int index = alphabet.indexOf(letter);
                String encryptedLetter = shiftedAlphabet.get(index);

                encryptedBuilder.append(encryptedLetter);
            } else {
                encryptedBuilder.append(letter);
            }

        }

        return encryptedBuilder.toString();
    }

}
