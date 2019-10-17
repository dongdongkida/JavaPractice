package com.timbuchalka;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
	    StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);

//        temp = new StockItem("door", 72.95, 4);
//        stockList.addStock(temp);
//
//        temp = new StockItem("juice", 2.50, 36);
//        stockList.addStock(temp);
//
//        temp = new StockItem("phone", 96.99, 35);
//        stockList.addStock(temp);
//
//        temp = new StockItem("towel", 2.40, 80);
//        stockList.addStock(temp);
//
//        temp = new StockItem("vase", 8.76, 40);
//        stockList.addStock(temp);

        System.out.println(stockList);

        for(String s: stockList.Items().keySet()) {
            System.out.println(stockList.Items().get(s));
        }

        Basket dongsBasket = new Basket("Dong");
        addToBasket(dongsBasket, "car", 1);
        System.out.println(dongsBasket);

        addToBasket(dongsBasket, "car", 1);
        System.out.println(dongsBasket);

        addToBasket(dongsBasket,"cup", 50);

        removeFromBasket(dongsBasket,"cup", 40);

        if(addToBasket(dongsBasket, "car", 1) != 1) {
            System.out.println("There are no more cars in stock");
        }
        removeFromBasket(dongsBasket,"car", 2);
        addToBasket(dongsBasket, "spanner", 5);
        System.out.println(dongsBasket);

        checkOut(dongsBasket);

        System.out.println(dongsBasket);

//        sellItem(dongsBasket, "juice", 4);
//        sellItem(dongsBasket, "cup", 12);
//        sellItem(dongsBasket, "bread", 1);
//        System.out.println(dongsBasket);

        System.out.println(stockList);

//        temp = new StockItem("pen", 1.12);
//        stockList.Items().put(temp.getName(), temp);
        stockList.Items().get("car").adjustStock(2000);
        stockList.Items().get("car").adjustStock(-1000);
        System.out.println(stockList);
        for(Map.Entry<String, Double> price: stockList.PriceList().entrySet()) {
            System.out.println(price.getKey() + " costs " + price.getValue());
        }



    }

//    public static int sellItem(Basket basket, String item, int quantity) {
//        // retrieve the item from stock list
//        StockItem stockItem = stockList.get(item);
//        if(stockItem == null) {
//            System.out.println("We don't sell " + item);
//            return 0;
//        }
//        if(stockList.sellStock(item, quantity) != 0) {
//            basket.addToBasket(stockItem, quantity);
//            return quantity;
//        }
//        return 0;
//    }
    public static int addToBasket(Basket basket, String item, int quantity){
        basket.addToBasket(stockList.Items().getOrDefault(item, null), quantity);
        return quantity;
    }

    public static int removeFromBasket(Basket basket, String item, int quantity) {
        basket.removeFromBasket(stockList.Items().get(item), quantity);
        return stockList.addStock(stockList.Items().get(item));
    }

    public static void checkOut(Basket basket) {

        basket.checkOut(basket);
        System.out.println(stockList);
    }
}
