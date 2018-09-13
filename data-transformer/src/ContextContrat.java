import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
	
public class ContextContrat {
		
		List<Params> listcontratParam = new ArrayList();
		
		List<Map<String,String>> contratList = new ArrayList<>();
		public ArrayList<HashMap> contexteContrat = new ArrayList<>();
		
		public ContextContrat ()
		{
			
		}
		
		public ContextContrat (List<Params> contPar)
		{
			this.listcontratParam = contPar;
		}

		public List<Params> putContexteContrat(Params cont)
			{
				this.listcontratParam.add(cont);
				return this.listcontratParam;
				
				
			}
		
		public List<Params> getListContratParam() {
			return listcontratParam;
		}

		

}
