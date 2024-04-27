import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dialogue {
    private List<String> characters;

    public Dialogue() {
        this.characters = new ArrayList<>();
    }

    // Method to load dialogues from a text file
    public void loadDialogues(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                characters.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to get the characters array
    public List<String> getCharacters() {
        return characters;
    }
}