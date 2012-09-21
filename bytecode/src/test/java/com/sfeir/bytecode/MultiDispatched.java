package com.sfeir.bytecode;

import com.sfeir.bytecode.multidispatch.MultiDispatch;

/**
 * TODO : explain.me
 * Date: 20/09/12
 * Time: 20:17
 *
 * @author françois LAROCHE
 */
public class MultiDispatched {

    public void doSomething(Integer arg) {
        System.out.println("Done from integer");
    }

    @MultiDispatch
    public void doSomething(Object arg) {
        System.out.println("Done from object");
    }
}
