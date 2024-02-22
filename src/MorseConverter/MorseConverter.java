package MorseConverter;

import java.util.Scanner;



public class MorseConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Converter converter = new Converter();

        System.out.println("Skriv in text du vill göra till morse");
        //Läser inte användarens input
        String text = scan.nextLine();

        //Gör en ny String för att omvandla inmatad data
        String morseCode = Converter.convertToMorse(text);
        //Skriver ut den inmatade texten och vad den blir i morsekod
        System.out.println(text + " blir i morse " +morseCode);

        System.out.println("Skriv in morse du vill göra till text");
        morseCode = scan.nextLine();

        //Gör en ny String för att omvandla inmatad data
        String convertText = Converter.convertToText(morseCode);
        //Skriver ut den inmatade morsekoden och vad den blir i text
        System.out.println(morseCode + " blir i text " + convertText);







    }
}
