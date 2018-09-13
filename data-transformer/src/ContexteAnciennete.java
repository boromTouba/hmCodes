import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
		
	public class ContexteAnciennete {
			
			List<Params> listAncParam = new ArrayList();
			
			List<Map<String,String>> contratList = new ArrayList<>();
			
			public ContexteAnciennete ()
			{
				
			}
			
			public ContexteAnciennete (List<Params> ancPar)
			{
				this.listAncParam = ancPar;
			}

			public List<Params> putContexteAnciennete(Params anc)
				{
					this.listAncParam.add(anc);
					return this.listAncParam;
					
					
				}
			
			public List<Params> getListAncParam() {
				return listAncParam;
			}


}
