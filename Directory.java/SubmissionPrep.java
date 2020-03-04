import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SubmissionPrep {

	public static void main(String[] args) throws FileNotFoundException, Exception {
		// TODO Auto-generated method stub
		
		//Checks if the list has atleast 6 arguements
		if( args.length < 6)
		{	
			System.err.println("Requires 6 or more arguements");
			System.exit(0);
		}
		else
		{
			
			Directory dir = new Directory();
			
			//Starting at the end, it reads the info and uses it accordingly
			for(int i=6; i >= 0; i--)
			{
				//gets the index of the type
				if (args[i].indexOf(".java") != -1)
				{
					//creates a file to be read from the file location
					File text = new File("C:\\Users\\Uday Kalvakota\\Desktop\\CS 211\\Labs\\Project3\\src" + args[i]);
					Scanner scan = new Scanner(text);
					String file = "";
					
					//goes through the file and adds a new line to the end of each one
					while(scan.hasNextLine())
					{
						file.concat(scan.nextLine());
						file.concat("\n");
					}
					
					SourceCode source = new SourceCode(args[i] , file);
					
					//check if each file is a proper java file
					if(source.getType() != ".java")
					{
						//adds the valid file to the directory
						FileElement fileE = new FileElement(args[i] , file);
						dir.add(fileE);
					}
					else
					{
						//if unable it will adds the source to the directory
						dir.add(source);
					}
					
					scan.close();
				}
			}
			
			//Creates a filter to process each file
			ChainFilter filter = new ChainFilter();
			//Creates an id using the arguements
			IDInfo info = new IDInfo(args[0] , args[1] , args[2], args[3] , args[4]);
			//Creates an idfile that can be added to other files and directories
			IDFile idfile = new IDFile(info);
			
			//adds the id to the directory
			dir.add(idfile);
			
			//Creates a submitFolder using under the name given
			SubmitFolder folder = new SubmitFolder(args[5], info);
			
			//adds the folder to the filter to be processed
			filter.add(folder);
			
			System.out.println(filter.process(dir));
		}	

	}

}
