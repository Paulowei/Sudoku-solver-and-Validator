package com.moderneinstein.logical.algorithms ;

/**
 * Hello world!
 *
 */

 import  java.util.Arrays ; 
 import java.lang.reflect.Array ; 
import java.io.PrintStream ; 
import  java.util.ArrayList ; 
import java.util.LinkedList  ;
import  java.io.InputStreamReader  ; 
import java.io.BufferedReader ; 
import java.io.FileInputStream ; 
import java.io.Reader  ; 
import java.io.StringReader ; 
import java.util.function.Consumer ; 
import java.util.Map ;
import  java.util.TreeMap ; 
import java.util.function.Function ; 
import java.io.File  ;
 import java.util.List ;

public class  Source 
{
    public static char comma = ',' ; 
    public static char lines =  '\n'; 
    public static char space = ' ' ; 
    public static char left = '[' ; 
    public static char right  = ']'  ; 
    public static Map<String,Function<Object,Object>> articles ; 
    public static Consumer<Void>[]  workers = new Consumer[]{}  ; 
    public  static String[] marks =  new String[]{"File","Terminal","Validate","Solve"} ; 
    public  static Function<Object,Object>[] functions = 
     new Function[]{Source::readFile,Source::readTerminal,Source::validate,Source::solve}  ;  
    public  static PrintStream outer = System.out ; 
    public static  char  verse = '.'  ;
    public static  Object solve(Object nests){ 
 	  int[][] buffer =  (int[][]) nests ;   
            char[][]  verses = Utility.revert (buffer) ; 
            Solver.solvePuzzle(buffer) ; 
            int[][] news = Utility.restate(verses) ; 
            news = buffer ; 
	        outer.append(Arrays.deepToString(news))  ; 
            if(Validator.isValidPuzzle(news)){return news; }
            else{return news ; } 
    }
            //  outer.println (44)  ;  
            //   return news ; 
    public static Object validate(Object grace ){
	int[][]  arrays  =   (int[][])grace ; 
        char[][] energy =  Utility.revert(arrays) ;
        outer.append(Arrays.toString(energy)).append(space) ;  ; 
        if(Validator.isValidSudoku(energy)){
            return Boolean.valueOf(true) ; 
        } else{
            return Boolean.valueOf(false) ; 
        }
    }
    public static Object  readTerminal(Object bytes) { 	
	try{
	 String input =  (String)bytes ;
        String viable =  new String("") ; 
        StringReader stream =   new StringReader(input) ; 
        BufferedReader buffered = new BufferedReader(stream) ; 
        while(true){
            String quest = buffered.readLine() ; 
            if(quest==null){break ;}
            viable  = viable.concat(quest) ;    }
        return  viable  ;
	}catch(Exception spaces){ return null ;  }	
    }
    public static Object  readFile  (Object enter){ 
	try{
	String input =  (String)enter ;  
        File source = new File(input) ; 
        FileInputStream  stream  = new FileInputStream(source) ;
        String  frames = Utility.readStream(stream)  ; 
        return frames ; 
	}catch(Exception except){return null ; }
    }
    public static void configure(){ 
        int above =  functions.length ; 
        int below =  marks.length ; 
        int cents = Math.min(below,above) ; 
        for(int rc=0;rc<cents;rc++){  
            Function<Object,Object>  function = functions[rc] ; 
            String words = marks[rc] ; 
            articles.put(words,function) ; 
        }
    }
    public static Object parseArgs(String[] args){
        String notes = args[0] ;  
        String operand = args[1] ; 
        if(articles.containsKey(notes)){
            Function<Object,Object> operator = articles.get(notes) ;
            Object result =  operator.apply((Object)operand) ; 
            return result ;
        }
        return operand ; 
    }



    public static void main( String[] args ) throws Exception {
      //  System.out.println( "Hello World!" );
    articles = new TreeMap<String,Function<Object,Object>>() ;
    configure() ; 
    Object  crest = parseArgs(args) ; 
    String determine = (String)(crest ) ;
  //  outer.println(determine) ;
   List<List<Integer>> serial = Utility.convert(determine,verse,comma) ; 
   outer.append("The given puzzle was : ") ;  
   outer.println(serial.toString()) ;
//	outer.println(serial) ; 
	//outer.println(determine) ; 
    int[][] chunks = Utility.convert(serial) ; 
    Function<Object,Object> quests =  articles.get(args[2]) ; 
    Object result =  quests.apply(chunks) ; 
    // outer.println( result.toString()) ;  
     }
}
