import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
		
	public class ContexteCotiseMutuelle {
			
			List<Params> listParam = new ArrayList();
			
			public ContexteCotiseMutuelle ()
			{
				
			}
			
			public ContexteCotiseMutuelle (List<Params> cotisePar)
			{
				this.listParam = cotisePar;
			}

			public List<Params> putContexteCotiseMutuelle(Params cotise)
				{
					this.listParam.add(cotise);
					return this.listParam;
					
					
				}
			
			public List<Params> getListCotParam() {
				return listParam;
			}

			public void setListCotParam(List<Params> listParam) {
				this.listParam = listParam;
			}



}
