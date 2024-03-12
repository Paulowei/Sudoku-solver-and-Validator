package com.moderneinstein.logical.algorithms ;


import java.util.Map ;
import java.util.Vector ;
import java.util.Arrays ;
import java.lang.reflect.Array  ; 
import java.util.TreeMap ; 
import java.util.List ; 
import java.util.Vector ; 
import java.util.Set ; 
import  java.util.ArrayList ; 

public class  Solver {
    public static  char dots = '.' ; 
    public static List<Integer> serial ;
    public static Map<Integer,boolean[]> store ;
    public static int nulls = 0 ; 
    public static int space = 48 ; 
    public static int rootX ; 
    public static int rootY ;
    public static double half  = 0.5 ; 
    public static boolean[] sample  ;
    public static int convert(char begin){
        if(begin==dots)
        {return nulls ; }
        int data = (int)begin-space ;
        return data ; 
    }
    public static char revert(int crease){
        if(crease==nulls){return dots ; }
        int higher = crease+space ;
        char check = (char)higher  ; 
        return check ;
    } 
    public static int single(boolean[] buffer){
        int drift = 0  ; 
        int amount =  buffer.length ; 
        int post = 0; 
        for(int fc=1;fc<10;fc++){
            boolean parts =  buffer[fc] ;
            if(parts==true){amount= amount+1 ;post =fc ; }
        }
        if(amount>1){return nulls ;}
        return post ;
    }
    public static boolean align(int posX,int posY,int check,boolean[] brace,char[][] names){
        int verse = names[0].length  ; 
        int[] shift = new int[]{posX%rootX,posY%rootY} ; 
        for(int fs=verse-1;fs>=0;fs--){
            int verts= convert(names[fs][posX]) ; 
            int horts = convert(names[posY][fs]) ;
            brace[horts] = false ; 
            brace[verts] = false ; 
            if(verts==check){return false ;}
            if(horts==check){return false ;}
        }
        int[] point = new int[]{posX-shift[0],posY-shift[1]} ;
        for(int  vc=0;vc<rootX;vc+=1){
            for(int rc=0;rc<rootY;rc+=1  ){
                int boxes = convert(names[point[1]+ rc][point[0]+vc]) ;
                brace[boxes] = false ;
                if(convert(names[point[1]+rc][point[0]+vc])
                ==check) {return false ;}     }        }
        return true ;    }
    public static boolean append(int current,List<Integer> frames,char[][] buffer) {
        if(current>=frames.size()){
            return true ; 
        }
        int point = frames.get(current) ;
        int stateX = point%buffer.length ; 
        int stateY = point/buffer.length ; 
        boolean[] chance = store.get(point) ; 
        for(int dc=1;dc<chance.length;dc++){
            if(chance[dc]==true){
                if(align(stateX,stateY,dc,sample,buffer)){
                    buffer[stateY][stateX]= revert(dc)  ;
                    boolean check =  append(current+1,frames , buffer) ;
                    if(check==true){return true ;}
                    buffer[stateY][stateX] = dots ;
                }
            }
        }
        return false ;
    }
    public static int collect(char[][] nested,boolean mode){
        int draft = nested[0].length ; 
        boolean[] signs= new boolean[draft+1] ; 
        int gains = 0 ; 
        for(int cs=draft-1;cs>=0;cs--){
            for(int ds=0;ds<draft;ds++){
               signs =  new boolean[draft+1] ; 
               for(int fs=draft;fs>=0;fs--){signs[fs] = true ;}
               if(nested[ds][cs]!=dots){ continue ;} 
                int[] verse = new int[]{ds-ds%rootY,cs-cs%rootX} ; 
                for(int cd=0;cd<rootX;cd++){
                    for(int fr=0;fr<rootY;fr++){
                        signs[convert(nested[fr+verse[0]][cd+verse[1]])]=false; }  }
                for(int gc=0;gc<rootY;gc++){
                    signs[convert(nested[ds][gc])]=false ;
                    signs[convert(nested[gc][cs])] = false ;    }
                int data = single(signs) ;
                nested[ds][cs] = revert(data);
                if(nested[ds][cs]!=dots){gains= gains+1; }
            } 
        }
        return gains ;
    }
    //   else{if(mode==true){store.put(ds*draft+cs,signs) ; } }
    public static void insert(List<Integer>  holder,char[][] arrays){
        int length = arrays[0].length ; 
        for(int fc=0 ;fc<length ;fc++){
            for( int gd=length-1;gd>=0;gd--){
                char current= arrays[fc][gd] ; 
                int potent =  gd+fc*length ;
                if(current==dots){
                    holder.add(potent) ; 
                    boolean[] names = new boolean[length+1] ; 
                    Arrays.fill(names,true) ; 
                    boolean notice = align(gd,fc,nulls-1,names,arrays) ;
                    store.put(potent,names) ; 
                }
            }
        }
    }
    public static boolean solveSudoku(char[][] board) {
        serial = new ArrayList<Integer>( ) ; 
        store = new TreeMap<Integer,boolean[]>() ;
        int range = board[0 ].length ; 
        rootX =  (int)Math.pow(range,half)  ;
        rootY =  (int)Math.pow(range,half)  ;
        int yield = range ; 
        sample = new boolean[range+1] ; 
        while(yield>0){
            yield = collect(board,false ) ;
        }
       // Source.outer.println (Arrays.deepToString(board)) ; 
    //    collect(board,true) ;
        insert(serial,board ) ; 
        boolean states = append(0,serial,board) ;  
       // System.out.println (Arrays.deepToString(board)) ; 
        return  states ; 
    }
    public static boolean  solvePuzzle(int[][] source) {
         int brace = source.length ; 
         char[][]   crest =  new char[brace][brace] ; 
         crest =  Utility.revert(source) ; 
        boolean cases =   solveSudoku(crest) ; 
        for(int fc=brace-1 ;fc>=0;fc--){
            for(int er=brace-1;er>=0;er--){
                int notes =  convert(crest[er][fc]) ; 
                source[er][fc] = notes ; 
            }
        }   
        return cases  ; 
    }
}