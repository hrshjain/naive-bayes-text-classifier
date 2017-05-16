import java.io.*;
import java.util.*;

public class Doc{
	
	public String name;
	public Line line[];
	public Scanner x;
	public int numberofWords;
	public int vocab;
	
	public Doc(String name){
		line = new Line[500];
		this.name = name;
	}
	

	public void readfile(){	
		try{
		x = new Scanner(new File(name));
		}
		catch(Exception e){
			System.out.println("Could not find file");
		}
		for(int i = 0;x.hasNext();i++){
			String a = x.nextLine();
			line[i] = new Line(a,i,name);
			line[i].assignlabel();
			//System.out.println(line[i].content);		
		}
	}
	
	public int CalculatenumberofWords(){
		
		try{
		x = new Scanner(new File(name));
		}
	
		catch(Exception e){
			System.out.println("Could not find file");
		}
		int count=0;
		while(x.hasNext()){
			x.next();
			count++;
		}	
		return count;
	}
	
	public int makeWordList(){
		try{
		x = new Scanner(new File(name));
		}
		
		catch(Exception e){
			System.out.println("Could not find file");
		}
		
		ArrayList<String> listOfWords = new ArrayList<String>();
		while(x.hasNext()){
		   String word = x.next(); //scanner automatically uses " " as a delimeter
		   if(!listOfWords.contains(word)){ //add the word if it isn't added already
		   listOfWords.add(word);
		   }
		}
		return listOfWords.size(); //return the list you made of distinct words
	
	}
	
	public int LabelOneWords(){
		
		try{
		x = new Scanner(new File(name));
		}
		catch(Exception e){
			System.out.println("Could not find file");
		}
		int count=0;
		
		for(int i = 0;x.hasNext();i++){
			String a = x.nextLine();
			
			if(line[i].label_original.matches("1")){
				//System.out.println(line[i].label_original);
				count = count + a.split(" ").length;
			}
		}
	
		return count;
	}
	
	public int LabelZeroWords(){
		
		try{
		x = new Scanner(new File(name));
		}
		catch(Exception e){
			System.out.println("Could not find file");
		}
		int count=0;
		
		for(int i = 0;x.hasNext();i++){
			String a = x.nextLine();

			if(line[i].label_original.matches("0")){
				//System.out.println(line[i].label_original);
				count = count + a.split(" ").length;
			}
			
		}
	
		return count;
	}
	
	public int wordoccurencelabel1(String word){
		
		try{
		x = new Scanner(new File(name));
		}
		catch(Exception e){
			System.out.println("Could not find file");
		}
		int count=0;
		
		for(int i = 0;x.hasNext();i++){
			String a = x.nextLine();
			
			if(line[i].label_original.matches("1") && a.contains(word)){
				//System.out.println(line[i].label_original);
				count = count + 1;
			}
		}
	
		return count;
	} 
	
	public int wordoccurencelabel0(String word){
		
		try{
		x = new Scanner(new File(name));
		}
		catch(Exception e){
			System.out.println("Could not find file");
		}
		int count=0;
		
		for(int i = 0;x.hasNext();i++){
			String a = x.nextLine();
			
			if(line[i].label_original.matches("0") && a.contains(word)){
				//System.out.println(line[i].label_original);
				count = count + 1;
			}
		}
	
		return count;
	} 
	
	public int label1count(){
		
		try{
		x = new Scanner(new File(name));
		}
		catch(Exception e){
			System.out.println("Could not find file");
		}
		int count=0;
		
		for(int i = 0;x.hasNext();i++){
			String a = x.nextLine();
			
			if(line[i].label_original.matches("1")){
				count = count + 1;
			}
		}
	
		return count;
	} 
	
	public int label0count(){
		
		try{
		x = new Scanner(new File(name));
		}
		catch(Exception e){
			System.out.println("Could not find file");
		}
		int count=0;
		
		for(int i = 0;x.hasNext();i++){
			String a = x.nextLine();
			
			if(line[i].label_original.matches("0")){
				count = count + 1;
			}
		}
	
		return count;
	} 
	
	public double Problabel1(){
		
		double a = label1count();
		double b  = label0count();
		
		double prob = a/(a + b);

		
		return prob;
		
	}
	
	public double Problabel0(){
		
		double a = label1count();
		double b  = label0count();
		
		double prob = b/(a + b);

		
		return prob;
		
	}
	
	

	public void closefile(){
		
		x.close();
		
	}
	
	
		
	}
	
	
