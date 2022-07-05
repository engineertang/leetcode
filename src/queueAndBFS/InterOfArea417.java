package queueAndBFS;

import java.util.*;

import static java.util.stream.Collectors.toList;


public class InterOfArea417 {
    public final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int coloumns = heights[0].length;
        // pacificList List<List<Integer>>
        // 从i=0,和j=0的每个点出发，找出前后左右相邻的比自己大的点，加到pacificList
        List<List<Integer>> pacificList = new ArrayList<>();
        boolean[][] visited = new boolean[rows][coloumns];
        for (int i = 0; i < rows; i++) {
            if (!visited[i][0]) {
                bfs(heights, i, 0, pacificList, visited);
            }
        }

        for (int j = 0; j < coloumns; j++) {
            if (!visited[0][j]) {
                bfs(heights, 0, j, pacificList, visited);
            }
        }
        //System.out.println(pacificList.stream().sorted((o1, o2) -> o1.get(0) < o2.get(0) ? -1 : (o1.get(0) > o2.get(0) ? 1 : ((o1.get(1) < o2.get(1)? -1 : 1)))).collect(toList()));


        // atlanticList List<List<Integer>>
        visited = new boolean[rows][coloumns];
        List<List<Integer>>  atlanticList = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            if (!visited[i][coloumns-1]){
                bfs(heights, i, coloumns-1, atlanticList, visited);
            }
        }
        for (int j = 0; j < coloumns; j++) {
            if (!visited[rows-1][j]){
                bfs(heights, rows-1, j, atlanticList, visited);
            }
        }

        return  pacificList.stream().filter(integers -> atlanticList.contains(integers)).collect(toList());
    }

    public void bfs(int[][] grid, int i, int j, List<List<Integer>> list, boolean[][] visited){
        // queue,实现平面扩展
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;

        while (queue.size() != 0){
            int[] current = queue.poll();
            list.add(Arrays.stream(current).boxed().collect(toList()));

            for (int[] direction : directions){
                int newi = current[0] + direction[0];
                int newj = current[1] + direction[1];

                if (validPoint(grid, newi, newj) && grid[newi][newj] >= grid[current[0]][current[1]] && !visited[newi][newj]){
                    queue.offer(new int[]{newi, newj});
                    visited[newi][newj] = true;
                }
            }
        }
    }

    public boolean validPoint(int[][] grid, int i, int j){
        return i >= 0 && j >= 0 && i< grid.length && j < grid[0].length;
    }

    public static void main(String[] args) {
        InterOfArea417 graph = new InterOfArea417();
        int[][] array = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> result = graph.pacificAtlantic(array);
        System.out.println();
        System.out.println(result);
    }
}
