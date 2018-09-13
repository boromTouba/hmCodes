import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
		
	public class ContexteAffiliation {
			
			List<Params> listAffParam = new ArrayList();
			
			public ContexteAffiliation ()
			{
				
			}
			
			public ContexteAffiliation (List<Params> affPar)
			{
				this.listAffParam = affPar;
			}

			public List<Params> putContexteAff(Params aff)
				{
					this.listAffParam.add(aff);
					return this.listAffParam;
					
					
				}
			
			public List<Params> getListAffParam() {
				return listAffParam;
			}


}
