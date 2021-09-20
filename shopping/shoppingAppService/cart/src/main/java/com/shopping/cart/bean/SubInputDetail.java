package com.shopping.cart.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * SubInputDetail
 */
public class SubInputDetail {

    private List<Item> items = null;

    private String key = null;

    private Boolean optional = null;

    private String type = null;

    private String value = null;

    @JsonProperty("Configuration")
    private Map<String, String> configuration;

    public SubInputDetail items(List<Item> items) {
        this.items = items;
        return this;
    }

    public SubInputDetail addItemsItem(Item itemsItem) {

        if (this.items == null) {
            this.items = new ArrayList<>();
        }

        this.items.add(itemsItem);
        return this;
    }

    /**
     * In case of a select, the items to choose from.
     *
     * @return items
     **/
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public SubInputDetail key(String key) {
        this.key = key;
        return this;
    }


    /**
     * The value to provide in the result.
     *
     * @return key
     **/
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public SubInputDetail optional(Boolean optional) {
        this.optional = optional;
        return this;
    }


    /**
     * True if this input is optional to provide.
     *
     * @return optional
     **/
    public Boolean isOptional() {
        return optional;
    }

    public void setOptional(Boolean optional) {
        this.optional = optional;
    }

    public SubInputDetail type(String type) {
        this.type = type;
        return this;
    }


    /**
     * The type of the required input.
     *
     * @return type
     **/
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SubInputDetail value(String value) {
        this.value = value;
        return this;
    }


    /**
     * The value can be pre-filled, if available.
     *
     * @return value
     **/
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * The value can be pre-filled, if available.
     *
     * @return value
     **/
    public Map<String, String> getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Map<String, String> configuration) {
        this.configuration = configuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SubInputDetail subInputDetail = (SubInputDetail) o;
        return Objects.equals(this.items, subInputDetail.items)
                && Objects.equals(this.key, subInputDetail.key)
                && Objects.equals(this.optional, subInputDetail.optional)
                && Objects.equals(this.type,
                                  subInputDetail.type)
                && Objects.equals(this.value, subInputDetail.value)
                && Objects.equals(this.configuration, subInputDetail.configuration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items, key, optional, type, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SubInputDetail {\n");

        sb.append("    items: ").append(items).append("\n");
        sb.append("    key: ").append(key).append("\n");
        sb.append("    optional: ").append(optional).append("\n");
        sb.append("    type: ").append(type).append("\n");
        sb.append("    value: ").append(value).append("\n");
        sb.append("    configuration: ").append(configuration).append("\n");
        sb.append("}");
        return sb.toString();
    }


}



