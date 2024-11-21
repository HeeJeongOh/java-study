package prob04;

public class StringUtil {

	public static String concatenate(String[] strArr) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		for(String str : strArr) {
			sb.append(str);
		}
		return sb.toString();
	}
}
