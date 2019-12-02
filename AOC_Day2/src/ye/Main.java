package ye;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        loop1:
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                //System.out.println("Noun = " + i + "  Verb: " + i );
                int result = getOutput(getInputs(), i, j);
                if (result == 19690720) {
                    System.out.println("i :" + i);
                    System.out.println("j :" + j);
                    int solution = 100 * i + j;
                    System.out.println("Result: " + solution);
                    break loop1;
                }
            }
        }
    }

    private static int[] getInputs() {
        Path path = Paths.get("input.txt");
        String content = null;
        try {
            content = Files.readString(path, StandardCharsets.US_ASCII);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert content != null;
        String[] inputStrings = content.split(",");
        return Arrays.stream(inputStrings).mapToInt(Integer::parseInt).toArray();
    }

    private static int getOutput(int[] inputs, int pos1, int pos2){
        inputs[1] = pos1;
        inputs[2] = pos2;
        System.out.println(Arrays.toString(inputs));
        for (int i = 0; i < inputs.length; i = i + 4) {
            if (inputs[i] == 1) {
                inputs[inputs[i + 3]] = inputs[inputs[i + 1]] + inputs[inputs[i + 2]];
                //System.out.println(Arrays.toString(inputs));
            } else if (inputs[i] == 2) {
                inputs[inputs[i + 3]] = inputs[inputs[i + 1]] * inputs[inputs[i + 2]];
                //System.out.println(Arrays.toString(inputs));
            } else if (inputs[i] == 99) {
                //System.out.println("terminal");
                break;
            }
        }
        //System.out.println("OUTPUT: " + inputs[0]);
        return inputs[0];
    }
}