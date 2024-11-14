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
        scanner.close();
    }
}