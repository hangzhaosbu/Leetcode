class Solution {
    public int minimumSemesters(int N, int[][] relations) {
        List<List<Integer>> graph = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; ++i) {
            graph.add(new ArrayList<Integer>());
        }
        for (int[] relation : relations) {
            graph.get(relation[0]).add(relation[1]);
        }
        int[] visited = new int[N + 1];

        int maxLength = 1;
        for (int node = 1; node < N + 1; node++) {
            int length = dfs(node, graph, visited);
            if (length == -1) {
                return -1;
            }
            maxLength = Math.max(length, maxLength);
        }
        return maxLength;
    }

    private int dfs(int node, List<List<Integer>> graph, int[] visited) {
        if (visited[node] != 0) {
            return visited[node];
        } else {
            visited[node] = -1;
        }
        int maxLength = 1;
        for (int endNode : graph.get(node)) {
            int length = dfs(endNode, graph, visited);
            if (length == -1) {
                return -1;
            }
            maxLength = Math.max(length + 1, maxLength);
        }
        visited[node] = maxLength;
        return maxLength;
    }
}