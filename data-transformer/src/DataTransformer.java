import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;

public class DataTransformer {
	
	   static void modifyFile(String filePath)
	    {
	        File inputFile = new File(filePath);
	        File outputFile = new File(filePath+"_mod");
	        
	        String separator = ",";
	         
	         
	        BufferedReader reader = null;
	        BufferedWriter writer = null;
	         
	        //FileWriter writer = null;
	        
	        try
	        {
	            reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile))); 
	            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile))); 
	            //Reading all the lines of input text file into oldContent
	             
	            String line = reader.readLine();
	            String fileName=null;
	            while (line != null) 
	            {
	            	List<String> fieldsList = Arrays.asList(line.split(","));
	            	String code = fieldsList.get(0);
	            	String valeur = fieldsList.get(1);
	            	if(code.equals("S00.G00.00.000")){
	            		fileName = valeur;
	            	} 
            		writer.write(line+separator+fileName);
		            writer.newLine();
	            	line = reader.readLine();
		            	
	            }

	             
	        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            try
	            {
	                 
	                reader.close();
	                 
	                writer.close();
	            } 
	            catch (IOException e) 
	            {
	                e.printStackTrace();
	            }
	        }
	    }
	     
	    /*public static void main(String[] args)
	    {
	    	modifyFile("C:/Users/ba-m/Desktop/DSN/data/DSNJPROD20180320.txt");
	         
	        System.out.println("done");
	    }*/

}
