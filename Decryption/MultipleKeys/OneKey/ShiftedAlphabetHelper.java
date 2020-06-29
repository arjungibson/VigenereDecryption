package com.bigsomething.Decryption.MultipleKeys.OneKey;

import com.google.common.collect.ImmutableList;

public class ShiftedAlphabetHelper
{

    private static final ImmutableList<String> alphabet = new ImmutableList.Builder<String>()
            .add("A","B","C","D","E","F","G","H","I","J","K","L","M","N",
                    "O","P","Q","R","S","T","U","V","W","X","Y","Z")
            .build();

    public static ImmutableList<String> getAlphabet()
    {
        return alphabet;
    }

    public static ImmutableList<String> shiftAlphabet(int key)
    {

        return new ImmutableList.Builder<String>()
                .addAll(alphabet.subList(key,alphabet.size()))
                .addAll(alphabet.subList(0,key))
                .build();
    }

}
