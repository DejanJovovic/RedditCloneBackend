package src.main.java.reddit.clone.model.domain;

public abstract class BaseEntity{
    private Long id;
    private boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isField() {
        return deleted;
    }

    public void setField(boolean deleted) {
        this.deleted = deleted;
    }

}
