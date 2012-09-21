package com.sfeir.bytecode.model;

/**
 * Date: 19/09/12
 *
 * @author François LAROCHE
 */
public enum EnumWithField {
    OBJECT("Object");

    public final String value;

    private EnumWithField(String value) {
        this.value = value;
    }
}
