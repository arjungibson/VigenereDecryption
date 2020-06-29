package com.bigsomething.Decryption.StatAnalysis.Frequencies;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class AlphabetFrequencies {

    private final Map<Character, Double> englishAlphabetFrequencies = new HashMap<>()
    {{
        put('E', .1202);
        put('T', .0910);
        put('A', .0812);
        put('O', .0768);
        put('I', .0731);
        put('N', .0695);
        put('S', .0638);
        put('R', .0602);
        put('H', .0592);
        put('D', .0432);
        put('L', .0398);
        put('U', .0288);
        put('C', .0271);
        put('M', .0261);
        put('F', .0230);
        put('Y', .0211);
        put('W', .0209);
        put('G', .0203);
        put('P', .0182);
        put('B', .0149);
        put('V', .0111);
        put('K', .0069);
        put('X', .0017);
        put('Q', .0011);
        put('J', .0010);
        put('Z', .0007);
    }};

    private final Map<Character, Double> portugueseAlphabetFrequencies = new HashMap<>()
    {{
        put('E', .1319);
        put('A', .1221);
        put('O', .1022);
        put('S', .0735);
        put('R', .0673);
        put('I', .0549);
        put('M', .0507);
        put('T', .0507);
        put('N', .0502);
        put('U', .0446);
        put('D', .0421);
        put('C', .0225);
        put('P', .0301);
        put('L', .0300);
        put('V', .0172);
        put('H', .0122);
        put('Q', .0110);
        put('G', .0108);
        put('F', .0107);
        put('B', .0101);
        put('Z', .0045);
        put('J', .0030);
        put('X', .0028);
        put('K', .0069);
        put('W', .0005);
        put('Y', .0004);
    }};

    private final Map<Character, Double> dutchAlphabetFrequencies = new HashMap<>()
    {{
        put('A', .0776);
        put('B', .0138);
        put('C', .0131);
        put('D', .0548);
        put('E', .1931);
        put('F', .0074);
        put('G', .0317);
        put('H', .0316);
        put('I', .0503);
        put('J', .0051);
        put('K', .0283);
        put('L', .0385);
        put('M', .0260);
        put('N', .1004);
        put('O', .0588);
        put('P', .0151);
        put('Q', .0001);
        put('R', .0570);
        put('S', .0391);
        put('T', .0650);
        put('U', .0213);
        put('V', .0227);
        put('W', .0174);
        put('X', .0005);
        put('Y', .0006);
        put('Z', .0162);
    }};

    private final Map<Character, Double> danishAlphabetFrequencies = new HashMap<>()
    {{
        put('A', .0613);
        put('B', .0142);
        put('C', .0045);
        put('D', .0665);
        put('E', .1609);
        put('F', .0220);
        put('G', .0488);
        put('H', .0240);
        put('I', .0573);
        put('J', .0094);
        put('K', .0326);
        put('L', .0490);
        put('M', .0329);
        put('N', .0732);
        put('O', .0434);
        put('P', .0131);
        put('Q', .0001);
        put('R', .0763);
        put('S', .0518);
        put('T', .0719);
        put('U', .0188);
        put('V', .0290);
        put('W', .0008);
        put('X', .0005);
        put('Y', .0051);
        put('Z', .0004);
    }};

    private final Map<Character, Double> spanishAlphabetFrequencies = new HashMap<>()
    {{
        put('A', .1172);
        put('B', .0149);
        put('C', .0387);
        put('D', .0467);
        put('E', .1372);
        put('F', .0069);
        put('G', .0100);
        put('H', .0118);
        put('I', .0528);
        put('J', .0052);
        put('K', .0011);
        put('L', .0524);
        put('M', .0308);
        put('N', .0683);
        put('O', .0844);
        put('P', .0289);
        put('Q', .0111);
        put('R', .0641);
        put('S', .0720);
        put('T', .0460);
        put('U', .0455);
        put('V', .0105);
        put('W', .0004);
        put('X', .0014);
        put('Y', .0109);
        put('Z', .0047);
    }};

    private final Map<Character, Double> germanAlphabetFrequencies = new HashMap<>()
    {{
        put('A', .0558);
        put('B', .0196);
        put('C', .0316);
        put('D', .0498);
        put('E', .1693);
        put('F', .0149);
        put('G', .0302);
        put('H', .0498);
        put('I', .0802);
        put('J', .0024);
        put('K', .0132);
        put('L', .0360);
        put('M', .0255);
        put('N', .1053);
        put('O', .0224);
        put('P', .0067);
        put('Q', .0002);
        put('R', .0689);
        put('S', .0642);
        put('T', .0579);
        put('U', .0383);
        put('V', .0084);
        put('W', .0178);
        put('X', .0005);
        put('Y', .0005);
        put('Z', .0121);
    }};

    private final Map<Character, Double> frenchAlphabetFrequencies = new HashMap<>()
    {{
        put('A', .0760);
        put('B', .0096);
        put('C', .0339);
        put('D', .0408);
        put('E', .1447);
        put('F', .0112);
        put('G', .0118);
        put('H', .0093);
        put('I', .0721);
        put('J', .0030);
        put('K', .0016);
        put('L', .0586);
        put('M', .0278);
        put('N', .0732);
        put('O', .0539);
        put('P', .0298);
        put('Q', .0085);
        put('R', .0686);
        put('S', .0798);
        put('T', .0711);
        put('U', .0555);
        put('V', .0129);
        put('W', .0008);
        put('X', .0043);
        put('Y', .0019);
        put('Z', .0021);
    }};

    private final Map<Character, Double> italianAlphabetFrequencies = new HashMap<>()
    {{
        put('A', .1085);
        put('B', .0105);
        put('C', .0430);
        put('D', .0339);
        put('E', .1149);
        put('F', .0101);
        put('G', .0165);
        put('H', .0143);
        put('I', .1018);
        put('J', .0001);
        put('K', .0001);
        put('L', .0570);
        put('M', .0287);
        put('N', .0702);
        put('O', .0997);
        put('P', .0296);
        put('Q', .0045);
        put('R', .0619);
        put('S', .0548);
        put('T', .0697);
        put('U', .0316);
        put('V', .0175);
        put('W', .0001);
        put('X', .0001);
        put('Y', .0001);
        put('Z', .0085);
    }};


}
