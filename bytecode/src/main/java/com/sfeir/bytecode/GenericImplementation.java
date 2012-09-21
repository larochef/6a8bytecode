package com.sfeir.bytecode;

/**
 * Date: 19/09/12
 *
 * @author François LAROCHE
 */
public class GenericImplementation implements GenericInterface<Integer> {

    @Override
    public void doSomething(Integer arg) {
        System.out.println(arg);
    }

}
