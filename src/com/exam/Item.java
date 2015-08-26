package com.exam;
/**
 * Represents a part or service that can be sold.
 *
 * care should be taken to ensure that this class is immutable since it
 * is sent to other systems for processing that should not be able to
 * change it in any way.
 *
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Exams are us</p>
 * @author Joe Blow
 * @version 1.0
 */
public final class Item
{
    public enum TYPE{
        SERVICE,MATERIAL;
    }
    private final Integer key;
    private final String name;
    private final float price;
    private final TYPE itemType;
    public Item(Integer key, String name, float price, TYPE itemType)
    {
        this.key = key;
        this.name = name;
        this.price = price;
        this.itemType = itemType;
    }

    public Integer getKey()
    {
        return key;
    }
    public String getName()
    {
        return name;
    }
    public float getPrice()
    {
        return price;
    }

    public TYPE getItemType() {
        return itemType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        Item item = (Item) o;

        if (!key.equals(item.key)) return false;
        if (!name.equals(item.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = key.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "key=" + key +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}