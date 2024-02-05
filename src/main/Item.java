package main;

public class Item {

    protected String id;

    public Item(String id) {
        this.id = id.toLowerCase();
    }

    // Getter for id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id.toLowerCase();
    }

    @Override
    public String toString() {
        return id;
    }
}
