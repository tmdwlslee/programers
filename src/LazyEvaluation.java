import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class LazyEvaluation {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        // index가 0보다 클 때만 연산할려고 하지만 아래의 코드는 모두 3초의 시간이 경과됨.
        // Lazy Evaluation으로 해결
        //printGoodNight(2, getString() +" : " +(System.currentTimeMillis() - startTime)/1000+ " sec");
        //printGoodNight(1, getString() +" : " + (System.currentTimeMillis() - startTime)/1000+ " sec");
        //printGoodNight(0, getString() +" : " + (System.currentTimeMillis() - startTime)/1000+ " sec");

        lazyPrintGoodNight(2, () -> getString());
        System.out.println("index : 2 -> " + (System.currentTimeMillis() - startTime)/1000+ " sec");
        lazyPrintGoodNight(1, () -> getString());
        System.out.println("index : 1 -> " + (System.currentTimeMillis() - startTime)/1000+ " sec");
        lazyPrintGoodNight(0, () -> getString());
        System.out.println("index : 0 -> " + (System.currentTimeMillis() - startTime)/1000+ " sec");

        /* 출력 결과 :
            Good night
            index : 2 -> 3 sec
            Good night
            index : 1 -> 6 sec
            No
            index : 0 -> 6 sec
         */

    }

    public static String getString(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Good night";
    }

    public static void printGoodNight(int index, String value){
        // index가 0보다 클 때만 연산할려고 함
        if(index > 0){
            System.out.println(value);
        }else{
            System.out.println("No " + value);
        }
    }

    public static void lazyPrintGoodNight(int index, Supplier<String> func){
        // index가 0보다 클 때만 연산할려고 함
        if(index > 0){
            System.out.println(func.get());
        }else{
            System.out.println("No ");
        }
    }
}
