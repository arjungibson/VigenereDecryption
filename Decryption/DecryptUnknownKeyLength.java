package com.bigsomething.Decryption;

import com.bigsomething.Decryption.MultipleKeys.DecryptMultipleKeys;
import com.bigsomething.Decryption.StatAnalysis.ChiSquare;
import com.bigsomething.Decryption.StatAnalysis.Frequencies.Language;
import com.bigsomething.Decryption.StatAnalysis.Frequencies.Space;
import com.bigsomething.Decryption.StatAnalysis.IndexOfCoincidence;
import com.bigsomething.Decryption.StatAnalysis.TwistPlus;
import com.google.common.collect.Range;
import lombok.Setter;

public class DecryptUnknownKeyLength {

    private static Range<Integer> keyLengthRange;
    @Setter private static String encryptedString;
    private static int keyLength;
    private static Space space;
    @Setter private static Language language;

    public static String decryptForAllKeys(String encryptedString, Language language)
    {
        double IoC = IndexOfCoincidence.getFriedmanMethod(encryptedString);

        setLanguage(language);
        setEncryptedString(encryptedString);
        setKeyLengthRange(IoC);
        setKeyLength();

        return getDecryptedString(encryptedString, keyLength, space);

    }

    private static String getDecryptedString(String encryptedString, int keyLength, Space space) {
        DecryptMultipleKeys decryptMultipleKeys = new DecryptMultipleKeys();
        decryptMultipleKeys.setEncryptedString(encryptedString);
        return decryptMultipleKeys.runDecrypt(keyLength, space, language);
    }


    private static void setKeyLength()
    {
        int keyLengthSpace = TwistPlus.findTwistKey(encryptedString, keyLengthRange, Space.SPACE);
        int keyLengthNoSpace = TwistPlus.findTwistKey(encryptedString, keyLengthRange, Space.NoSPACE);

        String stringSpace = getDecryptedString(encryptedString, keyLengthSpace, Space.SPACE);
        String stringNoSpace = getDecryptedString(encryptedString, keyLengthNoSpace, Space.NoSPACE);

        double chiSquareNoSpace = ChiSquare.getChiSquareSum(stringNoSpace, language);
        double chiSquareSpace = ChiSquare.getChiSquareSum(stringSpace, language);

        if(chiSquareNoSpace < chiSquareSpace)
        {
            keyLength = keyLengthNoSpace;
            space = Space.NoSPACE;
        } else
        {
            keyLength = keyLengthSpace;
            space = Space.SPACE;
        }
    }

    private static void setKeyLengthRange(double IoC)
    {
        int lowerEndpoint = 0;
        int upperEndpoint = 0;

        int IoCInt = (int) Math.round(IoC);

        if(IoC < 1)
        {
            lowerEndpoint = 1;
            upperEndpoint = 6;
        }
        else if( IoC < 10.0)
        {
            lowerEndpoint = 1;
            upperEndpoint = 12;
        } else if (IoC >= 10  && IoC <20)
        {
            lowerEndpoint = IoCInt - 10;
            upperEndpoint = IoCInt + 10;
        } else if (IoC >= 20 && IoC < 30)
        {
            lowerEndpoint = IoCInt - 15;
            upperEndpoint = IoCInt + 15;
        } else if (IoC >= 30)
        {
            lowerEndpoint = IoCInt - 20;
            upperEndpoint = IoCInt + 20;
        }

        keyLengthRange = Range.closed(lowerEndpoint,upperEndpoint);

    }



}
