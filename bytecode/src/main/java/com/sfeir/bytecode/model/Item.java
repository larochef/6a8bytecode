package com.sfeir.bytecode.model;

import com.google.common.base.Preconditions;

/**
 * Simple class : a label and a code.
 * <br />
 * Date: 14/09/12
 *
 * @author François LAROCHE
 */
public class Item {

    private final String code;
    private final String label;

    public Item(String code, String label) {
        this.code = Preconditions.checkNotNull(code);
        this.label = Preconditions.checkNotNull(label);
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }
}
