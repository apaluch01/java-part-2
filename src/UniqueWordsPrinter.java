import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class UniqueWordsPrinter {
    static String readLyricsToString(String path) {
        StringBuilder lyrics = new StringBuilder();

        try (Scanner lyricsReader = new Scanner(new File(path))){
            while (lyricsReader.hasNextLine()) {
                lyrics.append(lyricsReader.nextLine()).append("\n");
            }
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
        final String PATH = "src/lyrics.txt";
        HashSet<String> lyricsUniqueWords = removeDuplicates(readLyricsToString(PATH));

        lyricsUniqueWords.forEach(System.out::println);
    }
}
