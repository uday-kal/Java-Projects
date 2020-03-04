import java.util.ArrayList;

public class Directory implements FSElement{

	private ArrayList<FSElement> filelist = new ArrayList<FSElement>();
	private String filename;
	private int depth;

	//Constructs a new directory with a name for it and a the depth with the files
	public Directory(String name, int depth)
	{
		this.filename = name;
		this.depth = depth;
	}

	//Constructs a new directory with a given name
	public Directory(String name)
	{
		this.filename = name;
		depth = 0;
	}

	//Default directory with name set to . and a 0 depth
	public Directory()
	{
		filename = ".";
		depth = 0;
	}

	@Override 
	//returns the name of the directory
	public String name()
	{
		return filename + "/";
	}

	@Override
	//sets the name of the directory
	public void rename(String name) {
		filename = name;
	}

	//returns the name of the directory
	public int getDepth()
	{
		return depth;
	}

	//sets the depth of the directory
	public void setDepth(int depth)
	{
		this.depth = depth;
	}

	//adds an element to the list of directorys
	public void add(FSElement elem)
	{
		if(elem instanceof Directory)
		{
			//sets the depth to be one higher if the element is another directory
			((Directory) elem).setDepth(depth+1);
		}

		filelist.add(elem);

	}

	//gets a specified file fromt the directory
	public FSElement get(int i)
	{
		return filelist.get(i);
	}
	
	//remvoes a file from the directory at a given index
	public FSElement remove(int i)
	{
		FSElement ret = filelist.get(i);
		filelist.remove(i);
		return ret;
	}

	//remove the specified file from the index
	public boolean remove(FSElement elem) 
	{
		if (filelist.contains(elem))
		{
			filelist.remove(elem);
			return true;
		}
		return false;
	}

	//returns the size of the directory
	public int numElements()
	{
		return filelist.size();
	}

	//checks if the directory is the default one
	public boolean isDefault()
	{
		if (filename == ".")
			return true;
		else
			return false;
	}

	@Override 
	//has all files in the directory runt he validate method
	public void validate() throws Exception
	{
		for (FSElement file: filelist)
			file.validate();
	}

	@Override 
	//List the files in the directory
	public String toString()
	{
		String ret = "";

		//All files in the list
		for (FSElement file: filelist)
		{
			//Creates a another equal for the depth of each file
			for (int i = 0; i <= depth; i++)
			{
				ret += "=";
			}
			
			//adds to string to be returned
			ret += "> " + file.name() + "\n";
			ret += file.toString() + "\n";
		}

		return ret; 
	}

}
