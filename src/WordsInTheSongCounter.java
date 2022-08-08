import java.awt.im.InputMethodHighlight;
import java.util.Scanner;

class InvalidInput extends RuntimeException {
    public InvalidInput(String s){
        super(s);
    }
}

public class WordsInTheSongCounter {
    static String[] getSongAsArray() {
        String song = "In the town where I was born\n" +
                "Lived a man who sailed to sea\n" +
                "And he told us of his life\n" +
                "In the land of submarines\n" +
                "So we sailed on to the sun\n" +
                "'Til we found a sea of green\n" +
                "And we lived beneath the waves\n" +
                "In our yellow submarine\n" +
                "We all live in a yellow submarine\n" +
                "Yellow submarine, yellow submarine\n" +
                "We all live in a yellow submarine\n" +
                "Yellow submarine, yellow submarine\n" +
                "And our friends are all aboard\n" +
                "Many more of them live next door\n" +
                "And the band begins to play\n" +
                "We all live in a yellow submarine\n" +
                "Yellow submarine, yellow submarine\n" +
                "We all live in a yellow submarine\n" +
                "Yellow submarine, yellow submarine\n" +
                "Full steam ahead, Mister Boatswain, full steam ahead\n" +
                "Full steam ahead it is, Sergeant\n" +
                "(Cut the cable, drop the cable)\n" +
                "Aye-aye, sir, aye-aye\n" +
                "Captain, captain\n" +
                "As we live a life of ease (a life of ease)\n" +
                "Every one of us (every one of us)\n" +
                "Has all we need (has all we need)\n" +
                "Sky of blue (sky of blue)\n" +
                "And sea of green (sea of green)\n" +
                "In our yellow (in our yellow)\n" +
                "Submarine (submarine, aha)\n" +
                "We all live in a yellow submarine\n" +
                "A yellow submarine, yellow submarine\n" +
                "We all live in a yellow submarine\n" +
                "A yellow submarine, yellow submarine\n" +
                "We all live in a yellow submarine\n" +
                "Yellow submarine, yellow submarine\n" +
                "We all live in a yellow submarine\n" +
                "Yellow submarine, yellow submarine";
        String songLyrics = song.replace("\n", " ").replace(",", "")
                .replace("(", "").replace(")", "").toLowerCase();
        String[] lyricsArray = songLyrics.split(" ");
        return lyricsArray;
    }

    static void inputHandling(String word) throws RuntimeException {
        if (word.matches(".*[^a-z].*")) {
            throw new InvalidInput("You must enter a lowercase word without any additional symbols");
        }
    }

    public static void main(String[] args){
        String[] lyrics = getSongAsArray();
        Scanner input = new Scanner(System.in);

        String word = input.nextLine();
        inputHandling(word);
        int wordCount = 0;

        for (int i = 0; i < lyrics.length; i++){
            if (lyrics[i].equals(word)){
                wordCount++;
            }
        }
        System.out.println(wordCount);
    }
}
