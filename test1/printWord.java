public class printWord {
	public static void main(String[] args) {
		Method m = new Method();
		m.method();
	}
}
class Method {
	public void method () {
		// 打印字母

		for(char word = 'a'; word < 'z' ; word++) {
			System.out.println(word);
		}
	}
}