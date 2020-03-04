
public class FileElement implements FSElement{

	private String filename;
	private String contents;
	
	//Creates a file with a given name and content
	public FileElement(String name, String contents) {
		this.filename = name;
		this.contents = contents;
	}
	
	@Override 
	//does nothing
	public void validate() throws Exception {};
	
	//sets the contents to the specified ones
	public void setContents(String contents) 
	{
		this.contents = contents;
	}
	
	@Override 
	//returnt he contents of the file
	public String toString()
	{
		return contents;
	}



	@Override
	//sets the name of the file to the specified one
	public void rename(String name) {
		filename = name;
		
	}

	@Override
	//returns the name of the file
	public String name() {
		return filename;
	}


}
