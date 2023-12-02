import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


/**
 * Reads information from the input file.
 */
public class ReadFile {
    /**
     * Reads fields data from input file and returns them in a list.
     *
     * @param file file containing field information.
     * @return list of fields from the file.
     * @throws IOException if the file is not read properly.
     */
    public static ArrayList<Field> readFields(String file) throws IOException {
        BufferedReader reader0 = new BufferedReader(new FileReader(file));
        if(reader0.readLine() == null) throw new IOException("Empty file.");
        reader0.close();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        int number = Integer.parseInt(reader.readLine().trim());

        ArrayList<String> lines = new ArrayList<>();
        for(int i = 0; i < number; i++) { lines.add(reader.readLine()); }

        ArrayList<Field> fields = new ArrayList<>();

        for(String sentence : lines){
            String[] line = sentence.split(" ");
            String fieldType = line[0];
            switch (fieldType) {
                case "Property":
                    fields.add(new Property());
                    break;
                case "Service":
                    if(Integer.parseInt(line[1]) < 0) throw new IllegalArgumentException("Negative money is invalid.");
                    fields.add(new Service(Integer.parseInt(line[1])));
                    break;
                case "Lucky":
                    if(Integer.parseInt(line[1]) < 0) throw new IllegalArgumentException("Negative money is invalid.");
                    fields.add(new Lucky(Integer.parseInt(line[1])));
                    break;
                default: throw new IOException("Wrong field type.");
            }
        } return fields;
    }

    /**
     * Reads player data from input file and outputs the list.
     *
     * @param file file containing player information.
     * @return list of players from the file.
     * @throws IOException if the file is not read properly.
     */
    public static ArrayList<Player> readPlayers(String file) throws IOException {
        BufferedReader reader0 = new BufferedReader(new FileReader(file));
        if(reader0.readLine() == null) throw new IOException("Empty file.");
        reader0.close();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        int number = Integer.parseInt(reader.readLine().trim());
        for (int i=0; i < number; i++) { reader.readLine(); }

        int number2 = Integer.parseInt(reader.readLine().trim());

        ArrayList<String> lines = new ArrayList<>();
        for(int i=0; i < number2; i++) { lines.add(reader.readLine()); }

        ArrayList<Player> players = new ArrayList<>();

        for (String sentence : lines) {
            String[] line = sentence.split(" ");
            String playerName = line[0];
            String playerStra = line[1];
            switch (playerStra) {
                case "Greedy":
                    players.add(new Greedy(playerName));
                    break;
                case "Careful":
                    players.add(new Careful(playerName));
                    break;
                case "Tactical":
                    players.add(new Tactical(playerName));
                    break;
                default:
                    throw new IOException("Wrong player type.");
            }
        } return players;
    }

    /**
     * Reads dice rolls from input file outputs the list.
     *
     * @param file file containing dice rolls.
     * @return list of numbers of dice rolls.
     * @throws IOException if the file is not read properly.
     */
    public static ArrayList<Integer> readDice(String file) throws IOException {
        BufferedReader reader0 = new BufferedReader(new FileReader(file));
        if(reader0.readLine() == null) throw new IOException("Empty file.");
        reader0.close();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        ArrayList<String> lines = new ArrayList<>();
        while ((line = reader.readLine()) != null) { lines.add(line); }

        ArrayList<Integer> dices = new ArrayList<>();

        for(String number : lines) { dices.add(Integer.parseInt(number)); }

        return dices;
    }
}