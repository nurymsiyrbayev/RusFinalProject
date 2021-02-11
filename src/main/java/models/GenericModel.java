package models;

public class GenericModel {
    private long id;

    public GenericModel() {}

    public GenericModel(long id) {
        setId(id);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id= " + id;
    }
}
