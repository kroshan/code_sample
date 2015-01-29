

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTest {

	public static void main(String[] args)throws Exception {
	    
			String sCurrentLine;
			//System.out.println("filename:" +args[0]);
			//expected C:\\data\\testing.txt
			String filename = "testing.txt";//args[0]
	    	BufferedReader br = new BufferedReader(new FileReader(filename));
	    	List<String> lstAllLines = new ArrayList<String>();
	    	while ((sCurrentLine = br.readLine()) != null) {
				//System.out.println(sCurrentLine);
				lstAllLines.add(sCurrentLine);
			}
	    	String[][] aa = new String[lstAllLines.size()][];
	    	for(int i = 0;i<lstAllLines.size();i++){
	    		String strValue = lstAllLines.get(i);
	    		String[] sVal = strValue.split(",");
	    		aa[i] = new String[sVal.length];
	    		aa[i] = sVal;
	    	}

		int m = aa[0].length;
		int n = aa.length;
		 
		SpiralOrderTest so = new SpiralOrderTest();
		System.out.println(so.getSpiralString(n, m, aa));
		

	}

	private String getSpiralString(int m, int n, String a[][]) {
		StringBuilder sb = new StringBuilder();
		int i, k = 0, l = 0;
		while (k < m && l < n) {
			for (i = l; i < n; ++i) {
				sb.append(a[k][i]);
				sb.append(" ");
			}
			k++;
			/* get the last column from the remaining k columns */
			for (i = k; i < m; ++i) {
				sb.append(a[i][n - 1]);
				sb.append(" ");
			}
			n--;
			/* get the last row from the remaining rows */
			if (k < m) {
				for (i = n - 1; i >= l; --i) {
					sb.append(a[m - 1][i]);
					sb.append(" ");
				}
				m--;
			}
			/* get first column from the remaining columns */
			if (l < n) {
				for (i = m - 1; i >= k; --i) {
					sb.append(a[i][l]);
					sb.append(" ");
				}
				l++;
			}
		}
		return sb.toString();
	}

}

/*CODE SAMPLE EXERCISE REQUIRED WITH  SUBMITTALS - see below.   
Given a “n x m” array (n & m could be different or same numbers), print the contents of the array in a spiral order (i.e. print the outermost elements followed by the next inner layer followed by the next inner layer and so on until all elements are printed) in a clockwise manner. Note that all elements of the array should be printed only once.
The input could be either read from a text file or from a command prompt and the output should be printed on a console.
*/ 