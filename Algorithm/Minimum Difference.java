/*

Description
Given a 2D array size of n * m and the elements of each row of the array are sorted. Select 1 number from each row and select n numbers in total. And the diff of n numbers is maximum-minimum, find the minimum diff.

Have you met this question in a real interview?  
Example
Input: [[1,2,3,4,5],[6,7,8,9,10]]
Output: 1


*/

/*

You have k lists of sorted integers in ascending order. Find the smallest range that includes at least one number from each of the k lists.

We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.

Example 1:
Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
Output: [20,24]
Explanation: 
List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
List 2: [0, 9, 12, 20], 20 is in range [20,24].
List 3: [5, 18, 22, 30], 22 is in range [20,24].
Note:

*/

public class Solution {
    /**
     * @param array: a 2D array
     * @return: the minimum difference
     */
     
     
     class Element {
		int val;
		int idx;
		int row;

		public Element(int r, int i, int v) {
			val = v;
			idx = i;
			row = r;
		}
	}
    public int minimumDifference(int[][] nums) {
   		PriorityQueue<Element> pq = new PriorityQueue<Element>(new Comparator<Element>() {
			public int compare(Element a, Element b) {
				return a.val - b.val;
			}
		});
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			Element e = new Element(i, 0, nums[i][0]);
			pq.offer(e);
			max = Math.max(max, nums[i][0]);
		}
		int range = Integer.MAX_VALUE;
		int start = -1, end = -1;
		while (pq.size() == nums.length) {

			Element curr = pq.poll();
			if (max - curr.val < range) {
				range = max - curr.val;
				start = curr.val;
				end = max;
			}
			if (curr.idx + 1 < nums[curr.row].length) {
				curr.idx = curr.idx + 1;
				curr.val = nums[curr.row][curr.idx];
				pq.offer(curr);
				if (curr.val > max) {
					max = curr.val;
				}
			}
		}
		
		return end - start;
    }
}
