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

    static HashSet<String> convertStringtoHashSet(String lyricsString) {
        String[] lyricsArray = lyricsString.split(" ");
        List<String> lyricsList = Arrays.asList(lyricsArray);
        HashSet<String> lyricsUniqueWords = new HashSet<String>(lyricsList);

        return lyricsUniqueWords;
    }

    public static void main(String[] args) {
        HashSet<String> lyricsUniqueWords = convertStringtoHashSet(readLyricsToString());

        Iterator iterateWords = lyricsUniqueWords.iterator();

        while (iterateWords.hasNext()) {
            System.out.println(iterateWords.next());
        }
    }
}
