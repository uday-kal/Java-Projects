
public class FSValidator implements FSFilter{
	
	@Override 
	//Checks and validates the element and returns the it
	public FSElement process(FSElement elem) throws Exception
	{
		elem.validate();
		return elem;
	}

}
