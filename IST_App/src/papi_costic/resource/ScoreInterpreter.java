package papi_costic.resource;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class ScoreInterpreter {
    private static final String DATA_FILE_PATH = "./IST_App/src/papi_costic/resource/data/interpretations.dat";
    private Map<String, NavigableMap<Integer, String>> interpretations = new TreeMap<>();

    public ScoreInterpreter() {
        if (!loadInterpretationsFromFile()) {
            return;
        }
    }

    public void saveInterpretationsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE_PATH))) {
            oos.writeObject(interpretations);
        } catch (IOException e) {
            System.err.println("Could not save interpretations to file.");
        }
    }

    @SuppressWarnings("unchecked")
    private boolean loadInterpretationsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE_PATH))) {
            interpretations = (Map<String, NavigableMap<Integer, String>>) ois.readObject();
            return true;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Could not load interpretations from file, using defaults.");
            return false;
        }
    }

    public String interpretScore(String category, int score) {
        NavigableMap<Integer, String> interpretationMap = interpretations.get(category);
        if (interpretationMap == null) {
            return "Unknown category";
        }

        return interpretationMap.floorEntry(score).getValue();
    }

}
