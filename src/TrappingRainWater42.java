public class TrappingRainWater42 {

    // Approach 1 ( 3 loop solution )
    private static int trapWater(int[] height){
        int n = height.length;
        int totalWater = 0;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];

        prefixMax[0] = height[0];
        for (int i=1; i<n; i++){
            prefixMax[i] = Math.max(prefixMax[i-1], height[i]);
        }

        suffixMax[n-1] = height[n-1];
        for (int i=n-2; i>=0; i--){
            suffixMax[i] = Math.max(suffixMax[i+1], height[i]);
        }

        for (int i=0; i<n; i++){
            int leftMax = prefixMax[i];
            int rightMax = suffixMax[i];
            if (height[i] < leftMax && height[i] < rightMax) {
                totalWater += Math.min(leftMax, rightMax) - height[i];
            }
        }

        return totalWater;
    }

    // Approach 1 Optimized ( 2 loop solution )
    private static int trapWater_optimized(int[] height){
        int n = height.length;
        int totalWater = 0;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        prefixMax[0] = height[0];
        suffixMax[n-1] = height[n-1];
        int j = 1;
        int k = n-2;
        for (int i=0; i<n; i++){
            if (j < n){
                prefixMax[j] = Math.max(prefixMax[j-1], height[j]);
                j++;
            }
            if (k >= 0){
               suffixMax[k] = Math.max(suffixMax[k+1], height[k]);
               k--;
            }
        }
        for (int i=0; i<n; i++){
            int leftMax = prefixMax[i];
            int rightMax = suffixMax[i];
            if (height[i] < leftMax && height[i] < rightMax){
                totalWater += Math.min(leftMax,rightMax) - height[i];
            }
        }
        return totalWater;
    }

    // optimal solution using two pointer
    private static int trapWater_optimal(int[] height){
        int n = height.length;
        int left = 0;
        int right = n-1;
        int leftMax = height[left];
        int rightMax = height[right];
        int totalWater = 0;
        while (left < right){
            if (height[left] < height[right]){
                left++;
                leftMax = Math.max(leftMax, height[left]);
                totalWater += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                totalWater += rightMax - height[right];
            }
        }
        return totalWater;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("total trapped rain water : "+trapWater_optimal(arr));
        arr = new int[] {4,2,0,3,2,5};
        System.out.println("total trapped rain water is : "+trapWater_optimal(arr));
    }
}
