package Exer1;

class Person{
    int age;
    String name;

    Person (){
        this.age = 1;
        this.name = "No name";
    }

    Person (int age) {
        this.name = "No name";
        this.age = age;
    }

    Person (String name, int age) {
        this.age = age;
        this.name = name;
    }
}
