package com.sfeir.bytecode;

import com.sfeir.bytecode.model.Civility;

/**
 * Date: 14/09/12
 *
 * @author François LAROCHE
 */
public final class CivilityHelper {
    private CivilityHelper() {
        // shush
    }

    public static String isGeek(Civility civility) {
        if(civility == null) {
            return null;
        }
        String label = null;
        switch (civility) {
            case MLLE:
                label = "I fear she isn't, but maybe her sister... ;)";
                break;
            case MME:
                label = "Married & geek ? Wow !";
                break;
            case MR:
                label = "To be or not to be (a geek), that is the question";
                break;
        }
        return label;
    }
}
