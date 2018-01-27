package com.johnmorris;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();
    public static void main(String[] args) {
	    StockItem temp = new StockItem("Bread", 1.27, 46);
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
        System.out.println(johnsBasket);
        System.out.println(stockList);

        for(Map.Entry<String, Double> price: stockList.PriceList().entrySet()) {
            System.out.println(price.getKey() + " costs " + price.getValue());
        }
    }
    public static int sellItem(Basket basket, String item, int quantity) {
        //retrieve item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("\nSorry but the " + item +" is not available at this time" );
            return 0;
        }
        if(stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }
}
