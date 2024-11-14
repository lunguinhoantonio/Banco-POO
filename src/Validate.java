public class Validate {
    public static boolean CPFValidator(String cpf) {
        cpf = cpf.replaceAll("\\D", "");
        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                sum += (cpf.charAt(i) - '0') * (10 - i);
            }
            int firstDigitChecker = 11 - (sum % 11);
            if (firstDigitChecker >= 10) {
                firstDigitChecker = 0;
            }

            sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += (cpf.charAt(i) - '0') * (11 - i);
            }
            int secondDigitChecker = 11 - (sum % 11);
            if (secondDigitChecker >= 10) {
                secondDigitChecker = 0;
            }


            return cpf.charAt(9) - '0' == firstDigitChecker &&
                    cpf.charAt(10) - '0' == secondDigitChecker;

        } catch (NumberFormatException e) {
            return false;
        }
    }
}
