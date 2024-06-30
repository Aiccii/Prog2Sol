package be.kdg.mentoring.week03.functional;

// Java code to illustrate lambda expression
// with single parameter

// functional interface
// with one parameter of Integer type
public class OneParamsLambdaTest {

    // The void type and the Integer type
    // is automatically inferred from here
    // and assigned to the lambda expression
    interface OneParamsLambda {
        void print(Integer p);
    }

    // takes lambda expression and a variable of
    // Integer type as arguments
    static void fun(OneParamsLambda t, Integer p){
        // calls the print function
        t.print(p);
    }
    public static void main(String[] args)
    {
        // lambda expression is passed
        // with a single parameter
        // lambda expression is mapped to the
        // single argument abstract function in the
        // functional interface OneParamsLambda
        fun((p) -> System.out.println(p), 10);
    }
}
