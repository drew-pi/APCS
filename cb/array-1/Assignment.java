

public class Assignment {

	public static boolean firstLast6(int[] nums) {
	    if ((nums[0] == 6) || (nums[nums.length] == 6)) {
	        return true;
	    } return false;
	}


	public static boolean commonEnd(int[] a, int[] b) {
    	return ((a[0] == b[0]) || (a[a.length-1] == b[b.length-1]));
  	}


 	 public static int[] makePi() {
    	int[] a = {3, 1, 4};
    	return a;
  	}

	public static int[] maxEnd3(int[] nums) {
		int max;
		if (nums[0] >= nums[2]) {
	 		max = nums[0];
		} else {
		  max = nums[2];
		}
		for (int i = 0; i < 3; i++) {
		  nums[i] = max;
		}
		return nums;
	}


  	public static int[] middleWay(int[] a, int[] b) {
    	int[] c = new int[2];
    	c[0] = a[1];
    	c[1] = b[1];
    	return c;
  	}	


	public static int[] reverse3(int[] nums) {
		int[] ans = new int[3];
		ans[0] = nums[2];
		ans[2] = nums[0];
		ans[1] = nums[1];
		return ans;
	}


	public static int[] rotateLeft3(int[] nums) {
	    int[] ans = new int[3];
	    for (int i = 1; i < nums.length; i++) {
	      ans[i-1] = nums[i];
	    }
	    ans[ans.length-1] = nums[0];
	    return ans;
  	}


  	public static boolean sameFirstLast(int[] nums) {
      	return ((nums.length >= 1) && (nums[0] == nums[nums.length-1]));
  	}


  	public static int sum2(int[] nums) {
	    if (nums.length == 0) {
	      return 0;
	    } else if (nums.length == 1) {
	      return nums[0];
	    } else {
	      return nums[0] + nums[1];
	    }
  	}


  	public static int sum3(int[] nums) {
	    int sum = 0;
	    for (int num : nums) {
	      sum += num;
	    }
	    return sum;
  	}

}