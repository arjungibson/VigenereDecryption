# VigenereDecryption
Creates a decryption of a Vigenere cipher using statistical methods. 

A vigenere cipher is way of encoding and decoding using polyalphabetic substitution.  The wikipedia page for it explains 
the base concept fairly well: https://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher.

## Theory

### Caesar Cipher

A typical single substitution cipher (Caesar Cipher) can be easily broken using a statistical analysis of the alphabet. The idea is to test each shift
of the key; the key whose decryption has alphabet frequencies which closely match that of English (or desired language), that key is the answer.
This simple analysis is done using the chi-squared formula.

#### Chi Sqaured Formula

![Chi Square Formula](http://practicalcryptography.com/media/latex/a84276327c1973a55df72cf4432ba17ca75231ac-11pt.png)

The "C" stands for the actual count of a certain letter in the encrypted string.  The "E" stands for the expected frequency of the letter.  For instance, if there are
100 characters in the encrypted string and the theoretical frequency (0-1) of the letter is .167, then "E" would be 16.7. **In essense, 
the chi square formula is checking the amount of error in letter frequency (real - theoretical) as a pecentage of the theoretical frequency. The shift that produces 
the lowest sum is the correct key value.**  Read more about it here: [Chi Sqaured Explanation](http://practicalcryptography.com/cryptanalysis/text-characterisation/chi-squared-statistic/)

### Breaking the Vigenere Cipher

The Vigenere cipher is harder to crack than the Caesar cipher.  The longer key ensures a more flat distribution of letters which makes it impervious to an pure chi-squred attack.  The graph below demonstrates this concept with the right graph (Vigenere Cipher) having a flatter distribution then the left graph (Normal English Alphabet).

![Vigenere Frequency Graph](https://sites.google.com/site/kidicrypt/vigenere-cipher/Vigf1.png?attredirects=0)

In order to break the Vigenere cipher, the cipher must be broken into smaller substrings.  These substrings have a normal distribution which can then be attacked with the 
Chi-squared formula. The number of substrings is determined by the key length.  For example, a key length of 5 is broken into 5 substrings.  I used a combination of two methods to find the key length.

#### Index of Coincidence

The index of coincidence 



![Twist of C](https://i.imgur.com/dZszhLF.jpg)
