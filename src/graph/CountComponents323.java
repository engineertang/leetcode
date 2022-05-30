package graph;

import java.util.ArrayList;
import java.util.List;

public class CountComponents323 {

    public int countComponents(int n, int[][] edges) {
        // 第 1 步：构建图用邻接表存储 adjacent list
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        // 无向图，所以需要添加双向引用
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        // 第 2 步：开始深度优先遍历，使用递归，访问相连的顶点，并标记visited，直到完成访问连通向量，所有点都访问
        // 然后遍历每一个顶点，对每一个顶点执行一次深度优先遍历，注意：在遍历的过程中使用 visited 布尔数组记录已经遍历过的结点。
        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adj, i, visited);
                count++;
            }
        }
        return count;
    }

    /**
     * @param adj     邻接表
     * @param u       从顶点 u 开始执行深度优先遍历
     * @param visited 记录某个结点是否被访问过
     */
    private void dfs(List<Integer>[] adj, int u, boolean[] visited) {
        visited[u] = true;
        List<Integer> successors = adj[u];
        for (int successor : successors) {
            if (!visited[successor]) {
                dfs(adj, successor, visited);
            }
        }
    }

}
