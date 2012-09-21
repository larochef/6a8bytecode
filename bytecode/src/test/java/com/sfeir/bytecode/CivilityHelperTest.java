package com.sfeir.bytecode;

import com.sfeir.bytecode.model.Civility;
import junit.framework.Assert;
import org.testng.annotations.Test;

/**
 * Date: 14/09/12
 *
 * @author François LAROCHE
 */
public class CivilityHelperTest {

    @Test
    public void testCivilities() {
        Assert.assertNull(CivilityHelper.isGeek(null));
        Assert.assertEquals(CivilityHelper.isGeek(Civility.MLLE), "I fear she isn't, but maybe her sister... ;)");
        Assert.assertEquals(CivilityHelper.isGeek(Civility.MME), "Married & geek ? Wow !");
        Assert.assertEquals(CivilityHelper.isGeek(Civility.MR), "To be or not to be (a geek), that is the question");
    }

}
