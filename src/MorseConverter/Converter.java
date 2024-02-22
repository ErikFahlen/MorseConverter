package MorseConverter;

import java.util.HashMap;

public class Converter {

    static HashMap<String, String> lettersToMorse = new HashMap<>();
    static HashMap<String, String> morseToLetters = new HashMap<>();

    static {
        lettersToMorse.put("A", ".-");
        lettersToMorse.put("B", "-...");
        lettersToMorse.put("C", "-.-.");
        lettersToMorse.put("D", "-..");
        lettersToMorse.put("E", ".");
        lettersToMorse.put("F", "..-.");
        lettersToMorse.put("G", "--.");
        lettersToMorse.put("H", "....");
        lettersToMorse.put("I", "..");
        lettersToMorse.put("J", ".---");
        lettersToMorse.put("K", "-.-");
        lettersToMorse.put("L", ".-..");
        lettersToMorse.put("M", "--");
        lettersToMorse.put("N", "-.");
        lettersToMorse.put("O", "---");
        lettersToMorse.put("P", ".--.");
        lettersToMorse.put("Q", "--.-");
        lettersToMorse.put("R", ".-.");
        lettersToMorse.put("S", "...");
        lettersToMorse.put("T", "-");
        lettersToMorse.put("U", "..-");
        lettersToMorse.put("V", "...-");
        lettersToMorse.put("W", ".--");
        lettersToMorse.put("X", "-..-");
        lettersToMorse.put("Y", "-.--");
        lettersToMorse.put("Z", "--..");
        lettersToMorse.put("1", ".----");
        lettersToMorse.put("2", "..---");
        lettersToMorse.put("3", "...--");
        lettersToMorse.put("4", "....-");
        lettersToMorse.put("5", ".....");
        lettersToMorse.put("6", "-....");
        lettersToMorse.put("7", "--...");
        lettersToMorse.put("8", "---..");
        lettersToMorse.put("9", "----.");
        lettersToMorse.put("0", "-----");
        lettersToMorse.put(",", "--..--");
        lettersToMorse.put(" ", "/");


    }
    static {
        //Loopar igenom varje nyckel i hashmappen
        for (String letter : lettersToMorse.keySet()) {
            //Hämtar motsvarande morsekod för den aktuella nyckeln
            String morseCode = lettersToMorse.get(letter);
            //Lägger till bokstaven (nyckeln) och morsekoden (värdet)
            //byter plats på dem för att ha två olika hashmaps.
            morseToLetters.put(morseCode, letter);
        }

    }



    public static String convertToText(String morseCode) {
        //Använder mig av StringBuilder istället för +=
        //Lagrar den omvandlade texten
        StringBuilder text = new StringBuilder();

        //felhantering för tom sträng
        if (!morseCode.isEmpty()) {
            //Används för att separera varje ord.
            String[] words = morseCode.split("/");

            //Går igenom varje ord
            for (String s : words) {
                //Varje ord splittas med hjälp av mellanslag
                String[] morseChars = s.split(" ");
                //Loop som går igenom varje tecken
                for (String character : morseChars) {
                    //Kollar så att morsetecknet finns i hashmappen
                    if (morseToLetters.containsKey(character)) {
                        //Lägger till bokstaven som matchar morsetecknet i StringBuildern text
                        text.append(morseToLetters.get(character));
                    }
                }
                //Separerar orden med mellanslag.
                text.append(" ");
            }
        } else {
            //Lägger till texten "ingenting" efter 'inmatat värdet' blir i text
            text.append("ingenting");

        }
        //returnerar värdet som en String
        return text.toString();
    }

    public static String convertToMorse(String text) {
        StringBuilder morseCode = new StringBuilder();
        //Omvandlar texten till stora bokstäver.
        text = text.toUpperCase();

        //Går igenom varje tecken
        for (int i = 0; i < text.length(); i++) {
            //Hämtar tecknet i en char
            char character = text.charAt(i);
            //Konverterar char till String för att kunna använda den i hashmappen som bara är Strings
            String charString = String.valueOf(character);
            //Kontrollerar att strängen finns som en key i hashmappen
            if (lettersToMorse.containsKey(charString)) {
                //Lägger till tecknet om det finns i hashmappen, följt av ett mellanslag.
                morseCode.append(lettersToMorse.get(charString)).append(" ");
            } else {
                //Finns tecknet inte så läggs bara ett mellanslag till.
                //Felhantering. Programmet fortsätter oavsett tecken som skrivs in.
                morseCode.append(" ");
            }
        }
        //Returnerar värdet som en String
        return morseCode.toString();
    }

}

