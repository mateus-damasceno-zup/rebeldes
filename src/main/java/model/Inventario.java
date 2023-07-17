package model;

public class Inventario {

    private Long id;
    private Long rebeldeId;
    private Long itemId;

    public Inventario(Long idInventario, Long idRebelde, Long idItem) {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRebeldeId() {
        return rebeldeId;
    }

    public void setRebeldeId(Long rebeldeId) {
        this.rebeldeId = rebeldeId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return String.valueOf(id+ rebeldeId + itemId);
    }
}
