import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
		
	public class ContexteSalaire {
			
			List<Params> listParam = new ArrayList();
			
			public ContexteSalaire ()
			{
				
			}
			
			public ContexteSalaire (List<Params> salairePar)
			{
				this.listParam = salairePar;
			}

			public List<Params> putContexteSalaire(Params salaire)
				{
					this.listParam.add(salaire);
					return this.listParam;
					
					
				}
			public List<Params> getListSalParam() {
				return listParam;
			}

			public void setListSalParam(List<Params> listParam) {
				this.listParam = listParam;
			}


}