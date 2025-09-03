import java.io.File;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)  throws Exception {

        String oneFile =  args[0];
        String twoFile = args[1];

        double centerX, centerY, radiusX, radiusY;

        Scanner scanner = new Scanner(new File(oneFile));
        centerX = scanner.nextDouble();
        centerY = scanner.nextDouble();
        radiusX = scanner.nextDouble();
        radiusY = scanner.nextDouble();
        scanner.close();
        scanner = new Scanner(new File(twoFile));
        while (scanner.hasNext()) {
            double pointX = scanner.nextDouble();
            double pointY = scanner.nextDouble();
            double value = Math.pow(pointX - centerX, 2) / Math.pow(radiusX, 2)
                    + Math.pow(pointY - centerY, 2) / Math.pow(radiusY, 2);
            if (Math.abs(value - 1.0) < 1e-9) System.out.println(0);
            else if (value < 1.0) System.out.println(1);
            else System.out.println(2);
        }
        scanner.close();
    }
}