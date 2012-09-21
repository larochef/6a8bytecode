package com.sfeir.bytecode;

import com.google.common.collect.Lists;
import com.sfeir.bytecode.model.Item;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Date: 14/09/12
 *
 * @author François LAROCHE
 */
public class ItemHelperTest {

    @Test
    public void testNullOrEmptyParameters() {
        Assert.assertNull(ItemHelper.findItem(null, ""));
        Assert.assertNull(ItemHelper.findItem(Lists.<Item>newArrayList(), null));
        Assert.assertNull(ItemHelper.findItem(Lists.<Item>newArrayList(), "test"));
        Assert.assertNull(ItemHelper.findItem(Lists.newArrayList(new Item("", "")), "test"));
    }

    @Test
    public void testNormalExecution() {
        Item item = new Item("code", "label");
        Assert.assertEquals(
                ItemHelper.findItem(
                        Lists.newArrayList(item),
                        "code"),
                item);
    }

    @Test
    public void testPrinter() {
        ItemHelper.printItem(new Item("code", "label"));
    }
}
