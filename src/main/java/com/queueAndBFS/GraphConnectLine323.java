package com.queueAndBFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphConnectLine323 {
    public int countComponents(Integer n, int[][] edges) {
        List<Integer>[] graph = buildGraph(n, edges);
        int result = 0;
        boolean[] visited = new boolean[n];
        // Step2:遍历每一个顶点，对每一个顶点执行一次广度优先遍历，注意：在遍历的过程中使用 visited 布尔数组记录已经遍历过的结点。
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(graph, i, visited);
                result++;
            }
        }
        return result;
    }

    // Step1: adjacent list，构造邻接表，列表数组List[]，表示的无向图
    public List<Integer>[] buildGraph(int n, int[][] edges) {
        // LinkedList<Node>[]  adj = new LinkedList<Node>[n];
        /*
        [1,3,5,6]  // LinkedList<Node>
        [2,5,6]
        [3,4,5]
        [5,6]
         */
        LinkedList<Integer>[] adj = new LinkedList[n];
        // adj[0] adj[1] adj[2] adj[3] adj[4]
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<Integer>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        return adj;
    }

    /**
     * @param adj     邻接表
     * @param u       从 u 这个顶点开始广度优先遍历
     * @param visited 全局使用的 visited 布尔数组
     */
    private void bfs(List<Integer>[] adj, int u, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(u);
        visited[u] = true;

        while (!queue.isEmpty()) {
            Integer front = queue.poll();  // 出队列
            // 获得队首结点的所有后继结点
            List<Integer> successors = adj[front];
            for (int successor : successors) {
                if (!visited[successor]) {
                    queue.offer(successor);
                    // 特别注意：在加入队列以后一定要将该结点标记为访问，否则会出现结果重复入队的情况
                    visited[successor] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphConnectLine323 graph = new GraphConnectLine323();
        int[][] array = {{0, 1}, {0, 2}, {2, 5}, {3, 4}, {3, 5}};
        graph.countComponents(6, array);
    }
}
