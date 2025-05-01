class Solution {
    private int[] tasks;
    private int[] workers;
    private int strength;
    private int pills;
    private int taskCount;
    private int workerCount;
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        this.tasks = tasks;
        this.workers = workers;
        this.strength = strength;
        this.pills = pills;
        taskCount = tasks.length;
        workerCount = workers.length;
        int left = 0;
        int right = Math.min(workerCount, taskCount);
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (check(mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean check(int x) {
        int taskIdx = 0;
        Deque<Integer> taskQueue = new ArrayDeque<>();
        int remainingPills = pills;
        for (int workerIdx = workerCount - x; workerIdx < workerCount; workerIdx++) {
            while (taskIdx < x && tasks[taskIdx] <= workers[workerIdx] + strength) {
                taskQueue.offer(tasks[taskIdx++]);
            }

            if (taskQueue.isEmpty()) {
                return false;
            }

            if (taskQueue.peekFirst() <= workers[workerIdx]) {
                taskQueue.pollFirst();
            } else if (remainingPills == 0) {
                return false;
            } else {
                remainingPills--;
                taskQueue.pollLast();
            }
        }
        return true;
    }
}