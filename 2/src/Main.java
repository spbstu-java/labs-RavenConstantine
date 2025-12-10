public class Main {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();

        System.out.println("Прямой вызов публичных методов");
        myClass.HelloWorld();
        myClass.PrintStr("Буквы");
        myClass.Sum(10,3);

        System.out.println();
        System.out.println("Вызов аннотированных защищённых и приватных методов");
        ReflectionInvoker.InvokeProAndPriMethods(myClass);
    }
}