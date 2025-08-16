import java.util.*;
class maximalRec {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;
        
        for (char[] row : matrix) {
            // Build the heights array
            for (int j = 0; j < cols; j++) {
                if (row[j] == '1') heights[j] += 1;
                else heights[j] = 0;
            }
            
            // Calculate largest rectangle in current histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        
        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int[] extended = Arrays.copyOf(heights, heights.length + 1); // Add a zero at end

        for (int i = 0; i < extended.length; i++) {
            while (!stack.isEmpty() && extended[i] < extended[stack.peek()]) {
                int height = extended[stack.pop()];
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }

        return max;
    }
}