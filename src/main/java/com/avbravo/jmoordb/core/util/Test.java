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
    
}
