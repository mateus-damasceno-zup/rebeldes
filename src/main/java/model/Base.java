package model;

public class Base {

    private Long id;
    private String nome;
    private Long itensId;
    private Long rebeldeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getItensId() {
        return itensId;
    }

    public void setItensId(Long itensId) {
        this.itensId = itensId;
    }

    public Long getRebeldeId() {
        return rebeldeId;
    }

    public void setRebeldeId(Long rebeldeId) {
        this.rebeldeId = rebeldeId;
    }
}
