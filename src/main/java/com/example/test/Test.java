//package com.example.test;
//
//import org.nfunk.jep.JEP;
//import org.nfunk.jep.Node;
//import org.nfunk.jep.ParseException;
//
//public class Test {
//    public static void main(String[] args) {
//        try {
////            String exp = "((a+b)*(c+b))/(c+a)/b";
//            String exp = "if(A0==\"aaaa\",b,c)";
//            JEP jep = new JEP();
//            jep.addVariable("A0", "aaaa");
//            jep.addVariable("b", 2);
//            jep.addVariable("c", 3);
//            jep.addStandardFunctions();
//            jep.getFunctionTable().put("Count",new Count());
//            Node parse = jep.parse(exp);
//            Object evaluate = jep.evaluate(parse);
//            System.out.println(evaluate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }
//}
