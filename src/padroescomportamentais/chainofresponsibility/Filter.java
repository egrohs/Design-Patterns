package padroescomportamentais.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

public class Filter {
	List<IFilter> fs = new ArrayList<IFilter>();
	
	public void addFilter(IFilter obj) {
		fs.add(obj);
	}

	public void filter(Input i) {
		for (IFilter f : fs) {
			//if(f instanceof IntFilter){
			System.out.println(f.filter(i));
			//}
		}
	}
}
