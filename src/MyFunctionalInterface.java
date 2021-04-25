import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// @FunctionalInterface 선언 시 함수형 인터페이스
// 단 하나의 추상 메서드만 가져야함.
// 아닐 경우 컴파일 단계에서 Error
@FunctionalInterface
interface MyFunctionalInterfaceTest {
    public abstract boolean cmp(int a, int b);
    //public abstract int cal(int a, int b); -> 주석 해제시 Error
}

public class MyFunctionalInterface {
    public static void main(String[] args) {
        // 함수의 body를 a > b의 결과 값을 반환하도록 작성
        MyFunctionalInterfaceTest func = (a,b) -> a > b;

        int a = 10;
        int b = 5;
        System.out.println("a 는 b보다 크면 -> " + func.cmp(a,b)); // true


        //Consumer<T> forEach 사용
        Consumer<Integer> consumer = num -> System.out.print(num+" ");
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        //list.forEach(consumer);

        //Predicate<T>
        Predicate<Integer> predicate = num -> num < 10;
        Stream<Integer> integerStream = Stream.of(1,5,11);
        integerStream.filter(predicate).forEach(num -> System.out.print(num + " "));

        //Function<T, R>
        Function<Integer, String> function = num -> String.valueOf(num);
        Stream<Integer> funcStream = Stream.of(1,5,11);
        System.out.println(funcStream.map(function).collect(Collectors.toList()));

    }
}
