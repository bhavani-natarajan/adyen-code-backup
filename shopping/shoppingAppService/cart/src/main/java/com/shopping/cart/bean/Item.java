package com.shopping.cart.bean;


import java.util.Objects;


/**
 * Item
 */
public class Item {

    private String id = null;

    private String name = null;

    public Item id(String id) {
        this.id = id;
        return this;
    }


    /**
     * The value to provide in the result.
     *
     * @return id
     **/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Item name(String name) {
        this.name = name;
        return this;
    }


    /**
     * The display name.
     *
     * @return name
     **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(this.id, item.id) &&
                Objects.equals(this.name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Item {\n");

        sb.append("    id: ").append(id).append("\n");
        sb.append("    name: ").append(name).append("\n");
        sb.append("}");
        return sb.toString();
    }




}



