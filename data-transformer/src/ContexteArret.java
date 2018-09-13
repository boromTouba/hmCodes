import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
		
	public class ContexteArret {
			
			List<Params> listArretParam = new ArrayList();
			
			public ContexteArret ()
			{
				
			}
			
			public ContexteArret (List<Params> arrPar)
			{
				this.listArretParam = arrPar;
			}

			public List<Params> putContexteArret(Params arr)
				{
					this.listArretParam.add(arr);
					return this.listArretParam;
					
					
				}
			
			public List<Params> getListArretParam() {
				return listArretParam;
			}


}
