//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int n1 = Integer.parseInt(args[0]);
        int m1 = Integer.parseInt(args[1]);
        int n2 = Integer.parseInt(args[2]);
        int m2 = Integer.parseInt(args[3]);
                 String mas1 = getPath(n1, m1);  //первый
                  //System.out.println(mas1);
                    String mas2 = getPath(n2, m2);  //второй
              //System.out.println(mas2);
        String res = mas1 + mas2;
           System.out.println(res);
    }
           private static String getPath(int n, int m) {
           StringBuilder path = new StringBuilder();
        int current = 1;
        do {path.append(current); current = (current + m - 1) % n;
            if (current == 0) {current = n;}} while (current != 1);

        return path.toString();
    }
}