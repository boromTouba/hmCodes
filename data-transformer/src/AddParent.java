import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddParent {
	
	  static final File outputFile = new File("C:/Users/ba-m/Desktop/DSN/data/Enhanced_evol/DSNJPROD20180320");
	  static void addParent(String filePath) throws IOException
	    {
		   final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)));
	        File inputFile = new File(filePath);
	        
	        
	        String separator = ",";
	        String line = null;
	        String lineIndiv = null;

	        int i = 0;
	        String codeIndivPrev = "1";
            String fileName = null;
            int lineNumber = 1;
	        BufferedReader reader = null;

	        ContexteFile contextFile = new ContexteFile();
	        List<ContexteFile> contextFileList = new ArrayList<>();
	        
	        try
	        {
	            reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile))); 
	             
	            //Reading all the lines of input text file into oldContent
	             
	            line = reader.readLine();
	            line = line.replace("\'", "");


        		List<Params> fileParamsList = new ArrayList(); 

	            while (line != null) 
	            {
	            	List<String> fieldsList = Arrays.asList(line.split(","));
	            	String code = fieldsList.get(0);
	            	String valeur = fieldsList.get(1);
	            	String blocId = code.substring(8, 10);
	            	Params fileParams = new Params(code, valeur);
	            	if (code.equals("S00.G00.00.000"))
	            	{
	            		fileParamsList = new ArrayList<>();
	            		fileParamsList.add(fileParams);
	            		contextFile = new ContexteFile(fileParamsList);
	            		contextFileList.add(contextFile);
	            				            		 
	            	}
	            	else
	            	{
	            		
	            		contextFile.putContexteFile(fileParams);

	            	}
	                line = reader.readLine();
	                lineNumber++;
	            }
            	processFile(contextFileList, writer, lineNumber);
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
	            } 
	            catch (IOException e) 
	            {
	                e.printStackTrace();
	            }
	        }
	        

            writer.close();
            
	    }

	   public static void processFile (List<ContexteFile> contextFileList, BufferedWriter writer, int lineNumber) throws IOException{
		  for (ContexteFile ctxFile:contextFileList) {
			  String fileName = null;
	            String parentId = null;
	            String contratCollectifId = null;
	            String codeCotisEtab = null;
	            String dateDebContratCol = null;
	            int codeEnteteVersement = 0;
		        ContexteIndividu contextIndiv = new ContexteIndividu();
		        List<ContexteIndividu> contexteIndividuList = new ArrayList<>();
	      		List<Params> indivParamsList = new ArrayList(); 
	      		
	      		ContexteEtablissement contextEtab = new ContexteEtablissement();
	      		List<Params> etabParamsList = new ArrayList(); 
	      		List<ContexteEtablissement> contexteEtabList = new ArrayList<>();
	      		String idContratCol = null;
			  for (Params param:ctxFile.getListFileParam() ) {
				  
				  	String code = param.getCode();
	            	String valeur = param.getValeur().replace("\'", "");;
	            	String blocId = code.substring(8, 10);
	               	if(code.equals("S00.G00.00.000")){
	            		fileName = valeur;
	                    writer.write(code + "," + valeur + "," + fileName + "," + fileName);
	                    writer.newLine();
	            	}
	            	//Traitement des blocs dsn, emetteur, entreprise
	            	if(blocId.equals("00")||
	            			blocId.equals("01")||
	            			blocId.equals("02")||
	            			blocId.equals("95")||
	            			blocId.equals("05")||
	            			blocId.equals("07")||
	            			blocId.equals("96")||
	            			blocId.equals("82")||
	            			blocId.equals("06"))
	            			{
	            		parentId = fileName;
	                    writer.write(code + "," + valeur + "," + parentId + "," + fileName );
	                    writer.newLine();
	            	} 
	            	
	            	//Traitement du bloc etablissement
	            	else if (blocId.equals("11")||
	            			blocId.equals("15")||
	            			blocId.equals("20")||
	            			blocId.equals("55")) {
	            		
	            		if(code.equals("S21.G00.15.001")){
	            			idContratCol = valeur;
	            		}
	            		Params entParams = new Params(code, valeur);
	                	if (code.equals("S21.G00.11.001"))
	                	{
	                		etabParamsList = new ArrayList<>();
	                		etabParamsList.add(entParams);
	                		contextEtab = new ContexteEtablissement(etabParamsList);
	                		contexteEtabList.add(contextEtab);
	                				            		 
	                	}
	                	else
	                	{
	                		
	                		contextEtab.putContexteEtablissement(entParams);

	                	}
	            			        			
	        		}

	            	//Traitement du bloc individu ou salarie
	            	
	            	else if (blocId.equals("30")||
	            			blocId.equals("40")||
	            			blocId.equals("70")||
	            			blocId.equals("41")||
	            			blocId.equals("71")||
	            			blocId.equals("73")||
	            			blocId.equals("50")||
	            			blocId.equals("51")||
	            			blocId.equals("53")||
	            			blocId.equals("52")||
	            			blocId.equals("86")||
	            			blocId.equals("78")||
	            			blocId.equals("79")||
	            			blocId.equals("60")||
	            			blocId.equals("64")||
	            			blocId.equals("62")||
	            			blocId.equals("65")||
	            			blocId.equals("85")||
	            			blocId.equals("81"))
	            	{
	            		
	                	String codeIndiv = code;
	                	String valeurIndiv = valeur;
	            		Params indivParams = new Params(codeIndiv, valeurIndiv);
	                	if (codeIndiv.equals("S21.G00.30.001"))
	                	{
	                		indivParamsList = new ArrayList<>();
	                		indivParamsList.add(indivParams);
	                		contextIndiv = new ContexteIndividu(indivParamsList);
	                		contexteIndividuList.add(contextIndiv);
	                				            		 
	                	}
	                	else
	                	{
	                		
	                		contextIndiv.putContexteIndividu(indivParams);

	                	}

	            	}
	            	lineNumber++;
			  }
			  
		        for ( ContexteEtablissement etab : contexteEtabList){
		        	processEtab(etab, writer, fileName, lineNumber);
		        }
		         
		        for ( ContexteIndividu indiv : contexteIndividuList){
		        	processIndiv(indiv, writer, fileName);
		        }
		        lineNumber++;    
		  }


    }
	   

		
		
		private static void processEtab(ContexteEtablissement etab, BufferedWriter writer, String fileName, int lineNumber) throws IOException {
			ContexteVersementEtab contextVers = new ContexteVersementEtab();
      		List<Params> versParamsList = new ArrayList(); 
      		List<ContexteVersementEtab> contexteVersList = new ArrayList<>();
      		String idContCol = null;
      		int idEntete = 0;
      		int idVers = 0;
			for(Params parm:etab.getListEtabParam()) {
				String code = parm.getCode();
				String valeur = parm.getValeur().replace("\'", "");;
				String line = null;
				String blocId = code.substring(8, 10);
				
	      		
				if (blocId.equals("11")) {
					line = code + "," + valeur + "," + fileName + "," + fileName;
					writer.write(line);
					writer.newLine();
				}
				
				if (blocId.equals("15")) {
						if(code.equals("S21.G00.15.001")) {
							idContCol = valeur;
						}
					line = code + "," + valeur + "," + idContCol + "," + fileName;
					writer.write(line);
					writer.newLine();
				}
				
				if (blocId.equals("20")) {
                	if (code.equals("S21.G00.20.001")){
                		idEntete = lineNumber;}
                					
				line = code + "," + valeur + "," + idEntete + "," + fileName;
				writer.write(line);
				writer.newLine();
				}
				
				if (blocId.equals("55")){
					if (code.equals("S21.G00.55.001")){
                		idVers = lineNumber;}
					line = code + "," + valeur + "," + idEntete + "#" + idVers + "," + fileName;
					writer.write(line);
					writer.newLine();
				}
				lineNumber++;
		}
			
	}



		public static void processIndiv (ContexteIndividu contexteIndividu, BufferedWriter writer, String fileName) throws IOException {
				ContextContrat contextContrat = new ContextContrat();
				List<ContextContrat> contexteContratList = new ArrayList<>();
				List<ContexteAnciennete> contexteAnciennetetList = new ArrayList<>();
				List<ContexteSalaire> contexteSalList = new ArrayList<>();
				List<Params> contratParamsList = new ArrayList();
				ContexteAnciennete contexteAnciennete = new ContexteAnciennete();
				List<Params> ancParamsList = new ArrayList();
				List<Params> salParamsList = new ArrayList();
				ContexteSalaire contexteSalaire = new ContexteSalaire();
				
			String idIndiv = null;	
			for(Params parm:contexteIndividu.getListIndivParam()) {
				String code = parm.getCode();
				String valeur = parm.getValeur().replace("\'", "");

				String line = null;
				String blocId = code.substring(8, 10);
				if (blocId.equals("30")) {
					if(code.equals("S21.G00.30.001")) {
						idIndiv = valeur;
					}
					line = code + "," + valeur + "," + idIndiv + "," + fileName;
					writer.write(line);
					writer.newLine();
				}

				if (blocId.equals("40")||
						blocId.equals("41")||
						blocId.equals("60")||
						blocId.equals("64")||
						blocId.equals("62")||
						blocId.equals("65")||
						blocId.equals("70")||
						blocId.equals("71")||
						blocId.equals("85")||
						blocId.equals("73")) {
					
						Params contratParams = new Params(code, valeur);	
				        	if (code.equals("S21.G00.40.001"))
				    	{
				        		contratParamsList = new ArrayList<>();
				        		contratParamsList.add(contratParams);
				        		contextContrat = new ContextContrat(contratParamsList);
				        		contexteContratList.add(contextContrat);            		
				    		 
				    	}
				    	else
				    	{
				    		contextContrat.putContexteContrat(contratParams);
				    	}
				
					}
				if(blocId.equals("50")||
						blocId.equals("51")||
						blocId.equals("52")||
						blocId.equals("53")||
						blocId.equals("54")||
						blocId.equals("78")||
						blocId.equals("79")||
						blocId.equals("81")){
					
					Params salParams = new Params(code, valeur);
					
					if(code.equals("S21.G00.50.001")){
						salParamsList = new ArrayList();
						salParamsList.add(salParams);
						contexteSalaire = new ContexteSalaire(salParamsList);
						contexteSalList.add(contexteSalaire);
						
					}
					else {
						contexteSalaire.putContexteSalaire(salParams);
					}
				
				}
				if(blocId.equals("50")) {
					
					Params ancParams = new Params(code, valeur);
					
					if(code.equals("S21.G00.86.001")){
						ancParamsList = new ArrayList();
						ancParamsList.add(ancParams);
						contexteAnciennete = new ContexteAnciennete(ancParamsList);
						contexteAnciennetetList.add(contexteAnciennete);
						
					}
					else {
						contexteAnciennete.putContexteAnciennete(ancParams);
					}
				
				}
				
			}
			
			processContratList(contexteContratList, idIndiv,  writer, fileName);
			processAncienneteList(contexteAnciennetetList, idIndiv,  writer, fileName);
			processSalaireList(contexteSalList, idIndiv,  writer, fileName);
		}
		
		public static void processAncienneteList(List<ContexteAnciennete> ctxAnciennetList, String idIndiv, BufferedWriter writer, String fileName) throws IOException{
			for(ContexteAnciennete ctxAnc : ctxAnciennetList){
				String AncId = getAncienneteId(ctxAnc);
				for(Params param : ctxAnc.getListAncParam()){
					String code = param.getCode();
					String valeur = param.getValeur().replace("\'", "");
					writer.write(code + "," + valeur + "," + idIndiv + "#" +AncId + "#" + "," + fileName);
					writer.newLine();
				}
				
			}
		}
		
		public static void processSalaireList(List<ContexteSalaire> ctxSalaireList, String idIndiv, BufferedWriter writer, String fileName) throws IOException{
			for(ContexteSalaire ctxSal : ctxSalaireList){
				String CotiseMutId = getCotiseMutId(ctxSal);
				 
				for(Params param : ctxSal.getListSalParam()){
					String code = param.getCode();
					String valeur = param.getValeur().replace("\'", "");
					String blocId = code.substring(8, 10);
					
					if(blocId.equals("78")||
							blocId.equals("79")||
							blocId.equals("81")){
					writer.write(code + "," + valeur + "," + idIndiv + "#" + CotiseMutId + "," + fileName);
					writer.newLine();
					}

				}
				
			}
		}
		


		public static void processContratList(List<ContextContrat> ctxContratList, String idIndiv, BufferedWriter writer, String fileName) throws IOException{
			for (ContextContrat ctxContrat:ctxContratList ) {
				List<ContexteArret> contexteArretList = new ArrayList<>();
				ContexteArret contexteArret = new ContexteArret();
				List<Params> arrParamsList = new ArrayList();
				
				List<ContexteSuspension> contexteSusptList = new ArrayList<>();
				ContexteSuspension contexteSusp = new ContexteSuspension();
				List<Params> susParamsList = new ArrayList();
				
				List<ContexteAffiliation> contexteAffList = new ArrayList<>();
				ContexteAffiliation contexteAff = new ContexteAffiliation();
				List<Params> affParamsList = new ArrayList();
				
				String contratID = getContratId(ctxContrat);
				for(Params param:ctxContrat.getListContratParam()){
				String code = param.getCode();
				String valeur = param.getValeur().replace("\'", "");
				String blocId = code.substring(8, 10);

				String line = null;
				if(blocId.equals("40")||
						blocId.equals("62")||
						blocId.equals("85")||
						blocId.equals("41")){
					line = code + "," + valeur + "," + idIndiv + "#" +contratID +"," + fileName;
					writer.write(line);
					writer.newLine();
				}

				if(blocId.equals("60")||
							blocId.equals("64")){
						Params arrParams = new Params(code, valeur);
						
						if(code.equals("S21.G00.60.001")){
						arrParamsList = new ArrayList();
						arrParamsList.add(arrParams);
						contexteArret = new ContexteArret(arrParamsList);
						contexteArretList.add(contexteArret);
							
						}
						else {
							contexteArret.putContexteArret(arrParams);
						}
					}

					if(blocId.equals("65")){
						Params suspParams = new Params(code, valeur);
						
						if(code.equals("S21.G00.65.001")){
						susParamsList = new ArrayList();
						susParamsList.add(suspParams);
						contexteSusp = new ContexteSuspension(susParamsList);
						contexteSusptList.add(contexteSusp);
							
						}
						else {
							contexteSusp.putContexteSusp(suspParams);
						}
	
					}

					if(blocId.equals("70")||
							blocId.equals("71")||
							blocId.equals("73")){
						Params affParams = new Params(code, valeur);
						
						if(code.equals("S21.G00.70.004")){
						affParamsList = new ArrayList();
						affParamsList.add(affParams);
						contexteAff = new ContexteAffiliation(affParamsList);
						contexteAffList.add(contexteAff);
							
						}
						else if(code.equals("S21.G00.70.012")){
							affParamsList = new ArrayList();
							affParamsList.add(affParams);
							contexteAff = new ContexteAffiliation(affParamsList);
							contexteAffList.add(contexteAff);
						} 
						else {
							contexteAff.putContexteAff(affParams);
						}
	
					}

				}
				processArretList(contexteArretList, idIndiv, contratID, writer, fileName);
				processSusptList(contexteSusptList, idIndiv, contratID, writer, fileName);
				processAffList(contexteAffList, idIndiv, contratID, writer, fileName);
			}
	}
		
		private static void processAffList(List<ContexteAffiliation> contexteAffList, String idIndiv, String contratID,
				BufferedWriter writer, String fileName) throws IOException {
			
			List<ContexteAyd> contexteAydList = new ArrayList<>();
			ContexteAyd contexteAyd = new ContexteAyd();
			List<Params> aydParamsList = new ArrayList();
			
            for (ContexteAffiliation ctxAff:contexteAffList ){
              	 String idAff = getIdAff(ctxAff);
              	
              	
              	 String line = null;
              	 for (Params param:ctxAff.getListAffParam()){
              		 
              		 String code = param.getCode();
              		 String valeur = param.getValeur();
              		String blocId = code.substring(8, 10);
              		 if(blocId.equals("70")) {
	              		 line = param.getCode() + "," + param.getValeur().replace("\'", "") + "," + idIndiv + "," + fileName;
	              		 writer.write(line);
	              		 writer.newLine();
              		 }
              		if (blocId.equals("73")) 
              		{
						Params aydParams = new Params(code, valeur);
						
						if(code.equals("S21.G00.73.002")){
						aydParamsList = new ArrayList();
						aydParamsList.add(aydParams);
						contexteAyd = new ContexteAyd(aydParamsList);
						contexteAydList.add(contexteAyd);
							
						}

						else {
							contexteAyd.putContexteAyd(aydParams);
						}
					}
              			
              		if (blocId.equals("71")) {
              			 line = param.getCode() + "," + param.getValeur().replace("\'", "") + "," + idIndiv + "#" + contratID + "," + fileName;
	              		 writer.write(line);
	              		 writer.newLine();
              		 }
              	 }
              }
            
            processAydList(contexteAydList, idIndiv, contratID, writer, fileName);
			
		}
		private static String getCotiseMutId(ContexteSalaire ctxSal) {
			String idCot = null;
			for (Params param:ctxSal.getListSalParam()){
				if (param.getCode().equals("S21.G00.78.002"))
					idCot = param.getValeur().replace("\'", "");
				if (param.getCode().equals("S21.G00.78.003"))
					idCot = idCot+ param.getValeur().replace("\'", "");
				if (param.getCode().equals("S21.G00.79.001"))
					idCot = idCot+ param.getValeur().replace("\'", "");
				}
			return idCot;
		}

		private static String getAncienneteId(ContexteAnciennete ctxAnc) {
			String idAnc = null;
			for (Params param:ctxAnc.getListAncParam()){
				if (param.getCode().equals("S21.G00.86.001"))
					idAnc = param.getValeur().replace("\'", "");
				if (param.getCode().equals("S21.G00.86.005"))
					idAnc = idAnc + param.getValeur().replace("\'", "");
			}
			return idAnc;
		}

		private static void processAydList(List<ContexteAyd> contexteAydList, String idIndiv, String contratID,
				BufferedWriter writer, String fileName) throws IOException {
			for (ContexteAyd ctxAyd:contexteAydList ){
			String idAyd = getIdAyd(ctxAyd);
			String line = null;
			for (Params param:ctxAyd.getListAydParam()){
         		 
         		 String code = param.getCode();
         		 String valeur = param.getValeur();

 			 line = param.getCode() + "," + param.getValeur().replace("\'", "") + "," + idIndiv + "#" + idAyd + "," + fileName;
     		 writer.write(line);
     		 writer.newLine();

				}
			}
		}

		private static String getIdAyd(ContexteAyd ctxAyd) {
			String idAyd = null;
			for (Params param:ctxAyd.getListAydParam()){
				String code = param.getCode();
				if (code.equals("S21.G00.73.005"))
					idAyd = param.getValeur().replace("\'", "");
				if (code.equals("S21.G00.73.006"))
					idAyd = idAyd + param.getValeur().replace("\'", "");
				if (code.equals("S21.G00.73.009"))
					idAyd = idAyd + param.getValeur().replace("\'", "");
			}
			return idAyd;
		}

		private static String getIdAff(ContexteAffiliation ctxAff) {
			String idAff = null;
			for (Params param:ctxAff.getListAffParam()){
				if (param.getCode().equals("S21.G00.70.004"))
					idAff = param.getValeur().replace("\'", "");
				if (param.getCode().equals("S21.G00.70.005"))
					idAff = idAff + param.getValeur().replace("\'", "");
			}
			return idAff;
		}

		private static void processSusptList(List<ContexteSuspension> contexteSusptList, String idIndiv,
				String contratID, BufferedWriter writer, String fileName) throws IOException {
            for (ContexteSuspension ctxSusp:contexteSusptList ){
           	 String dateDeb = getDateDebutSusp(ctxSusp);
           	 String line = null;
           	 for (Params param:ctxSusp.getListSuspParam()){
           		 line = param.getCode() + "," + param.getValeur().replace("\'", "") + "," + idIndiv + "#" + contratID + "," + fileName;
           		 writer.write(line);
           		 writer.newLine();
           	 }
           }
			
		}

		private static String getDateDebutSusp(ContexteSuspension ctxSusp) {
			for (Params param:ctxSusp.getListSuspParam()){
				if (param.getCode().equals("S21.G00.65.002"))
					return param.getValeur().replace("\'", "");
			}
			return null;
		}

		private static void processArretList(List<ContexteArret> contexteArretList, String idIndiv, String contratID,
				BufferedWriter writer, String fileName) throws IOException {
            for (ContexteArret ctxArret:contexteArretList ){
            	 String dateDeb = getDateDebutArret(ctxArret);
            	 String line = null;
            	 for (Params param:ctxArret.getListArretParam()){
            		 line = param.getCode() + "," + param.getValeur().replace("\'", "") + "," + idIndiv + "#" + contratID + "#" + dateDeb + "#" + "," + fileName;
            		 writer.write(line);
            		 writer.newLine();
            	 }
            }
			
		}

		private static String getDateDebutArret(ContexteArret ctxArret) {
			for (Params param:ctxArret.getListArretParam()){
				if (param.getCode().equals("S21.G00.60.002"))
					return param.getValeur().replace("\'", "");
			}
			return null;
		}

		private static String getContratId(ContextContrat ctxContrat) {
			for (Params param : ctxContrat.getListContratParam()) {
				if (param.getCode().equals("S21.G00.40.009")) {
					return param.getValeur().replace("\'", "");
				}
			}
			return null;
		}

		public static void processSalaire(ContexteSalaire ctxSalaire){
			List<ContexteCotiseMutuelle> contexteCotiseList = new ArrayList<>();
			ContexteCotiseMutuelle contexteCotise = new ContexteCotiseMutuelle();
			List<Params> cotiseParamsList = new ArrayList();
			
			for(int k = 0; k<ctxSalaire.getListSalParam().size();k++){
				String code = ctxSalaire.getListSalParam().get(k).getCode();
				String valeur = ctxSalaire.getListSalParam().get(k).getValeur().replace("\'", "");;
				String blocId = code.substring(8, 10);
				if(blocId.equals("78")||
						blocId.equals("79")||
						blocId.equals("81")){
					
					Params cotiseParams = new Params(code, valeur);
					
					if(code.equals("S21.G00.78.001")){
					cotiseParamsList = new ArrayList();
					cotiseParamsList.add(cotiseParams);
					contexteCotise = new ContexteCotiseMutuelle(cotiseParamsList);
					contexteCotiseList.add(contexteCotise);
						
					}
					else {
						contexteCotise.putContexteCotiseMutuelle(cotiseParams);
					}

				}
			}
		}
		
		
		public static void main(String[] args) throws IOException
	    {
	    	addParent("C:/Users/ba-m/Desktop/DSN/data/Source/DSNJPROD20180320");
	         
	        System.out.println("done");
	    }

}

