package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CustomContainerImpl customContainer = new CustomContainerImpl();
        Object obj1 = new Object();
        customContainer.addInstance(obj1, "object1");

        String str = "Hello, world!";
        customContainer.addInstance(str);

        Integer number = 42;
        customContainer.addInstance(number, "intNumber");
    }
}