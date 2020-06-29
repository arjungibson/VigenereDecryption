package com.bigsomething.Decryption.MultipleKeys;

import com.bigsomething.Decryption.MultipleKeys.OneKey.CaesarCipher;
import com.bigsomething.Decryption.MultipleKeys.OneKey.DecryptOneKey;
import com.bigsomething.Decryption.StatAnalysis.Frequencies.Language;
import com.bigsomething.Decryption.StatAnalysis.Frequencies.Space;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;


public class DecryptMultipleKeys
{

    Map<Integer, String> keysAndStringsMap = new HashMap<>();

    @Setter private String encryptedString;

    private void decryptKeysAndStringsMap(Language language)
    {

        for (int keyPosition = 0; keyPosition < keysAndStringsMap.size(); keyPosition++) {

            String encryptedSubString = keysAndStringsMap.get(keyPosition);

            DecryptOneKey decryptOneKey = new DecryptOneKey();
            decryptOneKey.runDecrypt(encryptedSubString, language);

            String decryptedSubString = CaesarCipher.createEncryption(decryptOneKey.getKey(), encryptedSubString);

            keysAndStringsMap.put(keyPosition, decryptedSubString);
        }

    }

    public String runDecrypt(int keyLength, Space space, Language language)
    {
        this.keysAndStringsMap = keysAndStringsHelper.setKeysAndStringsMap(keyLength, encryptedString, space);

        decryptKeysAndStringsMap(language);
        return DecryptionResultBuilder.buildDecryptionResult(keyLength, encryptedString, keysAndStringsMap, space);
    }

}
