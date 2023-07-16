class multiply{
	public static void main(String[] args) {
		
		Method m = new Method();
		m.method();
	}
}
class Method{
	public void method() {
		for(int i=1;i<=9;i++) {
			for(int j=i;j<=9;j++) {
				// System.out.print(i + "*" +j +"="+ i*j +" ");
				System.out.printf("%d * %d = %-4d",i,j,i*j);
			}
			System.out.println();
		}
	}
}