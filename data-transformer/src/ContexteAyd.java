import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
		
	public class ContexteAyd {
			
			List<Params> listAydParam = new ArrayList();
			
			public ContexteAyd ()
			{
				
			}
			
			public ContexteAyd (List<Params> arrPar)
			{
				this.listAydParam = arrPar;
			}

			public List<Params> putContexteAyd(Params arr)
				{
					this.listAydParam.add(arr);
					return this.listAydParam;
					
					
				}
			
			public List<Params> getListAydParam() {
				return listAydParam;
			}


}
