package com.javahw;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item(1, 1));
        items.add(new Item(1, 2));
        items.add(new Item(2, 2));
        items.add(new Item(12, 4));
        items.add(new Item(4, 10));

        Backpack backpack = new Backpack(15);
        backpack.makeAllSets(items);
        ArrayList<Item> solve = backpack.getBestSet();

        System.out.println(Arrays.toString(solve.toArray()));
    }
}