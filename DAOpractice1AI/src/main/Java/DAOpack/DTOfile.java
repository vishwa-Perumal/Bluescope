package DAOpack;

public class DTOfile {
	
	private int id;
	private String ename;
	private String role;
	
    DTOfile(int id, String ename,String role){
    	this.id = id;
    	this.ename=ename;
    	this.role=role;
    }
    //getter
    public int getId() {
    	return id;
    }
    public String getename() {
    	return ename;
    }
    public String getrole() {
    	return role;
    }
    //setter
    public void  setId(int id) {
    	this.id=id;
    }
	public void setename(String ename) {
    	this.ename=ename;
    }
    public void setrole(String role) {
    	this.role = role;
    }
    
    
    @Override
  	public String toString() {
  		// TODO Auto-generated method stub
  		return super.toString();
  	}
    
    

}
