class fb {
	public static void main(String[] args) {
		
		Method m = new Method();
		m.method();
	}
}
class Method {
	public void method() {
		

		
		int [] array = new int[20];
		array[0] = 1;
		array[1] = 1;
		for(int i=2;i< 20;i++) {
			array[i] = array[i-1] + array[i-2];
		}
		for(int i=0;i<20;i++) {
			System.out.print(" " + array[i] + " ");
		}
	}


}