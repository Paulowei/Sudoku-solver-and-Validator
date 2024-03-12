package com.moderneinstein.logical.algorithms ; 

import java.util.Random ; 
import java.util.Arrays ; 
import java.util.Vector ; 
import java.lang.System ; 
import java.util.ListIterator ; 
import java.util.Iterator ; 
import java.util.List ; 
import java.util.Set; 
import java.util.HashSet ; 
import java.util.ArrayList ; 


public class Generator{

    public static Random random = new Random(System.nanoTime()) ; 
    // = new Random(System.currentTimeMillis()) ;    
        public  static int[][] replicate(int[][] input){
             int width = input[0].length ; 
             int height =  input.length ; 
             int[][] similar  = new int[height][width] ; 
             for(int dy=height-1;dy>=0;dy -- ){
                for(int dx=width-1;dx>=0;dx-- ){
                    similar[dy][dx] = input[dy][dx] ;  
                }
             }   
             return  similar ; 
        } 
        public static Vector<int[]>   correlate(int lower,int higher,int spread,int spans){
                Vector<int[]> created = new Vector<int[]> () ;   
                for(int  cs=spans-1;cs>=0;cs--){
                    int[] types =new int[spread] ; 
                    for(int ce=0;ce<spread;ce++){
                        types[ce]  = random.nextInt(lower,higher) ; 
                    } 
                    created.add(types) ;
                }  
                return created  ; 
        }    
          //   System.out.println(temps) ;  
           //   System.out.println(Arrays.toString(frame)) ;   
             //    System.out.println(Arrays.deepToString(nested)) ;
        public static int[][] generate(int spans,int voids){
            int[][] created = new int [spans][spans] ;    
            Vector<int[]> vected = correlate(0,spans-1,2, spans*spans-voids ) ; 
            ListIterator<int[]> listed =  vected.listIterator() ; 
            while(listed.hasNext( )){
                 int[] frame = listed.next( )  ; 
                 int[][] nested = replicate(created)  ;  
                  int temps  = random.nextInt(1,spans) ;  
                  nested[frame[1]][frame[0]] = temps  ;  
             if(!Validator.isValidPuzzle(nested)){listed.previous(); continue ; }
                  created[frame[1]][frame[0]] =  temps  ;  
                }  
                System.out.println(voids) ;
            return created ;  
        }   
                //   if(!Solver.solvePuzzle(nested))
             //  {listed.previous() ; break ;  } // continue ; }  
                //  System.out.println(delta) ; 
         //System.out.println (Arrays.deepToString(verse)) ;    
         //        //  System.out.println( "Rehash") ;
        public static int[][] create(int spans,int voids){
            int[][]  nested = new int[spans][spans] ; 
            int delta =spans*spans-voids ; 
             int theta = 0 ; 
            while(theta<delta){  
                int failed =  0 ;
                while(theta<delta&&failed<300){
                int[][] verse =  replicate(nested) ; 
                int posX=  random.nextInt(0,spans) ; 
                int posY = random.nextInt(0,spans) ;   
                int value = random.nextInt(1,spans) ;    
                if(nested[posY][posX]!=0){random = new Random(System.currentTimeMillis()) ; continue  ; }
                verse[posY][posX] = value ; 
                if(!Validator.isValidPuzzle(verse)){  failed = failed+1 ;    System.out.println(55) ; 
                    random =new Random(System.nanoTime()) ;  continue  ;    } 
                 nested[posY][posX] = value  ; 
                theta = theta+1 ;  }  
                if(failed>=300){
                 nested = new int [spans][spans] ; 
                 theta = 0 ;     }   }   
            return nested ;  
        }  
          //   System.out.print(44) ; 
             //  System.out.print(55) ;  
        public static boolean compute(int  phase,List<int[]> serial,int[][] arrays,List<int[][]> buffers){  
            if(!Validator.isValidPuzzle(arrays)){return false ;  } 
            if(phase>=serial.size()){
                int[][] similar = Utility.replicate(arrays) ; 
                buffers.add(similar) ; 
                return true  ;  }  
            int[] types =serial.get(phase) ;    
            int digit = arrays[types[1]][types[0]] ; 
           int[]  signs = Utility.linearize( 1,arrays.length) ; 
            Utility.shuffle(arrays.length,signs) ;
            for ( int  dx=0;dx<signs.length;dx++){ 
               int temps = signs[dx] ;   //    int[] temps = signs[dx]  // vected.get(dx);
              arrays[types[1]][types[0]] =  temps  ; // temps[0] ;   
            boolean cases = compute(phase+1,serial, arrays,buffers) ; 
                arrays[types[1]][types[0]] = digit ; 
                if(cases==true ){return true  ; }
            }
            return false ;
        }  
        /*  Vector<int[]> vected =  Utility.correlate(1,arrays.length,1,arrays[0].length) ;   
            for( int dy=0;dy<vected.size( );dy++){
              //  System.out.println(Arrays.toString( vected.get(dy))) ;
            } */
        public static int[][] dedicate(int spans,int voids){
              List<int[]> lanes = new Vector<int[]>()  ;
            int[][] lines =new int[spans][spans]; 
            for( int fy=0;fy<spans;fy++){
                for(int fx=0;fx<spans;fx++){
                    lanes.add( new int[]{fx,fy}) ;
                }
            }   
             List<int[][]> buffers =new ArrayList<int[][]>() ;   
            boolean cases = false ;
            while(cases== false){  
                List<int[]> crease = Utility.resolve(spans*spans-voids,lanes) ;  
                cases = compute(0, crease,lines,buffers) ;
            }   
            int[][] types = buffers.get(0)  ;
            return  types ;  
        }  
               //   System.out.println(crease.toString()) ;    
} 