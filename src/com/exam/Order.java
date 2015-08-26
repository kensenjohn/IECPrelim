package com.exam;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

/**
 * Represents and Order that contains a collection of items.
 *
 * care should be taken to ensure that this class is immutable since it
 * is sent to other systems for processing that should not be able
 * to change it in any way.
 *
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Exams are us</p>
 * @author Joe Blow
 * @version 1.0
 */
public final class Order implements Serializable
{
    private final List<OrderItem> orderItems;
    public Order(List<OrderItem> orderItems)
    {
        this. orderItems =  Collections.unmodifiableList(orderItems);
    }
    // Returns the total order cost after the tax has been applied
    public float getOrderTotal(float taxRate)
    {
        float orderTotal = 0.00f;
        BigDecimal orderTotalTracker = new BigDecimal( orderTotal );
        for(OrderItem orderItem : orderItems){
            Item item = orderItem.getItem();

            BigDecimal itemPrice = new BigDecimal( (item.getPrice() * orderItem.getQuantity()) );

            if( item.getItemType() == Item.TYPE.MATERIAL) {
                itemPrice = itemPrice.add(itemPrice.multiply(new BigDecimal(taxRate/100)));
            }

            orderTotalTracker = orderTotalTracker.add(  itemPrice  );
        }
        orderTotalTracker = orderTotalTracker.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        System.out.println("Total : " + orderTotalTracker);

        return orderTotalTracker.floatValue();
    }
    /**
     * Returns a Collection of all items sorted by item name
     * (case-insensitive).
     *
     * @return Collection
     */
    public Collection getItems()
    {
        Collection arrItems = new ArrayList<Item>();
        for(OrderItem orderItem : orderItems){
            arrItems.add( orderItem.getItem() );
        }
        Collections.sort((List<Item>) arrItems, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                Item item1 = (Item)o1;
                Item item2 = (Item)o2;
                return item1.getName().toLowerCase().toString().compareTo(item2.getName().toLowerCase().toString());
            }
        });
        return arrItems;
    }

    private static final long serialVersionUID = 7526471155622776147L;

    public static void main(String[] args) {
        Item item1 = new Item(1, "bb", 20.0234f, Item.TYPE.MATERIAL);
        Item item2 = new Item(2, "aa", 30.0123f, Item.TYPE.MATERIAL);

        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        orderItems.add( new OrderItem(item1,2) );
       // orderItems.add( new OrderItem(item2,1) );

        Order order = new Order(orderItems);
        System.out.println(order.getOrderTotal(8.25f));
        System.out.println( order.getItems() );


    }
}