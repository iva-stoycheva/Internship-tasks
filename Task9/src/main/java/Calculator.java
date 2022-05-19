import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        /* for testing :
        binary: (b.10+b.11)*b.100-b.10=?
        octal: (o.2+o.3)*o.4-o.2=?
        decimal: (2+3)*4-2=?
        hexadecimal: (h.2+h.3)*h.4-h.2=?
        */

        Scanner scanner = new Scanner(System.in);
        System.out.println("Еnter math expression in binary, octal, decimal or hexadecimal: ");
        String str = scanner.next();
        String line = str.substring(0, str.indexOf("="));
        double result = MathExpression_exp4j.evaluate(line);

        MathExpression_mXparser.evaluate(line);
        System.out.println();

        /*System.out.println(DecimalToOtherNumberSystem.toBinary(result));
        System.out.println(DecimalToOtherNumberSystem.toOctal(result));
        System.out.println(DecimalToOtherNumberSystem.toDecimal(result));
        System.out.println(DecimalToOtherNumberSystem.toHexadecimal(result));*/
    }
}
