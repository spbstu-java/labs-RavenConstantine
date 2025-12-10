public class MyClass {
    public void HelloWorld(){
        System.out.println("Hello World!");
    }
    public void PrintStr(String str) {
        System.out.println("Строка: " + str);
    }
    public int Sum(int x, int y) {
        System.out.println("Сумма: " + (x + y));
        return x + y;
    }
    @RepeatCount(1)
    protected void GoodbyeWorld(){
        System.out.println("Goodbye World!");
    }
    @RepeatCount(2)
    protected String PrintTwoStr(String str, String str2) {
        System.out.println("Строка2: " + str + " " + str2);
        return str + " " + str2;
    }
    @RepeatCount(3)
    protected int Prod(int x, int y) {
        System.out.println("Произведение: " + (x * y));
        return x + y;
    }
    @RepeatCount(1)
    private void GoodbyeCruelWorld() {
        System.out.println("Goodbye Cruel World!");
    }
    @RepeatCount(2)
    private String PrintThreeStr(String str, String str2, String str3) {
        System.out.println("Строка3: " + str + " " + str2 + " " + str3);
        return str + " " + str2 + " " + str3;
    }
    @RepeatCount(3)
    private int Pow(int a, int b) {
        int pow = 1;
        for (int i = 0; i < b; i++) pow *= a;
        System.out.println("Степень: " + pow);
        return pow;
    }
}