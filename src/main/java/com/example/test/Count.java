package com.example.test;

import ch.qos.logback.core.boolex.EvaluationException;
import org.nfunk.jep.JEP;
import org.nfunk.jep.ParseException;
import org.nfunk.jep.function.Add;
import org.nfunk.jep.function.PostfixMathCommand;

import java.util.Stack;

public class Count extends PostfixMathCommand {
    protected String name;

    public Count() {
        this.numberOfParameters = -1;
    }

    @Override
    public void run(Stack inStack) throws ParseException{
        //检查堆栈
        checkStack(inStack);
        int count =0;
        while (!inStack.empty()){
            inStack.pop();
            count++;
        }
        inStack.push(count);
    }
}
