package com.bigsomething.Decryption.MultipleKeys.OneKey;

import com.bigsomething.Decryption.StatAnalysis.ChiSquare;
import com.bigsomething.Decryption.StatAnalysis.Frequencies.Language;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Range;
import lombok.Getter;

import java.util.Collections;

//Class retrieves the value of one key based on the string inputted

public class DecryptOneKey
{

    private final Range<Integer> keyRange = Range.closed(0, 26);
    private final BiMap<Integer, Double> chiSquaredMap = HashBiMap.create();

    @Getter private int key;
    @Getter private double min;

    private void setChiSquaredMap(String encryptedInput, Language language)
    {
        //fake sum is there to prevent zeros from entering the map
        double fakeSum = 500000.0;

        for (int key = 0; key < keyRange.upperEndpoint(); key++)
        {
            String decrypted = CaesarCipher.createEncryption(key, encryptedInput);

            double sum = ChiSquare.getChiSquareSum(decrypted, language);

            if(sum != 0 && sum < 500000)
            {
                chiSquaredMap.put(key, sum);
            } else {
                chiSquaredMap.put(key, fakeSum);
                fakeSum += 2;
            }

        }
    }


    private void setKey()
    {
        this.min = Collections.min(chiSquaredMap.values());
        this.key = chiSquaredMap.inverse().get(min);
    }

    public void runDecrypt(String encryptedInput, Language language)
    {
        setChiSquaredMap(encryptedInput, language);
        setKey();
    }



}
