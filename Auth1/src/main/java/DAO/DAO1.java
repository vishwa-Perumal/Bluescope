package DAO;

public interface DAO1 {
	public DTO get(String enname,String enpassword);
	public void create (DTO dto);
	public void update (DTO dto);
	public void delete (DTO dto);

}
