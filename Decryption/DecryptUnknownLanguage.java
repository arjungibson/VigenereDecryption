package com.bigsomething.Decryption;

import com.bigsomething.Decryption.StatAnalysis.ChiSquare;
import com.bigsomething.Decryption.StatAnalysis.Frequencies.Language;
import lombok.Setter;

public class DecryptUnknownLanguage
{
    @Setter private static Language language;

    public static void decryptUnknownLanguage(String encryptedInput)
    {
        findLanguage(encryptedInput);

        System.out.println(language);
        System.out.println("\n" + DecryptUnknownKeyLength.decryptForAllKeys(encryptedInput, language));
    }

    private static void findLanguage(String encryptedInput) {
        double chiSquareMin = 1000;
        for (Language language: Language.values())
        {
            String decryptedString = DecryptUnknownKeyLength.decryptForAllKeys(encryptedInput, language);
            double chiSquareSum = ChiSquare.getChiSquareSum(decryptedString, language);

            if(chiSquareSum < chiSquareMin)
            {
                chiSquareMin = chiSquareSum;
                setLanguage(language);
            }
        }
    }

}
