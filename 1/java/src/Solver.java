import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class Solver {

    private int total = 0;
    private int rTotal = 0;

    public Solver(String filePath) {
        File f = new File(System.getProperty("user.dir") + File.separatorChar +filePath);
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                total += calcFuel(Integer.parseInt(line));
                rTotal += calcTotalFuel(Integer.parseInt(line));
            }
            System.out.println("Total (naive) fuel consumption: " + total);
            System.out.println("Total (recursive) fuel consumption: " + rTotal);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int calcFuel(int mass) {
        return (int) Math.floor(mass / 3) - 2;
    }

    private int calcTotalFuel(int mass) {
        int total = 0;
        int newFuel = mass;

        while (newFuel > 0) {
            newFuel = calcFuel(newFuel);
            if (newFuel > 0) {
                total += newFuel;
            }
        }
        return total;
    }
}
