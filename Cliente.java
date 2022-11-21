package banco;

public class Cliente {

    private String name;
    private Integer cpf;
    private String profissao;

    public Cliente(String name, Integer cpf, String profissao) {
        this.name = name;
        this.cpf = cpf;
        this.profissao = profissao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

}
