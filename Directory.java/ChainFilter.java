import java.util.ArrayList;

public class ChainFilter implements FSFilter{
	
	ArrayList<FSFilter> filters;

	//Adds a new filter to the current list of filters
	public void add(FSFilter filter)
	{
		filters.add(filter);
	}
	
	@Override
	//overides the process method in FSFilter
	//Has each filter process the FSElemeent given
	//returns the element
	public FSElement process(FSElement elem) throws Exception {
		for (FSFilter filter: filters)
			filter.process(elem);
		return elem;
	}
	
	

}
