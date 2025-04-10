class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        boolean relation[][] = new boolean[numCourses][numCourses];
        //관계 정리
        for(int[] p: prerequisites) {
            relation[p[0]][p[1]] = true;
        }

        //플로이드 워셜
        //j가 k의 선수 지식인 경우
        //j가 i의 선수 지식이고 i가 k의 선수 지식인 경우
        //i<numCourses를 통해 모든 경우의 수 확인
        for(int i=0; i<numCourses; i++) {
            for(int j=0; j<numCourses; j++) {
                 for(int k = 0; k<numCourses; k++) {
                    relation[j][k] =  relation[j][k] || (relation[j][i] && relation[i][k]);  
                }
            }
        }

        for(int q[] : queries)
            res.add(relation[q[0]][q[1]]);

        return res;
    }
}