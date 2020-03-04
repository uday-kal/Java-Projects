
public class FileInserter implements FSFilter{

	private FSElement file;
	
	//Creates a file inserter  with a given file inside
	public FileInserter(FSElement file)
	{
		this.file = file;
	}
	
	@Override
	//process the element, adding the file to the given element
	//throws an exception if the element is not a directory
	public FSElement process(FSElement elem) throws Exception {
		
		//checks if a directory
		if(elem instanceof Directory)
		{
			((Directory) elem).add(file);
			return elem;
		}
		else
			throw new Exception ("inserting file into non-directory");
		
	}

}
