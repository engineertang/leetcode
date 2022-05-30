package graph;

import java.util.*;

public class RedundantConnection684 {
    // 给定往一棵 n 个节点 (节点值 1～n) 的树中添加一条边后的图。 树只添加一条边，所以边的数目和节点的数目相等
    //Set<Integer> visited = null;//         this.visited = new HashSet<>();
    List<Integer>[] adj = null;
    /*public int[] findRedundantConnection2(int[][] edges) {
        // 1.建图的存储，二维数组变成邻接表LinkedList<>[n]
        int n = edges.length;
         adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        // 无向图，所以需要添加双向引用
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        // 2.检测环的存在，换句话说，通过dps深度优先算法找到能回到原点的路径
        visited = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                //dfs(adj, i, visited);
            }
        }

        // 3.删除任一条路径
        return null;
    }

    *//**
     * @param adj     邻接表
     * @param u       从顶点 u 开始执行深度优先遍历
     * @param visited 布尔数组，记录某个结点是否被访问过
     *//*
    private void dfs(List<Integer>[] adj, int u, boolean[] visited) {
        visited[u] = true;
        List<Integer> successors = adj[u];
        for (int successor : successors) {
            if (!visited[successor]) {
                dfs(adj, successor, visited);
            }
        }
    }*/

    private Map<Integer, List<Integer>> graph;
    private Set<Integer> visited;

    public int[] findRedundantConnection(int[][] edges) {
        this.graph = new HashMap<>();
        this.visited = new HashSet<>();

        // 遍历每一条边
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (graph.containsKey(u) && graph.containsKey(v)) {
                visited.clear();
                // 深度优先遍历该图，判断 u 到 v 之间是否已经存在了一条路径
                if (dfs(u, v)) {
                    return edge;
                }
            }
            // 所有相邻顶点都找不到回路，才向图中添加这条边，由于是无向图，所以要添加两条边
            addEdge(u, v);
            addEdge(v, u);
        }
        return null;
    }

    private void addEdge(int u, int v) {
        if (graph.containsKey(u)) {
            graph.get(u).add(v);
            return;
        }
        List<Integer> successors = new ArrayList<>();
        successors.add(v);
        graph.put(u, successors);
    }


    /**
     * 从 source 开始进行深度优先遍历，看看是不是能够找到一条到 target 的回路
     *
     * @param source
     * @param target
     * @return 找不到回路返回 false
     */
    private boolean dfs(int source, int target) {
        if (source == target) {
            return true;
        }
        visited.add(source);
        // 遍历 source 的所有相邻顶点
        for (int adj : graph.get(source)) {
            if (!visited.contains(adj)) {
                if (dfs(adj, target)) {
                    return true;
                }
            }
        }
        // 所有相邻顶点都找不到，才能返回 false
        return false;
    }


}
