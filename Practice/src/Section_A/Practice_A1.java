package Section_A;

public class Practice_A1 {
	
	String pname;
	int pid;
	Practice_A2 pa2;
	Practice_A1(String pname,int pid){
		this.pname=pname;
		this.pid=pid;
	}
	public Practice_A2 setPractice_A2(Practice_A2 pa2) {
		return this.pa2=pa2;
	}
	Practice_A3 pa3= new Practice_A3("geetha");
	void pa3m() {
	System.out.println(pa3.teacher);
	}
	Practice_A1(Practice_A4 pa4){
		System.out.println(pa4.mark);
	}
	@Override
	public String toString() {
	    return "Practice_A1 [pname=" + pname +
	           ", pid=" + pid +
	           ", pa2=" + pa2 + "]";
	}

	

	public static void main(String[] args) {
		Practice_A2 obj=new Practice_A2("varun",12,'a');
		Practice_A1 obj1= new Practice_A1("vishwa",21);
		obj1.setPractice_A2(obj);
		System.out.println(obj1.pa2.grade);
		obj1.pa3m();
		Practice_A1 objA11= new Practice_A1(new Practice_A4(50));

	}

}
