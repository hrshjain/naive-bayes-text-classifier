import java.io.*;
import java.util.*;

public class Test{
	
	public static void main(String args[]){
		
		double prob_label1;
		double prob_label0;
		String currentword;
		Formatter newfile_train;
		Formatter newfile_test;
		
		
		
		/*try{
			newfile_test = new Formatter("testlabels_new.txt");		
		}
		catch(Exception e){
			System.out.println("Could not find file");
		}*/
		
		//reading training data
		
		Doc TrainData = new Doc("traindata.txt");
		TrainData.readfile();
		
		//reading test data
		
		Doc TestData = new Doc("testdata.txt");
		TestData.readfile();
		
		//calculating class in Training data
		
		try(PrintWriter writer = new PrintWriter("trainlabels_new.txt")){
			
			for (int j=0;j<322;j++){
			
				prob_label1 = TrainData.Problabel1();
				
				for (int i=0;i<TrainData.line[j].words.length;i++){
					
					//System.out.println(TrainData.line[0].words[i]);

					currentword = TrainData.line[j].words[i];
					
					prob_label1 = prob_label1*((double)TrainData.wordoccurencelabel1(currentword) + 1)/((double)TrainData.LabelOneWords() + (double)TrainData.makeWordList());
					
					
				}
				
				//System.out.println("Probability for label1 is " + prob_label1);
				
				prob_label0 = TrainData.Problabel0();
				
				for (int i=0;i<TrainData.line[j].words.length;i++){
					
					//System.out.println(TrainData.line[0].words[i]);

					currentword = TrainData.line[j].words[i];
					
					prob_label0 = prob_label0*((double)TrainData.wordoccurencelabel0(currentword) + 1)/((double)TrainData.LabelZeroWords() + (double)TrainData.makeWordList());
				
				}
				
				//System.out.println("Probability for label0 is " + prob_label0);
				
				if(prob_label1>prob_label0){
					TrainData.line[j].label_new = "1";
				}
				else{
					TrainData.line[j].label_new = "0";
				}
				
				
				//System.out.println("Class for this line is " + TrainData.line[j].label_new);
				
				writer.println(TrainData.line[j].label_new);
		}
		}catch(Exception e){
			System.out.println("Could not find file");
	}
	
	//Calculation of accuracy for Training data
	
	int match = 0;
	
	for (int k=0;k<322;k++){
		
		if(TrainData.line[k].label_original.matches(TrainData.line[k].label_new)){
			match++;
		}
		
	}
	
	double accuracy = ((double)match*100)/322;
	
	System.out.println("Accuracy for train data is " + accuracy + "%.");
	
	
	//calculating class of Testing data
		
		try(PrintWriter writer2 = new PrintWriter("testlabels_new.txt")){
			
			for (int j=0;j<101;j++){
			
				prob_label1 = TrainData.Problabel1();
				
				for (int i=0;i<TestData.line[j].words.length;i++){
					
					//System.out.println(TrainData.line[0].words[i]);

					currentword = TestData.line[j].words[i];
					
					prob_label1 = prob_label1*((double)TrainData.wordoccurencelabel1(currentword) + 1)/((double)TrainData.LabelOneWords() + (double)TrainData.makeWordList());
					
					
				}
				
				//System.out.println("Probability for label1 is " + prob_label1);
				
				prob_label0 = TrainData.Problabel0();
				
				for (int i=0;i<TestData.line[j].words.length;i++){
					
					//System.out.println(TrainData.line[0].words[i]);

					currentword = TestData.line[j].words[i];
					
					prob_label0 = prob_label0*((double)TrainData.wordoccurencelabel0(currentword) + 1)/((double)TrainData.LabelZeroWords() + (double)TrainData.makeWordList());
				
				}
				
				//System.out.println("Probability for label0 is " + prob_label0);
				
				if(prob_label1>prob_label0){
					TestData.line[j].label_new = "1";
				}
				else{
					TestData.line[j].label_new = "0";
				}
				
				
				//System.out.println("Class for this line is " + TrainData.line[j].label_new);
				
				writer2.println(TestData.line[j].label_new);
		}
		}catch(Exception e){
			System.out.println("Could not find file");
	}
	
	//Calculation of accuracy for Testing data
	
	match = 0;
	
	for (int k=0;k<101;k++){
		
		if(TestData.line[k].label_original.matches(TestData.line[k].label_new)){
			match++;
		}
		
	}
	
	accuracy = ((double)match*100)/101;
	
	System.out.println("Accuracy for test data is " + accuracy + "%.");
	
		
	}
	
	
	
}