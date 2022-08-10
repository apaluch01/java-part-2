import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class UniqueWordsPrinter {
    static String readLyricsToString() {
        StringBuilder lyrics = new StringBuilder();
        try {
            File lyricsText = new File("src/lyrics.txt");
            Scanner lyricsReader = new Scanner(lyricsText);
            while (lyricsReader.hasNextLine()) {
                lyrics.append(lyricsReader.nextLine()).append("\n");
            }
            lyricsReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String lyricsString = lyrics.toString();
        lyricsString = lyricsString.replace("\n", " ").replace(",", "")
                .replace("(", "").replace(")", "").toLowerCase();
        return lyricsString;
    }

    static HashSet<String> removeDuplicates(String lyricsString) {
        String[] lyricsArray = lyricsString.split(" ");
        List<String> lyricsList = Arrays.asList(lyricsArray);

        return new HashSet<String>(lyricsList);
    }

    public static void main(String[] args) {
        HashSet<String> lyricsUniqueWords = removeDuplicates(readLyricsToString());

        lyricsUniqueWords.forEach(System.out::println);
    }
}
