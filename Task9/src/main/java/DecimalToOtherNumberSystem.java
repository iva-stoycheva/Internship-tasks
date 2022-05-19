public class DecimalToOtherNumberSystem {
    public static String toBinary(double decimal){
        String binaryString = Long.toBinaryString(Double.doubleToLongBits(decimal));
        return binaryString;
    }

    public static String toOctal(double decimal){
        String octalString = Long.toOctalString(Double.doubleToLongBits(decimal));
        return octalString;
    }

    public static String toDecimal(double decimal){
        String decimalString = String.valueOf(decimal);
        return decimalString;
    }

    public static String toHexadecimal(double decimal){
        String hexString = Long.toHexString(Double.doubleToLongBits(decimal));
        return hexString;
    }
}
