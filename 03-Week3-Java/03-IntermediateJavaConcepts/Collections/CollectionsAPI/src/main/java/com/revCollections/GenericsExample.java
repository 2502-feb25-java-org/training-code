package com.revCollections;

class TestGenerics<T,U>
{
    T t;
    U u;
    public TestGenerics(T t, U u){
        this.t=t;
        this.u=u;
    }
    public void ReadValues(){
        System.out.println(t+" "+u);
    }
    <T,U> String compare(T t1, U t2){
        boolean result= t1==t2;
        if(result)
            return "The objects are equal";
        else
            return "Not equal";
    }
}

class MainClass{
        public static void main(String[] args){
            TestGenerics<Integer,String> myGenericObj=new TestGenerics(123, "Hello generics");
            TestGenerics<Integer,String> myGenericObj1=myGenericObj;
            TestGenerics<Integer,String> myGenericObj2=new TestGenerics(123, "Hello generics");
            String a="Hello World";
                   a="bye";
            String b=new String("Hello World");
            String c=new String("Hello World");
            myGenericObj.ReadValues();
            
            System.out.println(myGenericObj.compare(b, c));
        }
    }