import java.util.Scanner;

public class Calc {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean isRoman = false;
        System.out.println("Enter task:");
        String formula = scanner.nextLine();
        String[] numbers = formula.split(" ");

        if (numbers.length!=3) {
             throw new Exception("unknown task");
        }


        int firstNumber;
        int secondNumber;
        try {
            firstNumber = Integer.parseInt(numbers[0]);
            secondNumber = Integer.parseInt(numbers[2]);
        } catch (NumberFormatException e) {
            firstNumber = RomanNumeral.romanToArabic(numbers[0]);
            secondNumber = RomanNumeral.romanToArabic(numbers[2]);
            isRoman = true;
        }
        String operator = numbers[1];

        int result = switch (operator) {
            case "-" -> firstNumber - secondNumber;
            case "+" -> firstNumber + secondNumber;
            case "*" -> firstNumber * secondNumber;
            case "/" -> firstNumber / secondNumber;
            default -> 0;
        };

        System.out.println("Result:");
        if (isRoman){
            System.out.println(RomanNumeral.arabicToRoman(result));
        } else System.out.println(result);

    }
}
