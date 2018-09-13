import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
		
	public class ContexteSuspension {
			
			List<Params> listSuspParam = new ArrayList();
			
			public ContexteSuspension ()
			{
				
			}
			
			public ContexteSuspension (List<Params> suspPar)
			{
				this.listSuspParam = suspPar;
			}

			public List<Params> putContexteSusp(Params susp)
				{
					this.listSuspParam.add(susp);
					return this.listSuspParam;
					
					
				}
			
			public List<Params> getListSuspParam() {
				return listSuspParam;
			}


}
