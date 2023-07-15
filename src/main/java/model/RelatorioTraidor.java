package model;

public class RelatorioTraidor {
    private Long id;
    private Long rebeldeIdRelator;
    private Long rebeldeIdRelatado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRebeldeIdRelator() {
        return rebeldeIdRelator;
    }

    public void setRebeldeIdRelator(Long rebeldeIdRelator) {
        this.rebeldeIdRelator = rebeldeIdRelator;
    }

    public Long getRebeldeIdRelatado() {
        return rebeldeIdRelatado;
    }

    public void setRebeldeIdRelatado(Long rebeldeIdRelatado) {
        this.rebeldeIdRelatado = rebeldeIdRelatado;
    }
}
