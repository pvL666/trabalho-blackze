package banco;

import java.util.ArrayList;
import java.util.Scanner;

public class ControlaBanco {

    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Conta> contas = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public boolean cadastraCliente() {
        System.out.println("Insira o nome: ");
        String nome = sc.nextLine();

        System.out.println("Insira o cpf: ");
        Integer cpf = sc.nextInt();
        
        if (clientes.stream().anyMatch(cliente -> cliente.getCpf().equals(cpf))) {
            System.out.println("CPF já está cadastrado no sistema!");
            return false;
        }

        System.out.println("Insira a profissao: ");
        String profissao = sc.next();
        sc.nextLine();

        clientes.add(new Cliente(nome, cpf, profissao));
        return true;
    }

    public boolean cadastraConta() {
        System.out.println("Insira a agencia: ");
        Integer agencia = sc.nextInt();

        System.out.println("Insira o numero da conta: ");
        Integer numero = sc.nextInt();

        System.out.println("Insira o CPF: ");
        Integer cpf = sc.nextInt();

        Cliente cliente = clientes.stream()
                .filter(c -> c.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);

        if (cliente == null) {
            System.out.println("O CPF não está cadastrado no sistema!");
            System.out.println("");
            return false;
        }

        contas.add(new Conta(agencia, numero, cliente));
        return true;
    }

    public boolean realizarDeposito() {
        System.out.println("Insira o número da conta: ");
        Integer numConta = sc.nextInt();

        System.out.println("Insira o valor do depósito: ");
        Double valorDeposito = sc.nextDouble();

        if (!contas.stream().anyMatch(conta -> conta.getNumero().equals(numConta)) || valorDeposito <= 0) {
            System.out.println("Conta inexistente!");
            System.out.println("");
            return false;
        }

        Conta contaDeposito = contas.stream()
                .filter(conta -> conta.getNumero().equals(numConta))
                .findFirst()
                .orElse(null);

        contaDeposito.adicionarSaldo(valorDeposito);
        System.out.println("Conta de " + contaDeposito.getCliente().getName()
                + " - Saldo Atualizado: " + contaDeposito.getSaldo() + " reais");
        System.out.println("");

        return true;
    }

    public boolean transferirSaldo() {
        System.out.println("Insira o número da conta de origem: ");
        Integer numContaOrigem = sc.nextInt();
        System.out.println("Insira o número da conta de destino: ");
        Integer numContaDestino = sc.nextInt();
        System.out.println("Insura o valor da transferencia: ");
        Double valor = sc.nextDouble();

        Conta contaOrigem = contas.stream()
                .filter(conta -> conta.getNumero().equals(numContaOrigem))
                .findFirst()
                .orElse(null);
        Conta contaDestino = contas.stream()
                .filter(conta -> conta.getNumero().equals(numContaDestino))
                .findFirst()
                .orElse(null);

        if (contaOrigem == null || contaDestino == null) {
            return false;
        } else if (contaOrigem.getSaldo() < valor) {
            System.out.println("Saldo insuficiente para realizar a transferência!");
            System.out.println("");
            return false;
        }

        contaOrigem.removerSaldo(valor);
        contaDestino.adicionarSaldo(valor);

        System.out.println("Conta de " + contaOrigem.getCliente().getName()
                + " - Saldo Atualizado: " + contaOrigem.getSaldo() + " reais");
        System.out.println("Conta de " + contaDestino.getCliente().getName()
                + " - Saldo Atualizado: " + contaDestino.getSaldo() + " reais");
        System.out.println("");

        return true;
    }

    public void verificarSaldo() {
        System.out.println("Insira o número da conta: ");
        Integer numeroDaConta = sc.nextInt();

        Conta conta = contas.stream()
                .filter(c -> c.getNumero().equals(numeroDaConta))
                .findFirst()
                .orElse(null);

        if (conta == null) {
            System.out.println("Conta inexistente!");
            System.out.println("");
            return;
        }

        System.out.println("Conta de " + conta.getCliente().getName() + " - Saldo: " + conta.getSaldo() + " reais");
        System.out.println("");
    }

    public void exibirNomeClientes() {
        clientes.stream().forEach(cliente -> System.out.println(cliente.getName()));
    }

}
