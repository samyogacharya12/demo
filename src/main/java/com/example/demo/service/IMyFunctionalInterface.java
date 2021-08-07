package com.example.demo.service;


@FunctionalInterface
public interface IMyFunctionalInterface {


    void myDemo(int a, int b);


    default void setData() {
        System.out.println("This is default to check data");
    }

    default void setData2() {
        System.out.println("This is default 2 to check data");
    }


}

class MyFunction {

    void myDemo() {
        IMyFunctionalInterface iMyFunctionalInterface = (int a, int b) ->
        {
            int sum = a + b;
            System.out.println(sum);
        };
        iMyFunctionalInterface.myDemo(10, 20);

    }
}
