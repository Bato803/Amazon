public class GetEnd {


	public static void main(String[] args) {

		int[] nums = new int[]{1, 0, 0, 0, 0, 0, 1};

		System.out.println(getEnd(nums, 6));
	}

	public static boolean getEnd(int[] nums, int step) {

		if (nums == null || nums.length == 0) {

			return true;
		}

		int n = nums.length;

		boolean[] dp = new boolean[n];

		dp[0] = true;

		for (int i = 0; i < nums.length; i++) {

			if (!dp[i]) {

				continue;
			}

			if (i - 1 >= 0 && nums[i - 1] == 1) {

				dp[i - 1] = true;

				if (i + step - 1 <= nums.length - 1 && nums[i + step - 1] == 1) {
					dp[i + step - 1] = true;
				}
			}

			if (i + 1 <= nums.length - 1 && nums[i + 1] == 1) {

				dp[i + 1] = true;
				if (i + step + 1 <= nums.length - 1 && nums[i + step + 1] == 1) {
					dp[i + step + 1] = true;
				}
			}

			if (i + step <= nums.length - 1 && nums[i + step] == 1) {
				dp[i + step] = true;
			}


		}

		return dp[n - 1];


	}

}
