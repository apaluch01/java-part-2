import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class DuplicateWordRemover {
    static List getSongAsList() {
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
        String songLyrics = song.replace("\n", " ").replace(",", "").toLowerCase();
        List<String> lyricsList = Arrays.asList(songLyrics.split(" "));
        return lyricsList;
    }

    public static void main(String[] args) {
        List<String> lyrics = getSongAsList();
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();//exceptions for input space etc

        ListIterator<String> wordsIterator = lyrics.listIterator();
        int wordCount = 0;

        while (wordsIterator.hasNext()){
            if (wordsIterator.next().equals(word)){
                wordCount++;
            }
        }
        System.out.println(wordCount);
    }

}
