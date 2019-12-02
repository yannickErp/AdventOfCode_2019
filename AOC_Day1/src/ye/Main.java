package ye;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Path path = Paths.get("input.txt");
        List<String> lines = null;
        try {
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert lines != null;
        int totalFuel = 0;
        for (String line : lines) {
            int moduleFuel = getModuleFuel(Integer.parseInt(line));
            //System.out.println("Module = " + moduleFuel);
            totalFuel = totalFuel + moduleFuel;
        }
        System.out.println("Total: " + totalFuel);
    }

    private static int getModuleFuel(int moduleMass) {
        int moduleFuel = 0;
        double fuelIterator = moduleMass;
        while (fuelIterator > 0) {
            fuelIterator = (Math.floor(fuelIterator / 3) - 2);
            if (fuelIterator <= 0) {
                break;
            }
            moduleFuel = (int) (moduleFuel + fuelIterator);
        }

        return  moduleFuel;
    }
}


