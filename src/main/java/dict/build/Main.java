/**
 * 
 */
package dict.build;

/**
 * @author zhangcheng
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		if (args.length == 0) {
			System.out.println("rawpath");
			return;
		}
		
		String rawpath = null;
		float min_e = 2.0f;
		float min_pmi = 1.0f;
		if (args.length == 1) {
			rawpath = args[0];
		}
		else if (args.length == 2){
			rawpath = args[0];
			min_pmi = Float.parseFloat(args[1]);
		}
		else  if(args.length == 3){
			rawpath = args[0];
			min_pmi = Float.parseFloat(args[1]);
			min_e = Float.parseFloat(args[2]);
		}
		String left = null;
		String right = null;
		String entropyfile = null;

		FastBuilder builder = new FastBuilder();

		if (null == right)
			right = builder.genFreqRight(rawpath, 6, 10 * 1024);
		if (null == left)
			left = builder.genLeft(rawpath, 6, 10 * 1024);
		if (null == entropyfile)
			entropyfile = builder.mergeEntropy(right, left);

		builder.extractWords(right, entropyfile, min_pmi, min_e);
	}
}
