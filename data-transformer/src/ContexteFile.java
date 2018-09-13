import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContexteFile {

	//HashMap individuParams = new HashMap<>();
		List<Params> listFileParam = new ArrayList();
		
		//List<Map<String,String>> individuList = new ArrayList<>();
		public ArrayList<HashMap> contexteFile = new ArrayList<>();
		
		public ContexteFile ()
		{
			
		}
		
		public ContexteFile (List<Params> indPar)
		{
			//IndivParams indivParam = new IndivParams(code, valeur);
			this.listFileParam = indPar;
		}
		
		
		
		//public HashMap getContexteIndividu(String pos)
			//{
				//HashMap
				//return null;
			//}
		
		public List<Params> putContexteFile(Params ind)
			{
				this.listFileParam.add(ind);
				return this.listFileParam;
				
				
			}

		public List<Params> getListFileParam() {
			return listFileParam;
		}

		public void setListFileParam(List<Params> listIndivParam) {
			this.listFileParam = listIndivParam;
		}
		
		
		
	}
