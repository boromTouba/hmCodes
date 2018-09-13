import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContexteIndividu {
	
	
	//HashMap individuParams = new HashMap<>();
	List<Params> listIndivParam = new ArrayList();
	
	//List<Map<String,String>> individuList = new ArrayList<>();
	public ArrayList<HashMap> contexteIndividu = new ArrayList<>();
	
	public ContexteIndividu ()
	{
		
	}
	
	public ContexteIndividu (List<Params> indPar)
	{
		//IndivParams indivParam = new IndivParams(code, valeur);
		this.listIndivParam = indPar;
	}
	

	public List<Params> putContexteIndividu(Params ind)
		{
			this.listIndivParam.add(ind);
			return this.listIndivParam;
			
			
		}

	public List<Params> getListIndivParam() {
		return listIndivParam;
	}

	public void setListIndivParam(List<Params> listIndivParam) {
		this.listIndivParam = listIndivParam;
	}
	
	
	
}
