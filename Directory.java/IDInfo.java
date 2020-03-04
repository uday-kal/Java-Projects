
public class IDInfo {

	String name;
	String userId;
	String gNum;
	String lecture;
	String lab;

	//creates a new student id with a name, user id, gNumber, a lecture name, and lab number
	public IDInfo(String name, String userId, String gNum, String lecture, String lab)
	{
		this.name = name;
		this.userId = userId;
		this.gNum = gNum;
		this.lecture = lecture;
		this.lab = lab;
	}

	//returns the id name
	public String getName()
	{
		return name;
	}

	//returns the user id number
	public String getUserId()
	{
		return userId;
	}

	//returns the user gnumber
	public String getGNum()
	{
		return gNum;
	}

	//returns the lecutre number
	public String getLecture()
	{
		return lecture;
	}

	//returns the lab number
	public String getLab()
	{
		return lab;
	}

	//formats the id information to a string to be returned
	public String toString()
	{
		String ret = "";
		ret += "Full Name: " + name + "\n";
		ret += "userID: " + userId  + "\n";
		ret += "G#: " + gNum  + "\n";
		ret += "Lecture section: " + lecture + "\n";
		ret += "Lab section: " + lab + "\n";

		return ret;

	}

}
