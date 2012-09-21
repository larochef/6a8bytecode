package com.sfeir.bytecode;

import com.sfeir.bytecode.model.Item;

import java.util.Collection;

/**
 * Date: 14/09/12
 *
 * @author François LAROCHE
 */
public final class ItemHelper {
    private ItemHelper() {}

    public static Item findItem(Collection<Item> items, String code) {
        if(code == null || items == null) {
            return null;
        }
        for(Item item : items) {
            if(code.equalsIgnoreCase(item.getCode())) {
                return item;
            }
        }
        return null;
    }


    public static void printItem(Item item) {
        System.out.println(0 + "Look at this item :");
        System.out.println(1 + "\t the code is :" + item.getCode());
        System.out.println(2 + "\t the label is :" + item.getLabel());
        System.out.println(3 + "\t the regulat toString is :" + item);
    }
}
