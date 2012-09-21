package com.sfeir.bytecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 19/09/12
 *
 * @author François LAROCHE
 */
public class Loops {
    public void forLoop() {
        for(int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    public void foreachLoop() {
        List<Integer> integers = new ArrayList<Integer>(10);
        integers.add(0);
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);

        for(Integer myInt : integers) {
            System.out.println(myInt);
        }
    }

    public void whileLoops() {
        int i = 0;
        while(i < 10) {
            i++;
        }
    }
}
