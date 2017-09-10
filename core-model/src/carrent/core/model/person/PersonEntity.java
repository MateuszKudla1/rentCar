package carrent.core.model.person;


public interface PersonEntity {

	public String getPassword();

	public void setPassword(String customerPassword);

	public String getFirstName();

	public void setFirstName(String firstName);

	public Long getId();

	public void setId(Long id);

	public String getLastName();

	public void setLastName(String lastName);

	public String getPesel();

	public void setPesel(String pesel);

	//String getIdNumber();
}
