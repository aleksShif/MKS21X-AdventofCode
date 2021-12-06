import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class Advent2021 {
  public static void main(String[] args) {
    String filename = args[0];
    int mode = Integer.parseInt(args[1]);
    if (mode == 1) {
      try {
        int counter = 0;
        File file = new File(filename);
        Scanner in = new Scanner(file);
        ArrayList<Integer> nums = new ArrayList<Integer>();
        while (in.hasNextInt()) {
          int depth = in.nextInt();
          nums.add(depth);
        }
        in.close();
        int i = 0;
        int sum = nums.get(i) + nums.get(i+1) + nums.get(i+2);
        i = 1;
        while (i < nums.size()-2) {
          int temp = 0;
          for (int x = i; x < i+3; x++) {
            temp += nums.get(x);
          }
          if (temp > sum) {
            counter++;
          }
          sum = temp;
          i++;
        }
        System.out.println(counter);
      } catch (FileNotFoundException ex) {

      }
  }
    if (mode == 2) {
      try {
        File file = new File(filename);
        Scanner in = new Scanner(file);
        int position = 0;
        int aim = 0;
        int depth = 0;
        while (in.hasNextLine()) {
          String line = in.nextLine();
          String[] action = line.split(" ");
          String command = action[0];
          int num = Integer.parseInt(action[1]);
          if (command.equals("up")) {
            aim -= num;
          }
          if (command.equals("down")) {
            aim += num;
          }
          if (command.equals("forward")) {
            position += num;
            depth = depth + (num * aim); 
          }
        }
        System.out.println(position * depth);
      } catch (FileNotFoundException ex) {

      }
    }
  }
  }
