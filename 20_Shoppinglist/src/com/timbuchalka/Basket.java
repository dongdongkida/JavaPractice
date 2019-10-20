package com.timbuchalka;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by dev on 17/02/2016.
 */
public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new LinkedHashMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(item, 0);
            if(quantity<= item.availableQuantity()) {
                list.put(item, inBasket + quantity);
                item.reserveStock(quantity);
                return inBasket;
            } else {
                System.out.println(item.getName() + " Only left " + item.availableQuantity() + " in stock right now.");
            }
        }
        System.out.println("The item you looking for is not available in stock right now.");
        return 0;
    }

    public int removeFromBasket (StockItem item, int quantity) {
        if((item != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(item, 0);
            if(inBasket == 0) {
                System.out.println("Item not found in your Shopping List.");
            } else if (inBasket > quantity) {
                list.put(item, inBasket - quantity);
                item.unreserveStock(quantity);
                return inBasket;
            } else {
                list.remove(item);
                item.unreserveStock(inBasket);
            }
        }
        return 0;
    }

    public void checkOut(Basket basket) {
        System.out.println("Thanks for shopping with us");
        System.out.println(basket);
        for(Map.Entry<StockItem, Integer> item : list.entrySet()) {
            item.getKey().finaliseStock(item.getValue());
        }
        list.clear();
    }

    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + list.size() + ((list.size() == 1) ? " item" : " items") + "\n";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s = s + item.getKey() + ".\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost " + totalCost;
    }
}
