import java.util.*;
public class numsquare {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.offer(n);
        visited[n] = true;
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++; // each level = 1 more perfect square used

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                for (int j = 1; j * j <= curr; j++) {
                    int next = curr - j * j;

                    if (next == 0) return level; // Found the answer
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }

        return level;
    }
}