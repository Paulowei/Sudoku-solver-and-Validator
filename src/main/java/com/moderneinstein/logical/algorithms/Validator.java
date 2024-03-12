package com.moderneinstein.logical.algorithms;

import java.util.Arrays ; 
import java.util.Set ; 
import java.util.LinkedList ; 
import java.util.ArrayList ;
import java.util.Queue ; 
import java.util.Map ;
import java.util.TreeMap ; 

import java.util.List ; 

public class Validator {

    public static int  nulls = 0 ; 
    public static char dots = '.' ; 
    public static int draft  = 1 ; 
    public static int theta = 26 ; 
    public static int  shift = 48 ;
    public static double  halfs = 0.5 ; 

    public static int convert(char current){
         int present = (int)(current) ; 
         if(current==dots){return nulls ; }
      //     System.out.println(present); 
        present = present-shift ; 
        //  System.out.println(current); 
        return present ; 
    }
    public static char revert(int current){
        int above = (current+shift) ;
        if(current==nulls){return dots ; }
        char places = (char)above ;
        return places ;   
    }
    public static boolean squares(char[][] present){
        int check = present.length ; 
        int sqrt =  (int)Math.pow(check,halfs) ;  
        int[] point =  new int[]{sqrt,sqrt} ;
        boolean[] signs = new boolean[check+draft] ; 
      //  System.out.println(sqrt) ; 
        for(int cf=0;cf<check;cf+=sqrt){
            for(int fc=0;fc<check;fc+=sqrt) {
                point =  new int[]{fc-fc%sqrt,cf-cf%sqrt}  ;  
                signs = new boolean[check+draft] ;
                for(int rf=0;rf<=sqrt-1;rf++){
                    for( int es=0 ;es<=sqrt-1;es++){
                        int value =  convert(present[cf+rf][fc+es]) ; 
                        if( value==nulls){continue ;  }
                        if(signs[value]==true){return false ; }
                        signs[value] = true ; 
                    }
                }
            }
        }
        return true  ;
    }
    public static boolean validate(char[][] input){
        int  spans = input.length ; 
        boolean[] marks =  new boolean[spans] ;       
        for(int dc=spans-1;dc>=0;dc--){
            marks = new boolean[spans+draft] ; 
            for(int fs=0;fs<spans;fs++){
                int point = convert(input[dc][fs]) ;
                if(point==nulls){continue ;} 
	     	//  System.out.println(point) ;
                if( marks[point]== true){return false ;}
                marks[point] = true ;
            } 
            marks = new boolean[spans+ draft] ; 
            for(int rd=spans-1;rd>=0;rd--){
                int point = convert(input[rd][dc]) ;
                if(point ==nulls){continue ; } 
                if(marks[point]==true){return false ; }
                marks[point] = true ;
            }
        }
        return true&&squares(input) ;
    }
    public static  char[][]  express (int[][] source) {
        int breadth = source[0].length ; 
        char[][]  equiv =  new char[breadth][breadth] ; 
       for(int dc=0 ;dc<breadth;dc++){
           for(int rf=breadth-1;rf>=0;rf--){  
               int check =  source[rf][dc] ; 
               equiv[rf][dc] =  revert(check) ; 
           }
       }
       return  equiv ; 
    }
    public static boolean isValidSudoku(char[][] input){
        int width = input[0].length ;
         int height =  input.length ;
        String nested = Arrays.deepToString(input) ; 
     //   System.out.println(convert('5')) ;  
        boolean verse = validate(input) ; 
        return verse ;
    }

    public static boolean isValidPuzzle(int[][] input) {
         int breadth = input[0].length ; 
         char[][]  equiv =  new char[breadth][breadth] ; 
    //    System.out.println(Arrays.toString(input)) ; 
        for(int dc=0 ;dc<breadth;dc++){
            for(int rf=breadth-1;rf>=0;rf--){  
                int check =  input[rf][dc] ; 
                equiv[rf][dc] =  revert(check) ; 
            }
        }
            boolean cases = validate(equiv) ;
         return cases ;
    }


    }
