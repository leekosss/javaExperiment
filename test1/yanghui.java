class Triangle {

	public static void main(String[] args) {
		Method m = new Method();
		m.method();
		//打印杨辉三角
	}
}
class Method {
	public void method() {
		int[][] array = new int[6][];
		for(int i=0; i<array.length; i++) {
			array[i] = new int[i+1];
			for(int j=0; j<=i; j++) {
				if(j==0 || j==i) {
					array[i][j] = 1;
				}else {
					array[i][j] = array[i-1][j] + array[i-1][j-1];
				}
			}
		}
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length ;j++) {
				System.out.printf("%-4d",array[i][j]);
			}
			System.out.println();
		}
	}
}