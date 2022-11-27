import java.util.Scanner;

public class Main {
    public static String calc(String input) throws Exception {
        boolean isRoman = false;
        int firstNumber;
        int secondNumber;
        String operator;

        String[] numbers = input.split(" ");
        if (numbers.length!=3) {
            throw new Exception("unknown task");
        }

        try {
            firstNumber = Integer.parseInt(numbers[0]);
            secondNumber = Integer.parseInt(numbers[2]);
        } catch (NumberFormatException e) {
            firstNumber = RomanNumeral.romanToArabic(numbers[0]);
            secondNumber = RomanNumeral.romanToArabic(numbers[2]);
            isRoman = true;
        }
        if (firstNumber>10 || firstNumber<1 || secondNumber>10 || secondNumber<1 ) {
            throw new Exception("numbers <1 or >10");
        }
        operator = numbers[1];

        int result = switch (operator) {
            case "-" -> firstNumber - secondNumber;
            case "+" -> firstNumber + secondNumber;
            case "*" -> firstNumber * secondNumber;
            case "/" -> firstNumber / secondNumber;
            default -> 0;
        };

        if (isRoman){
            return RomanNumeral.arabicToRoman(result);
        } else return Integer.toString(result);

    }


    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter task:");
        String line = scanner.nextLine();

        System.out.println("Result:");
        System.out.println(calc(line));


    }
}
