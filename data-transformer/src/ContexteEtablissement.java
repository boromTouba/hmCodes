import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContexteEtablissement {
	
	
	List<Params> listParam = new ArrayList();
	
	public ArrayList<HashMap> contexteEtablissement = new ArrayList<>();
	
	public ContexteEtablissement ()
	{
		
	}
	
	public ContexteEtablissement (List<Params> indPar)
	{
		this.listParam = indPar;
	}
	

	public List<Params> putContexteEtablissement(Params ind)
		{
			this.listParam.add(ind);
			return this.listParam;
			
			
		}

	public List<Params> getListEtabParam() {
		return listParam;
	}

	public void setListEtabParam(List<Params> listEtabParam) {
		this.listParam = listEtabParam;
	}
	
	
	
}
