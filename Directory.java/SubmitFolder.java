
public class SubmitFolder implements FSFilter{

	private String dirName;

	//Creates a submitfolder with an appropriate name according to the id and assignment
	public SubmitFolder(String assignment, IDInfo id)
	{ 
		dirName = id.getLab() +"_" + id.getUserId() + "_" + assignment;
	}


	@Override
	//proccess the element into the submitfolder and then added to directory
	public FSElement process(FSElement elem) throws Exception {

		
		Directory basic = new Directory();
		
		//check if the element is a file
		if (elem instanceof FileElement)
		{
			//creates a folder to be added to the directory
			Directory folder = new Directory(dirName);
			folder.add(elem);

			basic.add(folder);
			
			//returns top level directory
			return basic;
		}
		//checks if the element is a directory
		else if (elem instanceof Directory)
		{
			if (((Directory) elem).isDefault() == true)
			{
				//renames the default directory to an appropriate one
				elem.rename(dirName);
				basic.add(elem);
				return basic;
			}

		}

		//elsewise creates a directory and return the added folder
		Directory folder = new Directory(dirName);
		folder.add(elem);

		basic.add(folder);
		return basic;
	}




}
