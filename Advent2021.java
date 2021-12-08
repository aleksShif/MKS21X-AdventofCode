//INCLUDE day 1 both parts comment in next commit
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
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
    if (mode == 3) {
      try {
        File file = new File(filename);
        Scanner in = new Scanner(file);
        ArrayList<String> binary = new ArrayList<String>();
        ArrayList<String> binary2 = new ArrayList<String>();
        while (in.hasNextLine()) {
          String line = in.nextLine();
          binary.add(line);
          binary2.add(line);
        }
        String oxyGen;
        String CO2Scrub;
        for (int i = 0; i < 12; i++) {
          int zeroCount = 0;
          int oneCount = 0;
          for (int x = 0; x < binary.size(); x++) {
            char first = binary.get(x).charAt(i);
            if (first == '0') {
              zeroCount++;
            }
            else {
              oneCount++;
            }
          }
          char keep;
          if (zeroCount > oneCount) {
            keep = '0';
          }
          else {
            keep = '1';
          }
          for (int x = 0; x < binary2.size(); x++) {
            char first = binary2.get(x).charAt(i);
            if (first == '0') {
              zeroCount++;
            }
            else {
              oneCount++;
            }
          }
          char keep2;
          if (zeroCount > oneCount) {
            keep2 = '1';
          }
          else {
            keep2 = '0';
          }
          for (int x = 0; x < binary.size(); x++) {
            char first = binary.get(x).charAt(i);
            if (first != keep) {
              binary.remove(x);
            }
          }
          for (int x = 0; x < binary2.size(); x++) {
            char first = binary2.get(x).charAt(i);
            if (first != keep2) {
              binary2.remove(x);
            }
          }
          if (binary.size() == 1) {
            oxyGen = binary.get(0);
          }
          if (binary2.size() == 1) {
            CO2Scrub = binary2.get(0);
          }
          if (binary.size() == 1 && binary2.size() == 1) {
            break;
          }
        }
        System.out.println(Integer.parseInt(oxyGen,2) * Integer.parseInt(CO2Scrub,2));
      } catch (FileNotFoundException ex) {

      }
    }
  }
  }
