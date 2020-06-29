package com.bigsomething;

import com.bigsomething.Decryption.DecryptUnknownLanguage;


public class Main {

    public static void main(String[] args)
    {


        String encryptedInput = "Rj ridrj v fj sriÃµvj rjjzercrufj\n" +
                "Hlv, ur ftzuvekrc girzr cljzkrer,\n" +
                "Gfi drivj eletr uv rekvj ermvxrufj\n" +
                "Grjjrird rzeur rcÃ©d ur Krgifsrer,\n" +
                "Vd gvizxfj v xlviirj vjwfiÃ§rufj,\n" +
                "Drzj uf hlv gifdvkzr r wfiÃ§r yldrer,\n" +
                "V vekiv xvekv ivdfkr vuzwztrird\n" +
                "Efmf ivzef, hlv krekf jlsczdrird.\n" +
                ".....\n" +
                "Trekreuf vjgrcyrivz gfi kfur r grikv,\n" +
                "Jv r krekf dv raluri f vexveyf v rikv";


        DecryptUnknownLanguage.decryptUnknownLanguage(encryptedInput);


    }
}
