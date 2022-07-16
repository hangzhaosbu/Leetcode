class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        // initialization
        List<Integer> queryResults = new ArrayList<>();
        Map<Integer, List<Integer>> hashmap = new HashMap<>();

        for (int i = 0; i < colors.length; i++) {
            hashmap.putIfAbsent(colors[i], new ArrayList<Integer>());
            hashmap.get(colors[i]).add(i);
        }

        // for each query, apply binary search
        for (int i = 0; i < queries.length; i++) {
            int target = queries[i][0], color = queries[i][1];
            if (!hashmap.containsKey(color)) {
                queryResults.add(-1);
                continue;
            }

            List<Integer> indexList = hashmap.get(color);
            int insert = Collections.binarySearch(indexList, target);

            // due to its nature, we need to convert the returning values
            // from Collections.binarySearch
            // more details: https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Collections.html#binarySearch(java.util.List,T)
            if (insert < 0) {
                insert = (insert + 1) * -1;
            }

            // Handling cases when:
            // - the target index is smaller than all elements in the indexList
            // - the target index is larger than all elements in the indexList
            // - the target index sits between the left and right boundaries
            if (insert == 0) {
                queryResults.add(indexList.get(insert) - target);
            } else if (insert == indexList.size()) {
                queryResults.add(target - indexList.get(insert - 1));
            } else {
                int leftNearest = target - indexList.get(insert - 1);
                int rightNearest = indexList.get(insert) - target;
                queryResults.add(Math.min(leftNearest, rightNearest));
            }

        }
        return queryResults;
    }
}