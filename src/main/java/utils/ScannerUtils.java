package utils;

import java.util.Scanner;

public class ScannerUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputFunction(int from, int to) {
        while (true) {
            int number = ScannerUtils.inputInt();
            if (number >= from && number <= to) {
                return number;
            } else {
                System.err.println("Nhập trong khoảng " + from + "-" + to);
            }
        }
    }

    public static String inputEmail() {
        while (true) {
            String email = ScannerUtils.inputString();
            if (!email.contains("@")) {
                System.err.println("Email không hợp lệ");
                System.out.print("Mời bạn nhập lại email: ");
            } else {
                return email;
            }
        }
    }

    public static String inputPassword() {
        while (true) {
            String password = ScannerUtils.inputString();
            if (password.length() < 6 || password.length() > 12) {
                System.err.println("Password cần từ 6 - 12");
                System.out.print("Mời bạn nhập lại password: ");
                continue;
            }

            boolean hasAtLeast1Character = false;

            for (int i = 0; i < password.length(); i++) {
                if (Character.isUpperCase(password.charAt(i))) {
                    hasAtLeast1Character = true;
                    break;
                }
            }
            if (hasAtLeast1Character) {
                return password;
            } else {
                System.err.println("Password phải có ít nhất 1 ký tự viết hoa");
                System.out.print("Mời bạn nhập lại password: ");
            }
        }
    }

    public static String inputPhoneNumber(String errorMessage) {
        while (true) {
            String number = ScannerUtils.inputString();
            if (number.length() > 12 || number.length() < 9) {
                System.err.println(errorMessage);
                continue;
            }

            if (number.charAt(0) != '0') {
                System.err.println(errorMessage);
                continue;
            }

            boolean isNumber = true;

            for (int i = 0; i < number.length(); i++) {
                if (!Character.isDigit(number.charAt(i))) {
                    isNumber = false;
                    break;
                }
            }
            if (isNumber) {
                return number;
            } else {
                System.out.println(errorMessage);
                System.out.print("Mời bạn nhập lại phone number: ");
            }

        }
    }

    public static int inputPositiveInt(String errorMessage) {
        while (true) {
            int id = ScannerUtils.inputInt();
            if (id < 0) {
                System.err.println(errorMessage);
            } else {
                return id;
            }
        }
    }

    public static int inputInt() {
        while (true) {
            try {
                String input = scanner.nextLine();
                input = input.trim();
                int output = Integer.parseInt(input);
                return output;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    // NHẬP VÀO TIỀN
    public static float inputPositiveMoney(String erroMessage2) {
        while (true) {
            float money = ScannerUtils.inputMoney(erroMessage2);
            if (money < 0) {
                System.err.print(erroMessage2);
            } else {
                return money;
            }
        }
    }

    public static float inputMoney(String errorMessage) {
        while (true) {
            try {
                String inputMoney = scanner.nextLine();
                inputMoney = inputMoney.trim();
                float outputMoney = Float.parseFloat(inputMoney);
                return outputMoney;
            } catch (Exception e) {
                System.err.println(errorMessage);
            }
        }
    }

    public static String inputString() {
        while (true) {

            String inputString = scanner.nextLine();
            inputString = inputString.trim();
            inputString = inputString.replaceAll("\\s+", " ");

            return inputString;
        }
    }

    // NHẬP VÀO TÊN VÀ CHUẨN HÓA TÊN:
    public static String inputName(String errorMessage) {
        while (true) {

            String name = ScannerUtils.inputString();

            String[] words = name.split(" ");
            name = "";
            for (String word : words) {

                String firstCharacter = word.substring(0, 1).toUpperCase();
                String leftCharacter = word.substring(1).toLowerCase();
                word = firstCharacter + leftCharacter;
                name += word + " ";
            }

            return name.trim();
        }
    }
}
