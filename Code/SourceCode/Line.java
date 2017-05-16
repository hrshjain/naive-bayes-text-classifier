import java.io.*;
import java.util.*;

public class Line{
	
	public String content;
	public String words[];
	public int LineNumber;
	public String label_original;
	public String label_new;
	
	public Scanner getlabels;
	public String docname;
	
	public Line(String content, int LineNumber, String docname){
		
		this.content = content;
		this.LineNumber = LineNumber;
		this.docname = docname;
		
		words = content.split(" "); 
		
	}
	
	public void assignlabel(){
		
	if(docname=="traindata.txt"){
	
		try{
		
			getlabels = new Scanner(new File("trainlabels.txt"));
			
			}
		
			catch(Exception e){
				
				System.out.println("Could not find file");
			}
		
		for (int i=0;i<=LineNumber;i++){
			
			label_original = getlabels.nextLine();
			
		}
	
	}
	
	if(docname=="testdata.txt"){
	
		try{
		
			getlabels = new Scanner(new File("testlabels.txt"));
			
			}
		
			catch(Exception e){
				
				System.out.println("Could not find file");
			}
		
		for (int i=0;i<=LineNumber;i++){
			
			label_original = getlabels.nextLine();
			
		}
	
	}
	
	//System.out.println("docname is " + docname);
		
		
	}
	
	
	
	
	
}