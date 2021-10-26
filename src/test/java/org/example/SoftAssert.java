package org.example;

import org.opentest4j.AssertionFailedError;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class SoftAssert {
    ArrayList<String> assertsContainer;
    boolean haveFailed;
    public SoftAssert(){
        assertsContainer = new ArrayList<String>();
        haveFailed = false;
    }
    public void AssertEquals(Object real,Object finded, String nameTest){
        if(real.equals(finded)){
            assertsContainer.add(nameTest + " Passed\n");
        }
        else{
            assertsContainer.add(nameTest + " Failed "+"expected: "+real.toString()+" finded: "+finded.toString()+"\n");
            haveFailed = true;
        }
    }
    public void AssertAll(){
        try {
            if (haveFailed) throw new AssertionFailedError("Assert was failed:\n"+ assertsContainer);
        } catch(Exception e){
            System.err.println(e.getMessage());
            return;
        }
        System.out.print(assertsContainer);
    }
}
