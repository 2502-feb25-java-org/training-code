package com.revCollections;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       // System.out.println( "Hello World!" );
       //CreateArrayList();
       //CreateStack();
       CreateSet();
    }
    static void CreateArrayList(){
        List<String> ar = new ArrayList<String>();
        ar.add("Pushpinder");
        ar.add("Kaur");
        ar.add(1, "Test");
        ar.remove(1);
        //ar.add(27);
        for (String item : ar) {
            System.out.println(item);
        }
        System.out.println("Size: " +ar.size());
        System.out.println("Second element: " +ar.get(1));
    }
    static void CreateStack(){
        Stack<String> stack=new Stack<String>();
        stack.push("Pushpinder");
        stack.push("Kaur");
        System.out.println(stack.peek());
    }
    static void CreateSet(){
        Hashtable<Integer,String> emp=new Hashtable<Integer,String>();
        emp.put(1,"Carol Baxtor");
        emp.put(2, "Meghan");
        emp.put(3, "Palmer");
        emp.put(4, "Felice");
        // for (Map.Entry m : emp.getKey()) {
        //     System.out.println(m.getKey()+" "+m.getValue());
        // }
        for (Integer key : emp.keySet()) {
            System.out.println(key+" "+emp.get(key));
        }
    }
}
