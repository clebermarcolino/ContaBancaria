package main;

import banco.ContaBanco;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int operacao;

        ContaBanco conta = new ContaBanco();
        Scanner sc = new Scanner(System.in);

        // Abertura da conta bancária logo abaixo

        conta.setNumConta(392);  // Número de conta
        conta.setTitular("Caio"); // Titular da conta
        conta.abrirConta("cp"); // Tipo da conta. cc para Conta corrente ou cp para Conta Poupança

        do {
            System.out.print("""
                    Digite abaixo o número correspondente a operação que você deseja realizar:
                    1 = Depositar
                    2 = Sacar
                    3 = Pagar Mensal
                    4 = Fechar Conta
                    """);

            operacao = sc.nextInt();
            switch (operacao) {
                case 1:
                    System.out.println("Qual valor deseja depositar? ");
                    double deposito = sc.nextDouble();
                    conta.depositar(deposito);
                    System.out.printf("Saldo: %.2f %n",conta.getSaldo());
                    break;

                case 2:
                    System.out.println("Qual valor deseja sacar? ");
                    double saque = sc.nextDouble();
                    conta.sacar(saque);
                    System.out.printf("Saldo: %.2f %n",conta.getSaldo());
                    break;

                case 3:
                    conta.pagarMensalidade();
                    System.out.printf("Saldo: %.2f %n",conta.getSaldo());
                    break;

                case 4:
                    System.out.println("Número da conta é: " + conta.getNumConta());
                    System.out.println("Titular: " + conta.getTitular());
                    System.out.println("Saldo: " + conta.getSaldo());
                    System.out.println("Tipo de Conta: " + conta.getTipoConta());
                    System.out.println("Status da conta: " + conta.isStatus());
                    conta.fecharConta();
                    break;

                default:
                    throw new RuntimeException("Operação Inválida ! ");
            }
        } while (operacao != 4);
        sc.close();
    }
}