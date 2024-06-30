package be.kdg.mentoring.week03.functional;

// Java code to illustrate lambda expression
// without parameters
public class NoParamsLambdaTest {

    // functional interface
    // without parameters
    interface NoParamsLambda {
        void print();
    }

    // functional interface parameter is passed
    static void fun(NoParamsLambda t) { t.print(); }
    public static void main(String[] args)
    {
        // lambda expression is passed
        // without parameter to functional interface NoParamsLambda
        fun(() -> System.out.println("Hello"));
    }
}
