
public class SourceCode extends FileElement{

	//Creates a sourcecode with a name and content
	public SourceCode(String name, String contents) 
	{
		super(name , contents);
	}

	//gets the file type fromt the name
	public String getType() 
	{
		int period = super.name().indexOf(".");

		//returns the part of the name after the period
		return super.name().substring(period+1, super.name().length());
	}

	//Checks if the file is a proper java class, if not it throws an exception
	public void validate() throws Exception
	{
		//FOR SOMEREASON THIS IF STATEMENT DOES NOT WORK AND IVE TRIED EVERYTHING
		if (getType() == "java")
		{
			int period = super.name().indexOf(".");
			String name = super.name().substring(0, period);
			//get the file name without the type

			//if the name is not in the code, it throws an exception
			if (super.toString().contains(name) == false)
			{
				throw new Exception("java source file missing class name: " + name);
			}

		}
	}
}
