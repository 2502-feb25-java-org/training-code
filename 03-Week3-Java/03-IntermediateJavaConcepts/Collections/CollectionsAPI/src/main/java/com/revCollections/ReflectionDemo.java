package com.revCollections;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

class TestCheck {
    private String msg;

    public TestCheck() {
        msg = "Secret";
    }

    public TestCheck(String msg) {
        this.msg = msg;
    }

    public void M1() {
        System.out.println("Msg from M1" + msg);
    }

    public void M2(String msg) {
        System.out.println("Message from M2 " + msg);
    }

    private void M3() {
        System.out.println("Inside Private Method");
    }
    public int add(int a, int b){
        return a+b;
    }
    public long multiply(long a, long b){
        return a*b;
    }
}

class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        TestCheck obj = new TestCheck("No secret");

        // 1. Reading instance of Classes
        // 1.1 returns the instance of Class class. can be used with primitives
        Class clsObj = obj.getClass();

        // 1.2 If a type is available but there is no instance. can be used with
        // primitives
        Class cls = TestCheck.class;

        /*
        1.3 
         * used to load the class dynamically.
         * returns the instance of Class class. 
         * It should be used if you know the fully qualified name of class. 
         * This cannot be used for primitive types. 
         * Exception needs to be handled
         */
        Class clsRef = Class.forName("com.revCollections.TestCheck");//

        System.out.println("Class- " + clsRef.getName());// Returns Fully qualified class

        //2. retrieve Constructors declared
        Constructor[] cnstrs = clsObj.getConstructors();
        // returns an array of Constructor objects reflecting all the constructors
        // declared by the class represented by this Class object.
        // Constructor[] cnstrs = clsObj.getDeclaredConstructors();
        for (Constructor cnstr : cnstrs) {
            System.out.println("Constructor- " + cnstr);
        }
        
        //3. retrieve all methods declared including private ones
        // returns an array of Method objects reflecting all the methods declared by the class or interface represented by this Class object.
        //.getMethods will return only public methods
        Method[] methods = clsObj.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method- " + method.getName());
        }
        //4. retrieve all fields declared including private ones
        Field[] fields = clsObj.getDeclaredFields();

        for (Field field : fields) {
            System.out.println("Field- " + field);
        }
        //5. Invoke Method
        Method invokeM2 = clsObj.getDeclaredMethod("M2", String.class);
        invokeM2.invoke(obj, "- No Secret Msg");

        //6. Invoke Private Method
        Method invokeM3 = clsObj.getDeclaredMethod("M3");
        invokeM3.setAccessible(true);// to allow access to private method
        invokeM3.invoke(obj);

    }
}
