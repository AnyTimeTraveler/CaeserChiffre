package org.simonscode.vaderchiffre;

public class Chiffre {
    public static void main(String[] args) {
        System.out.print("Teste meine Methode...");
        assertEquals("bvup", enc("auto", 1));
        assertEquals("leyw", enc("haus", 4));
        assertEquals("dddd", enc("aaaa", 3));
        assertEquals("cccc", enc("zzzz", 3));
        assertEquals("xxxx", enc("xxxx", 26));
        System.out.println("OK");

        System.out.print("Teste seine Methode...");
        assertEquals("bvup", aufgabe6("auto", 1));
        assertEquals("leyw", aufgabe6("haus", 4));
        assertEquals("dddd", aufgabe6("aaaa", 3));
        assertEquals("cccc", aufgabe6("zzzz", 3));
        assertEquals("xxxx", aufgabe6("xxxx", 26));
        System.out.println("OK");

        System.out.println("\n\n\nAlle Tests bestanden!\n\n");
    }

    // meine methode
    private static String enc(String plaintext, int shiftAmount) {

        // zwei gleichlange char-arrays für den input und output machen
        char[] input = plaintext.toCharArray();
        char[] output = new char[plaintext.length()];

        // für jeden Buchstaben im Input:
        for (int i = 0; i < input.length; i++) {
            // Schritt 1
            // Indem man den Wert von 'a' abzieht, erhält man:
            // 'a' = 0
            // 'z' = 25
            // Das ist effektiv das gleiche, wie das Array aber mit Mathe und effizienter
            // Die Verschiebung ist nötig, damit Schritt 3 funktioniert.
            int buchstabeAlsZahl = input[i] - 'a';

            // Schritt 2
            // Jetzt schieben wir den Buchstaben um die gewünschte Menge
            int verschobenerBuchstabe = buchstabeAlsZahl + shiftAmount;

            // Schritt 3
            // Wenn wir über 26 kommen, müssen wir das Ganze noch Modulo nehmen.
            // Sonst würden Verschiebungen von mehr als 'z' nicht funktionieren.
            int wrappterBuchstabe = verschobenerBuchstabe % 26;


            // Schritt 4
            // Als letztes müssen wir noch den ASCII-Wert von 'a' wieder dazu addieren.
            int zurueckKonvertierterBuchstabe = wrappterBuchstabe + 'a';

            // Schritt 5
            // Buchstaben in das output array schreiben
            output[i] = (char) zurueckKonvertierterBuchstabe;
        }

        // Zum Schluss wird das char[] noch in einen richtigen String gewandelt.
        return new String(output);
    }


    // die erwartete methode
    // Schritt 1,2,3 sind dabei gleich, wie meine Methode
    private static String aufgabe6(String plaintext, int shiftAmount) {

        String ergebnis = "";

        // das ist das Gleiche, wie in der Arbeit aber kürzer
        char[] abc = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        // fuer jeden Buchstaben im Input:
        for (int i = 0; i < plaintext.length(); i++) {
            // Schritt 1
            // Indem man den Wert von 'a' abzieht, erhält man:
            // 'a' = 0
            // 'z' = 25
            // Das ist effektiv das gleiche, wie das Array aber mit Mathe und effizienter
            int buchstabeAlsZahl = plaintext.charAt(i) - 'a';

            // Schritt 2
            // Jetzt schieben wir den Buchstaben um die gewünschte Menge
            int verschobeneZahl = buchstabeAlsZahl + shiftAmount;

            // Schritt 3
            // Wenn wir über 26 kommen, müssen wir das Ganze noch Modulo nehmen.
            // Sonst würden Verschiebungen von mehr als 'z' nicht funktionieren.
            int moduloZahl = verschobeneZahl % 26;

            // Schritt 4
            // Jetzt wandelt man die verschobene Zahl mit Hilfe des ABC's wieder in einen Buchstaben
            char verschobenerBuchstabe = abc[moduloZahl];

            // Schritt 5
            // Den Buchstaben an das Ergebnis hängen
            ergebnis += verschobenerBuchstabe;
        }

        return ergebnis;
    }


    // Helfermethode zum Testen.
    // Bitte ignorieren
    private static void assertEquals(String expected, String actual) {
        if (!expected.equals(actual)) {
            System.err.println("\n\nExpected: \"" + expected + "\" Actual: \"" + actual + "\"\n\n");
            throw new RuntimeException("Test nicht bestanden.");
        }
    }
}
