package com.sfeir.bytecode.model;

/**
 * Date: 19/09/12
 *
 * @author François LAROCHE
 */
public class BuildedClass2 {

    private final String field;

    public BuildedClass2(Builder builder) {
        this.field = builder.field;
    }

    public static class Builder {
        String field;

        public Builder field(String field) {
            this.field = field;
            return this;
        }
    }


}
