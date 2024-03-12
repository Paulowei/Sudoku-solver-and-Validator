package com.moderneinstein.logical.algorithms;


import java.util.List ; 
import java.util.ArrayList ; 
import java.util.LinkedList  ; 
import java.util.Vector ; 

import java.io.InputStream ; 
// import java.util.StringStream ; 
import java.io.BufferedReader; 
import java.io.InputStreamReader ; 
 import java.io.IOException ; 
import java.util.Random ; 
import java.util.Iterator ; 


public class Utility {
    
    public static  int share = 48 ;
    public static int  zeros = 0 ; 
    public static char dots = '.' ;   
    public static void  split(String element,List<String> collect,char delim){
        int south = 0 ; 
        int north = 0 ;
        int limit = element.length () ; 
         while(north<limit){
            while(north<limit&&element.charAt(north)!=delim) 
            {north = north+1 ;}
             String brace = element.substring(south,north) ; 
            collect.add(brace) ;
	   // Source.outer.println (brace) ;
            north = north+1 ; 
            south = north ;
         }
    }
    public static int[][] convert (List<List<Integer>> items){
        int  height =  items.size() ; 
        int[][] buffer = new int[height][height]; 
        for( int rv=height-1;rv>=0;rv--){
             for(int er=0;er<height;er++){
                Integer reach = items.get(rv).get(er) ; 
                int collate = reach.intValue() ;
                buffer[rv][er] = collate ;
             }
        }
        return buffer ; 
    }
     //     express = express.substring(1,express.length()) ; 
	//    System.out.println(express) ;
    public static List<List<Integer>> convert(String source,char delim,char choice ){
        int  width = source.length() ; 
        String edits = source.substring(1,width-1).trim() ; 
         List<String>  mains = new ArrayList<String>( ) ; 
        split(edits,mains,delim)  ; 
        List<List<Integer>> contain = new LinkedList<List<Integer>>() ;
        for( int gc=0;gc<mains.size();gc++){
            String express = mains.get(gc).substring(1,mains.get(gc).length()-1).trim( ) ;
            List<String>  surface = new Vector<String>( ) ;  List<Integer> portion = new ArrayList<Integer>() ; 
            split(express,surface,choice)  ;  
            for(int es=0;es<surface.size();es++){
                Integer temps   = Integer.parseInt (surface.get(es).trim() ); 
                portion.add(temps) ;   }
            contain.add(portion) ; 
        }
        return contain  ; 
    } 
  //  String  express = 
  //      String forms =  source.substring(0,width-1) ; 
// 	System.out.println(edits) ;
    public static char[][] revert(int[][] input){ 
        int   crest = input.length  ; 
        char[][] nested = new char[crest][crest] ; 
        for( int sd=crest-1;sd>=0;sd--){
            for(int re=0;re<crest;re++){
                int  present =  input[re][sd] ; 
                char chairs = (char)(present+share) ; 
                if(present==zeros){nested[re][sd] = dots ; continue ; }
                nested[re][sd] = chairs ;
            }
        }
        return nested ;
    } 
    public static int[][] restate(char[][] source){
        int spans = source.length ; 
        int[][] output = new int[spans][spans ] ; 
        for(int fc=0;fc<spans;fc++ ){
            for( int gc=spans-1;gc >=0;gc-- ){
                char  current = source[fc][gc] ; 
                if(current==dots){output[fc][gc] = zeros ;  continue  ; }
                int other =  (int)(current)-share ; 
                output[fc][gc] = other ;
            }
        }
        return output ;     }
    public static String readStream(InputStream stream) throws Exception {
        InputStreamReader input = new InputStreamReader(stream) ;
        BufferedReader reader = new BufferedReader(input)  ; 
        String collate = new String( ) ; 
        while(true){
             String portion = reader.readLine() ; 
             if(portion==null){break ; }
            collate = collate.concat(portion) ; 
        }  
        return collate ; 
    }   
    public static Vector<int[]> correlate(int below,int higher,int width,int height){
        Vector<int[]> listed =new Vector<int[]>() ; 
        Random random = new Random(System.nanoTime()) ; 
        for(int cs=0;cs<height;cs++){
            int[] lanes = new int[width] ; 
            for(int dx=0;dx<width;dx++){
                lanes[dx]=  random.nextInt(below,higher) ; 
            }  
            listed.add( lanes) ; 
        }  
        return listed ; 
    } 
    public static int[][] replicate(int[][] source){ 
        int spread = source[0].length  ; 
        int spans = source.length ;  
        int[][] clone = new int[spans][spread] ;  
        for(int dy=spans-1;dy>=0;dy--){
            for(int dx=spread-1; dx>=0;dx--){
                clone[dy][dx] =  source[dy][dx] ; 
            }
        } 
        return clone  ; 
    } 
    public static <T> List<T>  resolve(int amount,List<T> input){
       List<T> created =new ArrayList<T>()   ;  
        Random spawner = new Random(System.currentTimeMillis()) ; 
         int  sigma = 1 ; 
        while(sigma<=amount){
            int point =  spawner.nextInt(0,input.size())  ; 
            T temps = input.get(point) ;
            input.set(point,input.get(input.size()-1)) ; 
            input.set (input.size()-1,temps)  ;
            input.remove(input.size()-1) ; 
            created.add(temps) ;   
            sigma = sigma + 1 ; 
        } 
        return created  ; 
    }    
    public static int[]  linearize( int lower,int upper){
        int[] lanes = new int[upper-lower+1] ;  
        for(int cs=lower;cs<=upper;cs++){
             lanes[cs-lower] = cs ; 
        } 
        return  lanes ; 
    }
    public static void shuffle(int times,int[] input){
        Vector<int[]> swaps  =  correlate(0,input.length-1,2,input.length) ;
        Iterator<int[]> dynamics =  swaps .iterator(); 
        while(dynamics.hasNext( )){
            int[] types =  dynamics.next() ; 
            int value = input[types[1]]  ;
            input[types[1]] = input[types[0]] ;
            input[types[0]] = value ;  
        } 
    }
}   
