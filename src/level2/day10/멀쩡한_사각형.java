package level2.day10;

public class 멀쩡한_사각형 {
    public static long solution(int w, int h) {
        long answer = 1;
        long div = 0;
        int mod = 0;
        int width = 0;
        int height = 0;

        width = Math.max(w,h);
        height = Math.min(w,h);

        System.out.println("w " + width + " h "+height);

        if(width == height){
            div = width;
        }else{
            mod = Math.min(width/3, height/2);
            div = mod * 4;

            if(width%3 > 0 || height%2 > 0){
                mod = Math.max(width%3, height%2);
                div += mod;
            }

            System.out.println("div " + div);
        }

        answer = (long)(width*height - div);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(8,12));
    }
}
