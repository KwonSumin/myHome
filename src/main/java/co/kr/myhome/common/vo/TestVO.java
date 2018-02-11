package co.kr.myhome.common.vo;

public class TestVO extends AbstracCommonVO {
	String name;
	int age;
	public TestVO(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public static void main(String[] args) throws Exception {
		TestVO vo = new TestVO("sumin",31);
		System.out.println(vo.toJson());
		System.out.println(vo.toString());
	}
	
}
