package banco;

import java.util.Scanner;

public class Banco {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ControlaBanco controlaBanco = new ControlaBanco();

        int controlador = 1;

        System.out.println("Bem vindo ao Banco Ocnab");

        while (controlador != 0) {
            mostrarMenus();
            controlador = sc.nextInt();

            switch (controlador) {
                case 1:
                    controlaBanco.cadastraCliente();
                    break;
                case 2:
                    controlaBanco.cadastraConta();
                    break;
                case 3: 
                    controlaBanco.realizarDeposito();
                    break;
                case 4:
                    controlaBanco.transferirSaldo();
                    break;
                case 5:
                    controlaBanco.verificarSaldo();
                    break;
                case 6:
                    controlaBanco.exibirNomeClientes();
                case 0:
                    break;
            }
        }

    }

    public static void mostrarMenus() {
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Cadastrar Conta");
        System.out.println("3 - Realizar Depósito");
        System.out.println("4 - Transferir");
        System.out.println("5 - Verificar Saldo");
        System.out.println("6 - Exibir Nome de Todos Clientes");
        System.out.println("0 - Sair do Sistema");
    }

}
