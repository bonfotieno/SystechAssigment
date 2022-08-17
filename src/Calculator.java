import java.text.DecimalFormat;

public class Calculator {
    static DecimalFormat df = new DecimalFormat("#.####");
    public static void main(String[] args) {
        System.out.println("Sum "+add(12.5689456, 12.5673));
        System.out.println("Difference "+subtract(3455.654874846364, 12.5673));
        System.out.println("Product "+multiply(12.5689, 12.5673));
        System.out.println("Quotient "+divide(12.5689, 12.5673));
        System.out.println("Modulus "+modulus(12.5689, 12.5673));
    }

    static String add(double num1, double num2){
        double sum;
        sum = num1+num2;
        return df.format(sum);
    }

    static String subtract(double num1, double num2){
        double difference;
        difference = num1 - num2;
        return df.format(difference);
    }

    static String multiply(double num1, double num2){
        double product;
        product = num1 * num2;
        return df.format(product);
    }

    static String divide(double num1, double num2){
        double quotient;
        quotient = num1 / num2;
        return df.format(quotient);
    }

    static String modulus(double num1, double num2){
        double remainder;
        remainder = num1 % num2;
        return df.format(remainder);
    }
}