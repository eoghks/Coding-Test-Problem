class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        double res = 0;
        //add pq
        for (int[] c : classes) {
            pq.offer(new double[]{profit(c[0], c[1]), c[0], c[1]});
        }
        //extraStudents
        while (extraStudents > 0) {
            double[] temp = pq.poll();
            pq.offer(new double[]{profit(temp[1]+1, temp[2]+1), temp[1]+1, temp[2]+1});
            extraStudents--;
        }
        //pass ratio
        while (!pq.isEmpty()) {
            double[] temp = pq.poll();
            double a = temp[1], b = temp[2];
            res +=  temp[1]/ temp[2];
        }
        return res / classes.length;
    }
    
    private double profit(double a, double b) {
        return (a + 1) / (b + 1) - a / b;
    }
}