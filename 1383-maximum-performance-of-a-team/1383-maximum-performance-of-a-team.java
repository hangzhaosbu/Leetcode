class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int modulo = (int) Math.pow(10, 9) + 7;
        // build tuples of (efficiency, speed)
        List<Pair<Integer, Integer>> candidates = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            candidates.add(new Pair(efficiency[i], speed[i]));
        }
        // sort the members by their efficiencies
        Collections.sort(candidates, Comparator.comparing(o -> -o.getKey()));

        // create a heap to keep the top (k-1) speeds
        PriorityQueue<Integer> speedHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);

        long speedSum = 0, perf = 0;
        for (Pair<Integer, Integer> p : candidates) {
            Integer currEfficiency = p.getKey();
            Integer currSpeed = p.getValue();
            // maintain a heap for the fastest (k-1) speeds
            if (speedHeap.size() > k - 1) {
                speedSum -= speedHeap.remove();
            }
            speedHeap.add(currSpeed);

            // calculate the maximum performance with
            // the current member as the least efficient one in the team
            speedSum += currSpeed;
            perf = Math.max(perf, speedSum * currEfficiency);
        }
        return (int) (perf % modulo);
    }
}