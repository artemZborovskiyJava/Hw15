package com.javahw;

import java.util.ArrayList;

public class Backpack {
    private int maxWeight;
    private int bestPrice;
    private ArrayList<Item> bestItems = null;

    public Backpack(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    private int calculateWeight(ArrayList<Item> items) {
        int sumWeight = 0;

        for(Item item : items) {
            sumWeight += item.getWeight();
        }

        return sumWeight;
    }

    private int calculatePrice(ArrayList<Item> items) {
        int sumPrice = 0;

        for(Item item : items) {
            sumPrice += item.getPrice();
        }

        return sumPrice;
    }

    private void checkSet(ArrayList<Item> items) {
        if(bestItems == null) {
            if(calculateWeight(items) <= maxWeight) {
                bestItems = items;
                bestPrice = calculatePrice(items);
            }
        } else {
            if(calculateWeight(items) <= maxWeight && calculatePrice(items) > bestPrice) {
                bestItems = items;
                bestPrice = calculatePrice(items);
            }
        }
    }

    public void makeAllSets(ArrayList<Item> items) {
        if(items.size() > 0) {
            checkSet(items);
        }

        for(int i = 0; i < items.size(); i++) {
            ArrayList<Item> newSet = new ArrayList<Item>(items);
            newSet.remove(i);
            makeAllSets(newSet);
        }
    }

    public ArrayList<Item> getBestSet() {
        return bestItems;
    }
}