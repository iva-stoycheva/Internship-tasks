public class Calculator {

    public static void main(String[] args) {
        try {
            MemoryService memoryService = new MemoryService();

            String mathExp1 = memoryService.input();
            memoryService.insertIntoM(mathExp1);

            String mathExp2 = memoryService.input();
            memoryService.insertIntoMplus(mathExp2);

            String mathExp3 = memoryService.input();
            memoryService.insertIntoMminus(mathExp3);

            memoryService.selectMemoryResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
