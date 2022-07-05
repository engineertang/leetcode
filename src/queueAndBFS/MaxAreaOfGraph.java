package queueAndBFS;

import java.util.LinkedList;
import java.util.Queue;

// 二维平面上的搜索问题，泛洪填充（从一个点扩散出去）
public class MaxAreaOfGraph {
    public final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    // 方法二：广度优先遍历（使用二维坐标）
    public int maxAreaOfIsland(int[][] grid) {
        //step1 双循环，确保得到每个节点被包含的最大岛屿
        int rows = grid.length;
        int columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(!visited[i][j] && grid[i][j] == 1){
                    int curPoint = bfs(grid, i, j, visited);
                    maxArea = Math.max(maxArea, curPoint);
                    System.out.printf("current i : %d, current j:%d, curPoint:%d, \n", i, j, curPoint);
                }
            }
        }

        return maxArea;
    }

    public int bfs(int[][] grid, int i, int j, boolean[][] visited){
        int count = 0;
        // queue,实现平面扩展
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        count ++;

        while (queue.size() != 0){
            int[] current = queue.poll();

            for (int[] direction : directions){
                int newi = current[0] + direction[0];
                int newj = current[1] + direction[1];

                if (validPoint(grid, newi, newj) && grid[newi][newj] == 1 && !visited[newi][newj]){
                    queue.offer(new int[]{newi, newj});
                    visited[newi][newj] = true;
                    count++;
                }
            }
        }

        return count;
    }

    public boolean validPoint(int[][] grid, int i, int j){
        return i >= 0 && j >= 0 && i< grid.length && j < grid[0].length;
    }

    public static void main(String[] args) {
        MaxAreaOfGraph graph = new MaxAreaOfGraph();
        int[][] array = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};

        int result = graph.maxAreaOfIsland(array);
        System.out.println();
        System.out.println(result);
    }
}
