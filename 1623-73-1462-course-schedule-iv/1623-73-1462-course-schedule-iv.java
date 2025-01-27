class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        boolean relation[][] = new boolean[numCourses][numCourses];
        //관계 정리
        for(int[] p: prerequisites) {
            relation[p[0]][p[1]] = true;
        }

        //j가 k의 선수 지식인 경우
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