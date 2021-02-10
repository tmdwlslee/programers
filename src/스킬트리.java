public class 스킬트리 {
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (int i=0; i<skill_trees.length;i++){
            int[] alpha = new int[27];
            for(int j=0; j<skill_trees[i].length(); j++){
                alpha[skill_trees[i].charAt(j) - 'A' + 1] = j+1;
            }

            int preIndex = alpha[skill.charAt(0) - 'A' + 1];
            boolean check = true;
            for(int j=1; j<skill.length(); j++){
                if(preIndex > alpha[skill.charAt(j) - 'A' + 1] && alpha[skill.charAt(j) - 'A' + 1] != 0){
                    check = false;
                }else if(preIndex == 0 && alpha[skill.charAt(j) - 'A' + 1] > 0){
                    check = false;
                }
                preIndex = alpha[skill.charAt(j) - 'A' + 1];
            }

            if(check){
                System.out.println(skill_trees[i]);
                ++answer;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] arr = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(solution("CBD", arr));
    }
}
