package com.johnmorris;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();
    public static void main(String[] args) {
	    StockItem temp = new StockItem("Bread", 1.27, 200);
	    stockList.addStock(temp);

	    temp = new StockItem("Quarters", 1.16, 500);
	    stockList.addStock(temp);

        temp = new StockItem("Chili", 1.25, 24);
        stockList.addStock(temp);

        temp = new StockItem("Salt", .16, 24);
        stockList.addStock(temp);
        temp = new StockItem("Salt", .25, 12);
        stockList.addStock(temp);

        temp = new StockItem("Cheese, Shredded", 6.25, 40);
        stockList.addStock(temp);

        temp = new StockItem("Tea, Iced", .47, 97);
        stockList.addStock(temp);

        temp = new StockItem("Coffee, Ground", .37, 250);
        stockList.addStock(temp);

        System.out.println(stockList);

        Basket johnsBasket = new Basket("John");
        sellItem(johnsBasket, "Chili", 5);
        sellItem(johnsBasket, "Bread", 30);
        sellItem(johnsBasket, "Salt", 12);
        //System.out.println(johnsBasket);
        sellItem(johnsBasket, "Spanner", 1);
        //System.out.println(johnsBasket);
        //System.out.println(stockList);

        //Test Remove Method
        removeItem(johnsBasket, "Chili", 2);
        System.out.println(johnsBasket);

        Basket customer1 = new Basket("Customer #1");
        sellItem(customer1, "Salt", 15);
        sellItem(customer1, "Bread", 45);
        System.out.println(customer1);


        checkOut(johnsBasket);
        System.out.println(johnsBasket);
        checkOut(customer1);
        System.out.println(customer1);
//        for(Map.Entry<String, Double> price: stockList.PriceList().entrySet()) {
//            System.out.println(price.getKey() + " costs " + price.getValue());
//        }
    }
    public static int sellItem(Basket basket, String item, int quantity) {
        //retrieve item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("\nSorry but the " + item +" is not available at this time" );
            return 0;
        }
        if(stockList.reservedStock(item, quantity) != 0) {
            return basket.addToBasket(stockItem, quantity);
        }
        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity) {
        //retrieve item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("\nSorry but the " + item +" is not available at this time" );
            return 0;
        }
        if(basket.removeFromBasket(stockItem, quantity) == quantity) {
            return stockList.unreserveStock(item, quantity);
        }
        return 0;
    }

    public static void checkOut(Basket basket) {
        for(Map.Entry<StockItem, Integer> item : basket.Items().entrySet()) {
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }
}
