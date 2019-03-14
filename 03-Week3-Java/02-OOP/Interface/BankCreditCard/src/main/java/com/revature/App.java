package com.revature;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
          /*  Bank chase=new ChaseBank();
            double interestRate=chase.getRateofInterest();
            double discount=chase.discount(7.2);
            System.out.println("Interest Rate "+interestRate + " Discount "+discount);
          */
            //Wrapper classes
            /*
            int-> Integer 
            boolean->Boolean
            char->Character
            */
            /*int a=20;
            Integer i=Integer.valueOf(a);//Conversion of int to Integer
            Integer j=a; //autoboxing 
            System.out.println(j);

            Integer x=new Integer(10);
            int y=x;// unboxing
            */

            //COLLECTIONS- Arrays, Collection Framework/ Collection API
            //Arrays: homogeneuous items and place contigious memory location
           /* int[] arr1;//declare;
            arr1=new int[10];//initialization
            arr1[0]=1;
            arr1[2]=2;*/
            /*int[] arr1= {10,20,12,256,78};//1-D
            for (int item : arr1) {
                System.out.println(item);
            }
            //2-D
            int row=2,col=3;

            int[][] twodarr={{1,2,3},{3,45,6}};
            //twodarr[0][0]=1;
            */
            //Jagged Array
            String[][] ja=new String[2][];
            ja[0]=new String[]{"Hello","All","World"};
            ja[1]=new String[]{"CUNY","SPS"};
            //ja[2]=new String[]{"We","are","java","Programmers","."};
            System.out.println(ja.length);
            for(int i=0;i<ja.length;i++)
            {
                for(int j=0;j<ja[i].length;j++)
                {
                    System.out.print(ja[i][j]);
                }
                System.out.println();
            }
    }
}
