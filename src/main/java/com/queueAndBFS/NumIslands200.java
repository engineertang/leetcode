package com.queueAndBFS;

import java.util.LinkedList;
import java.util.Queue;

// 岛的数量
public class NumIslands200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbors.add((row - 1) * nc + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            neighbors.add((row + 1) * nc + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbors.add(row * nc + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            neighbors.add(row * nc + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        NumIslands200 bfs = new NumIslands200();
        int number = bfs.numIslands(grid);
        System.out.println(number);
    }

    /**
     * Return the length of the shortest path between root and target node.
     */
/*    int BFS(Node root, Node target) {
        Queue<Node> queue;  // store all nodes which are waiting to be processed
        int step = 0;       // number of steps neeeded from root to current node
        // initialize
        add root to queue;
        // BFS
        while (queue is not empty) {
            // iterate the nodes which are already in the queue
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Node cur = the first node in queue;
                return step if cur is target;
                for (Node next : the neighbors of cur) {
                    add next to queue;
                }
                remove the first node from queue;
            }
            step = step + 1;
        }
        return -1;          // there is no path from root to target
    }*/
}
