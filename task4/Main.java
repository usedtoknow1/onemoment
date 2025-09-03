//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File(args[0]);
        Scanner sc = new Scanner(file);
        ArrayList<Integer> nums = new ArrayList<>();
        while(sc.hasNextLine()){
            String line = sc.nextLine().trim();
            if(!line.isEmpty()){
                nums.add(Integer.parseInt(line));
            }
        }
        sc.close();
        Collections.sort(nums);
        int n = nums.size();
        int median;
        if(n % 2 == 1){
            median = nums.get(n/2);
        } else {
            median = nums.get(n/2 - 1);
        }
        int moves = 0;
        for(int x : nums){
            moves += Math.abs(x - median);
        }
        if(moves <= 20){
            System.out.println(moves);
        } else {
            System.out.println("Невозможно привести все числа к одному за 20 ходов");
        }
    }
}