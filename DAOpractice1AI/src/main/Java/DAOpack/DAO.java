package DAOpack;

public interface DAO {
	
	public DTOfile save(int id);
	public void create(DTOfile dto);
	public void update(DTOfile dto);
	public void delete(DTOfile dto);

}
