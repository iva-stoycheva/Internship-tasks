/*import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException{
        //create file input.txt and write <integer> <integer> <operator> in it
        try {
            FileWriter fileWriter = new FileWriter("input.txt");
            fileWriter.write("8 5 +");
            fileWriter.write("\n2 4 *");
            fileWriter.write("\n9 1 -");
            fileWriter.write("\n10 3 /");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //change places of the 2nd and 3rd element
        FileReader fileReader = new FileReader("input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while((line = bufferedReader.readLine()) != null) {
            int x;
            String[] split = line.split(" ");
            String lastElement = split[split.length - 1];
            String firstElement = split[0];
            String secondElement = split[1];
            int firstNum = Integer.parseInt(firstElement);
            int secondNum = Integer.parseInt(secondElement);

//            switch (lastElement) {
//                case "+":
//                    System.out.println(firstNum + lastElement + secondNum + " = " + (firstNum + secondNum));
//                    break;
//                case "-":
//                    System.out.println(firstNum + lastElement + secondNum + " = " + (firstNum - secondNum));
//                    break;
//                case "*":
//                    System.out.println(firstNum + lastElement + secondNum + " = " + firstNum * secondNum);
//                    break;
//                case "/":
//                    System.out.println(firstElement + lastElement + secondElement + " = " + (float) firstNum / secondNum);
//                    break;
//                default:
//                    break;
//            }

            try (FileWriter fileWriter = new FileWriter("output.txt")){
                if (lastElement.equals("+")) {
                    x=firstNum + secondNum;
                    fileWriter.write("" + x);
                    //System.out.println(x);
                } else if (lastElement.equals("-")) {
                    x = firstNum - secondNum;
                    //fileWriter.write(x);
                    //System.out.println(x);
                } else if (lastElement.equals("*")) {
                    x = firstNum * secondNum;
                    //fileWriter.write(x);
                    //System.out.println(x);
                } else if (lastElement.equals("/")) {
                    x = firstNum / secondNum;
                    //fileWriter.write(x);
                    //System.out.println((float)x);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        inputOutputFiles("input.txt");
    }
    public static void inputOutputFiles(String inputFile) throws IOException{
        File file = new File(inputFile);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
    }
}*/

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static final String OUTPUT_FILE_FORMAT = "%d %s %d = %.2f\n";

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("input.txt"));

        try (FileWriter fileWriter = new FileWriter("output.txt")) {
            for (String line : lines) {
                String[] splitElements = line.split(" ");
                String operation = splitElements[splitElements.length - 1];
                int firstNum = Integer.parseInt(splitElements[0]);
                int secondNum = Integer.parseInt(splitElements[1]);

                float result;
                switch (operation) {
                    case "+":
                        result = firstNum + secondNum;
                        break;
                    case "-":
                        result = firstNum - secondNum;
                        break;
                    case "*":
                        result = firstNum * secondNum;
                        break;
                    case "/":
                        result = (float) firstNum / secondNum;
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown operation");
                }

                fileWriter.append(String.format(OUTPUT_FILE_FORMAT, firstNum, operation, secondNum, result));
            }

        }
    }
}
