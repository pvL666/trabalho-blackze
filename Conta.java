package banco;

public class Conta {

    Integer agencia;
    Integer numero;
    Cliente cliente;
    Double saldo;

    public Conta(Integer agencia, Integer numero, Cliente cliente) {
        this.agencia = agencia;
        this.numero = numero;
        this.cliente = cliente;
        
        this.saldo = 0.0;
    }

    public void adicionarSaldo(Double valor) {
        saldo += valor;
    }

    public void removerSaldo(Double valor) {
        saldo -= valor;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

}
