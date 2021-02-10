import java.util.Comparator;

@FunctionalInterface // 함수형 인터페이스, 함수형으로 사용하지 않으면 컴파일에러 발생
interface Function{
    void calc(int n1, int n2);
}

@FunctionalInterface
interface Function2{ // Function2는 1개의 추상 메서드만을 가지므로 람다식으로 사용가능
    void calc(int n1);
    default void printString(String s){ System.out.println(s); }// 이게 가능하다
}

public class lamda {

    // 람다식의 사용 이유
    // 코드의 간결함 -> 인터페이스가 가지고 있는 메서드를 간편하게 작성하여 사용하는 것이 목적
    // 람다식은 인터페이스 중 '단 하나의 추상 메서드'를 가진 인터페이스에서만 사용 가능 ex) Comparator

    // 하지만 JAVA 8에서 default 메서드라는 기능이 추가됐는데
    // 인터페이스 내부에 메서드 선언시에 default를 명시하게 되면 코드가 포함된 메서드를 선언할 수 있다.
    // 위의 경우 추상메서드로 치지않는다. 예시는 Function2를 볼 것

    // 함수형 인터페이스 참고 사이트, [출처] https://codechacha.com/ko/java8-functional-interface/

    public static void main(String[] args) {
        //기본 람다식 형태 () : 매개변수 , {} : 함수body
        Function f = (n1,n2) -> {System.out.println("기본 람다식 구조");};
        f.calc(0,0);

        // 람다식 생략 규칙
        // 1. ()에 매개변수가 없거나 2개 이상이면 생략 x, 매개변수가 1개라면 생략 o
        Function2 f2 = a -> {System.out.println(a);};
        f2.calc(3);

        f = (n1,n2) -> {System.out.println(n1+n2);};
        f.calc(2,3);

        // 2. 함수 body가 한 줄로 끝난다면 {} 생략 가능, 그 이상일 경우 생략 불가능
        f2 = (a) -> System.out.println(2*a);
        f2.calc(3);

        f = (n1,n2) -> System.out.println(2*n1+2*n2);;
        f.calc(2,3);

        //default 메서드 사용
        f2.printString("default 메서드");
    }
}
