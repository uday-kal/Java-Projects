
public class IDFile extends FileElement{

	private IDInfo info;
	
	//creates new id that is a file with a name and content
	public IDFile(IDInfo id)
	{
		super(id.getName() , id.toString());
		info = id;
	}

	//returns the id information 
	public IDInfo getId()
	{
		return info;
	}

	//does nothing since there are no contents
	public void setContents(String contents) {}

}
