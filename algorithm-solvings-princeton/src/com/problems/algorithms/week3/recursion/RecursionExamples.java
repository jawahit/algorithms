/**
 * 
 */
package com.problems.algorithms.week3.recursion;

/**
 * This class {@code RecursionExamples} contains some of the examples solved by
 * recursion
 * 
 * @author Thangaraj Jawahar
 *
 */
public class RecursionExamples {

	/**
	 * @param args
	 */
	static int count = 0;

	public static void main(String[] args) {
		System.out.println("Recursive print of Array of Array of same kind : ");
		recursivePrint();
		System.out.println("Reverse a string :" + reverse("jawahar", -1));
		System.out.println("Factorial of 5 : " + factorial(5));
		System.out.println("Fibonacci nth 5 :" + fibonacci(5));
		String s = "madam";
		System.out.println("is string palindrome : " + isPalindrome(s, 0, s.length() - 1));
		System.out.println("Greatest Common Factor / GCD " + gcd(12, 3));
		System.out.println("Greatest Common Factor / GCD " + gcd1(7, 6));
		System.out.println("Greatest Common Factor / GCD1 " + gcd1(13, 3));
		System.out.println(6 % 89);
		System.out.println("Method Execute count: " + count);
		System.out.println("Log 2 base value :" + log2BaseApproxValue(24, 2));
		System.out.println("Happy Value :" + isHappyNumber(23));

	}

	public static void recursivePrint() {
		Company[] companies = prepareCompanies();
		rotateCompanies(companies, "-");
	}

	/**
	 * @return
	 */
	private static Company[] prepareCompanies() {
		Company c = new Company();
		c.setTitle("Alphabet");
		Company[] childrens = new Company[2];
		Company c1 = new Company();
		c1.setTitle("Google");
		Company c1a = new Company();
		c1a.setTitle("Youtube");
		Company c1b = new Company();
		c1b.setTitle("Android");
		childrens[0] = c1a;
		childrens[1] = c1b;
		c1.setChildren(childrens);
		Company[] childrenAlphabet = new Company[2];
		childrenAlphabet[0] = c1;
		Company c2 = new Company();
		c2.setTitle("Waymo");
		childrenAlphabet[1] = c2;
		c.setChildren(childrenAlphabet);
		Company d = new Company();
		d.setTitle("Bookings Inc");
		Company[] companies = new Company[2];
		companies[0] = c;
		companies[1] = d;
		return companies;
	}

	/**
	 * iterate array of array of same kind
	 * 
	 * @param companies
	 * @param s
	 */
	public static void rotateCompanies(Company[] companies, String s) {
		for (Company c : companies) {
			System.out.println(s + " " + c.getTitle());
			if (c.getChildren() != null) {
				rotateCompanies(c.getChildren(), s + "-");
			}
		}
	}

	/**
	 * reverse a given string
	 * 
	 * @param s
	 * @param count
	 * @return
	 */
	public static String reverse(String s, int count) {
		if (count == s.length() - 1)
			return "";
		return reverse(s, ++count) + s.charAt(count);
	}

	/**
	 * factorial of a given number
	 * 
	 * @param n
	 * @return
	 */
	public static int factorial(int n) {
		if (n <= 1)
			return 1;
		return n * factorial(--n);
	}

	/**
	 * nth fibonacci number
	 * 
	 * @param f
	 * @return
	 */
	public static int fibonacci(int f) {
		if (f == 0)
			return 0;
		if (f == 1)
			return 1;
		return fibonacci(f - 1) + fibonacci(f - 2);
	}

	/**
	 * is palindrome ?
	 * 
	 * @param s
	 * @param fronIndex
	 * @param backIndex
	 * @return
	 */
	public static boolean isPalindrome(String s, int fronIndex, int backIndex) {
		if (fronIndex >= backIndex)
			return true;
		if (s.charAt(fronIndex) == s.charAt(backIndex)) {
			return isPalindrome(s, ++fronIndex, --backIndex);
		}
		return false;
	}

	/**
	 * Greatest common divisor (gcd) for the two numbers always pass m - bigger
	 * value n - smaller value so that method execution count will be less
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public static int gcd(int m, int n) {
		count++; // just to check how many times method got executed
		if (m % n == 0) {
			return n;
		}
		return gcd(n, m % n);
	}

	public static int gcd1(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}

	/**
	 * 
	 * this is the approximate value of log since Log to base of x = base ^ y if we
	 * find the y value exactly only we can get the log value so this is just
	 * approximation if you see the decimals it is not the exacte value
	 * 
	 * @param m
	 * @param b
	 * @return
	 */
	public static double log2BaseApproxValue(double m, int b) {
		return getLog2Value(m, b) - 1;
	}

	public static double getLog2Value(double m, int b) {
		if (m <= 1) {
			return m;
		}
		return 1 + getLog2Value(m / b, b);
	}

	/**
	 * this method is to verify the sum of squares of integer is resolves to 1 For
	 * Ex1: s = 100 output : 1^2 + 0^2 + 0^2 = 1 so its happy number Ex2: s = 19 1^2
	 * + 9^2 = 81 8^2 + 1^2 = 68 6^2 + 8^2 = 100 1^2 + 0^2 + 0^2 = 1 so 19 is happy
	 * number
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isHappyNumber(int s) {
		if (s == 1)
			return true;
		if (s / 10 == 0)
			return false;
		else {
			int div = s;
			int sum = 0;
			while (div > 0) {
				int mod = div % 10;
				sum += Math.pow(mod, 2);
				div = div / 10;
			}
			return isHappyNumber(sum);
		}
	}

	private static class Company {
		String title;
		Company[] children;

		/**
		 * @return the title
		 */
		public String getTitle() {
			return title;
		}

		/**
		 * @param title the title to set
		 */
		public void setTitle(String title) {
			this.title = title;
		}

		/**
		 * @return the children
		 */
		public Company[] getChildren() {
			return children;
		}

		/**
		 * @param children the children to set
		 */
		public void setChildren(Company[] children) {
			this.children = children;
		}

	}

}
