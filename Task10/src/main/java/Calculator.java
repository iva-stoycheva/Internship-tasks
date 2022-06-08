public class Calculator {
    public static void main(String[] args) {
       MemoryService memoryService = new MemoryService();
       try {
          String mathExp1 = memoryService.input();
          String rightSide1 = mathExp1.substring(mathExp1.indexOf("="));
          if (rightSide1.contains("M")) {
             memoryService.insertIntoM(mathExp1);
          }

          String mathExp2 = memoryService.input();
          String leftSide2 = mathExp2.substring(0, mathExp2.indexOf("="));
          String rightSide2 = mathExp2.substring(mathExp2.indexOf("="));
          if (leftSide2.contains("M") && rightSide2.contains("M+")) {
             memoryService.insertResultFromCalculationsMplus(mathExp2);
          }

          String mathExp3 = memoryService.input();
          String rightSide3 = mathExp3.substring(mathExp3.indexOf("="));
          if (rightSide3.contains("M-")) {
             memoryService.insertResultFromCalculationsMminus(mathExp3);
          }

          memoryService.selectMemoryResult();
       } catch (Exception e) {
          e.printStackTrace();
       }
    }
}
