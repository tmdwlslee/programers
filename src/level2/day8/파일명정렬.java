package level2.day8;

import java.util.Arrays;

public class 파일명정렬 {
    public static String[] solution(String[] files) {
        String[] answer = {};

        Arrays.sort(files, (o1, o2) -> {
            String headO1 = "";
            String numO1 = "";
            String headO2 = "";
            String numO2 = "";
            int startIndex = -1;
            int endIndex = -1;
            for(int i=0; i<o1.length(); i++){
                if(o1.charAt(i) >= '0' && o1.charAt(i) <='9') {
                    if (startIndex < 0) startIndex = i;
                    endIndex = i;
                }else{
                    if(startIndex >=0 && endIndex >= 0){
                        break;
                    }
                }
            }

            headO1 = o1.substring(0,startIndex);
            numO1 = o1.substring(startIndex, endIndex + 1);

            startIndex = -1;
            endIndex = -1;

            for(int i=0; i<o2.length(); i++){
                if(o2.charAt(i) >= '0' && o2.charAt(i) <='9') {
                    if (startIndex < 0) startIndex = i;
                    endIndex = i;
                }else{
                    if(startIndex >=0 && endIndex >= 0){
                        break;
                    }
                }
            }

            headO2 = o2.substring(0,startIndex);
            numO2 = o2.substring(startIndex, endIndex + 1);
            headO1 = headO1.toUpperCase();
            headO2 = headO2.toUpperCase();
            System.out.println(headO1);
            System.out.println(numO1);
            System.out.println(headO2);
            System.out.println(numO2);
            if(headO1.compareTo(headO2) > 0){
                return -1;
            }else{
                if(headO1.compareTo(headO2) == 0){
                    return Integer.parseInt(numO1) - Integer.parseInt(numO2);
                }else{
                    return 1;
                }
            }
        });


        return files;
    }

    public static void main(String[] args) {
        String[] arr = new String[2];

        for(int i=0; i<1; i++){
            arr[i] = "img00000.txt";
        }
        arr[1] = "img0.txt";

        solution(arr);
    }
}
