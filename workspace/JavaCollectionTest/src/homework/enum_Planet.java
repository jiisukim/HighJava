package homework;

public class enum_Planet {
/*
문제) 태양계 행성을 나타내는 enum Planet을 이용하여 구하시오.
(단, enum 객체 생성시 반지름을 이용하도록 정의하시오.) 

예) 행성의 반지름(KM):
수성(2439), 
금성(6052), 
지구(6371), 
성(3390), 
목성(69911), 
토성(58232), 
천왕성(25362), 
해왕성(24622)
 * 
 */
	public static void main(String[] args) {

		for(Planet pnt : Planet.values()) {
			System.out.println(pnt+"의 면적 : "+pnt.getPnt()+"Km²");
		}

	}
	public enum Planet{
		수성(2439), 
		금성(6052), 
		지구(6371), 
		성(3390), 
		목성(69911), 
		토성(58232), 
		천왕성(25362), 
		해왕성(24622);
		
		private double pnt;
		
		Planet(double data){
			this.pnt = data;
		}
		public double getPnt() {
			return (4*3.141592*Math.pow(pnt, 2));
		}		
	}
}
