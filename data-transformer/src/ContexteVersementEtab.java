import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContexteVersementEtab {
	
	
	List<Params> listParam = new ArrayList();
	
	public ArrayList<HashMap> contexteVersement = new ArrayList<>();
	
	public ContexteVersementEtab ()
	{
		
	}
	
	public ContexteVersementEtab (List<Params> indPar)
	{
		this.listParam = indPar;
	}
	

	public List<Params> putContexteVersement(Params ind)
		{
			this.listParam.add(ind);
			return this.listParam;
			
			
		}

	public List<Params> getListVersParam() {
		return listParam;
	}

	public void setListVersParam(List<Params> listVersParam) {
		this.listParam = listVersParam;
	}
	
	
	
}