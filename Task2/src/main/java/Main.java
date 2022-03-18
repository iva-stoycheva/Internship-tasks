import java.io.*;
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
}
