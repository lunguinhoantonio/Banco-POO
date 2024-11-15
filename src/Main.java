import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seMenorIdadeSair;
        System.out.println("Realizando cadastro no banco ZYXW");
        System.out.print("Insira sua idade: ");
        seMenorIdadeSair = scanner.nextInt();
        scanner.nextLine();
        if (seMenorIdadeSair < 18) {
            System.out.println("De acordo com nossos Termos de Uso, menores de 18 anos são proibidos de criar conta no nosso banco!");
            System.exit(0);
        }

        Cliente cliente = new Cliente();
        cliente.setAge(seMenorIdadeSair);
        boolean correctName;
        String answer;
        do {
            System.out.print("Insira seu nome completo: ");
            String nomeCompleto = scanner.nextLine();
            cliente.setName(nomeCompleto);
            System.out.println("Esse é seu nome completo? " + cliente.getName().toUpperCase());
            System.out.print("Resposta [S/N]: ");
            answer = scanner.nextLine().toUpperCase();
            correctName = answer.charAt(0) == 'S';
        } while (!correctName);

        String cpf;
        do {
            System.out.print("Insira seu CPF: ");
            cpf = scanner.nextLine();
            if (Validate.CPFValidator(cpf)) {
                cliente.setCPF(cpf);
                break;
            } else {
                System.out.println("Esse CPF não é válido! Tente novamente!");
            }
        } while (!Validate.CPFValidator(cpf));

        boolean isValidDay = false, isValidMonth, isValidYear;
        int monthAnswer, dayBirth;
        do {
            System.out.println("Digite o número correspondente ao mês.");
            System.out.println("1. Janeiro");
            System.out.println("2. Fevereiro");
            System.out.println("3. Março");
            System.out.println("4. Abril");
            System.out.println("5. Maio");
            System.out.println("6. Junho");
            System.out.println("7. Julho");
            System.out.println("8. Agosto");
            System.out.println("9. Setembro");
            System.out.println("10. Outubro");
            System.out.println("11. Novembro");
            System.out.println("12. Dezembro");
            System.out.print("Resposta: ");
            answer = scanner.nextLine();
            monthAnswer = Integer.parseInt(answer);
            isValidMonth = monthAnswer > 0 && monthAnswer <= 12;
        } while (!isValidMonth);

        int[] month30DaysPossible = {1, 3, 5, 7, 8, 10, 12};
        int[] month31DaysPossible = {4, 6, 9, 11};
        do {
            System.out.print("Digite seu dia de nascimento: ");
            dayBirth = scanner.nextInt();
            for (int month : month30DaysPossible) {
                if (month == monthAnswer) {
                    isValidDay = dayBirth > 0 && dayBirth <= 30;
                    break;
                }
            }

            for (int month : month31DaysPossible) {
                if (month == monthAnswer) {
                    isValidDay = dayBirth > 0 && dayBirth <= 31;
                    break;
                }
            }

            if (monthAnswer == 2) {
                isValidDay = dayBirth > 0 && dayBirth <= 29;
            }
            
            if (!isValidDay) {
                System.out.println("Dia inválido! Tente Novamente!");
            }
        } while (!isValidDay);

        Arrays.fill(month30DaysPossible, 0);
        Arrays.fill(month31DaysPossible, 0);

        scanner.close();
    }
}