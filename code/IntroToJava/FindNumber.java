public class FindNumber {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: FindNumber <num>");
            return;
        }
        int[] numbers = {1, 3, 4, 5, 7, 5, 2, 8, 9, 6};
        int findNumber = Integer.parseInt(args[0]);
        System.out.println(find(numbers, findNumber));
    }

    public static int find(int[] nums, int num) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                return i;
            }
        }
        return -1;
    }
}
