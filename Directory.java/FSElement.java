
public interface FSElement {
	//name of file
	public String name();
	//rename the file
	public void rename(String name);
	//processes the file
	public void validate() throws Exception;
}
