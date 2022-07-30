package reddit.clone.model.dto;

public class BaseEntityDTO {

    private Long id;
    private boolean field;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isField() {
        return field;
    }

    public void setField(boolean field) {
        this.field = field;
    }

}
