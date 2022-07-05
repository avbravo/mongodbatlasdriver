/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordb.core.util;

/**
 *
 * @author avbravo
 */
public class Test {
    public static void msg(String message){
        System.out.println("    [ "+message+"]");
    }
    public static void msgTab(String message){
        System.out.println("          [ "+message+"]");
    }
    public static void warning(String message){
        System.out.println(".....................Advertencia.............................");
        System.out.println("");
        System.out.println("          [ "+message+"]");
        System.out.println("");
        System.out.println("..............................................................");
    }
    public static void box(String message){
        System.out.println("_______________________________________");
        System.out.println("[ "+message+"]");
        System.out.println("_______________________________________");
    }


public static void error(String message){
        System.out.println(".....................Error.............................");
        System.out.println("");
        System.out.println("          [ "+message+"]");
        System.out.println("");
        System.out.println("..............................................................");
    }    


 // <editor-fold defaultstate="collapsed" desc="nameOfClassAndMethod()">
    public static String nameOfClassAndMethod() {
        final StackTraceElement e = Thread.currentThread().getStackTrace()[2];
        final String s = e.getClassName();
        return s.substring(s.lastIndexOf('.') + 1, s.length()) + "." + e.getMethodName();
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="nameOfClass()">

    public static String nameOfClass() {
        final StackTraceElement e = Thread.currentThread().getStackTrace()[2];
        final String s = e.getClassName();
        return s.substring(s.lastIndexOf('.') + 1, s.length());
    }    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="nameOfMethod(">
    public static String nameOfMethod() {
        final StackTraceElement e = Thread.currentThread().getStackTrace()[2];
        final String s = e.getClassName();
        return e.getMethodName();
    }
    // </editor-fold>
}

