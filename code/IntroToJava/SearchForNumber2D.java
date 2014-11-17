public class SearchForNumber2D {
    public static void main (String[] args) {
        int[][] nums = { {1, 3, 7, 5},
                         {5, 8, 4, 6},
                         {7, 4, 2, 9} };
        int search = 4;
        foundNumber:
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (nums[i][j] == search) {
                    System.out.println(
                        "Found " + search + " at position " + i + "," + j);
                    break foundNumber;
                }
            }
        }
    }
}
