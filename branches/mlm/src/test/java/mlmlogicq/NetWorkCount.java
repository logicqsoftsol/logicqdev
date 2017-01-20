package mlmlogicq;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.logicq.mlm.model.profile.NetWorkDetails;

public class NetWorkCount {
	
	public static void main(String[] args) throws Exception {
		ObjectMapper mapper = new ObjectMapper();

		NetWorkDetails networkdetails=mapper.readValue(new File("C://Users//SudhanshuLenka//Desktop//network.json"), NetWorkDetails.class);
		Map<String,Integer> totallevel=new HashMap<String,Integer>();
		int level=1;
		fillAllChild(networkdetails, totallevel, level);
		System.out.println(totallevel);
	}

	private static void fillAllChild(NetWorkDetails networkdetails, Map<String, Integer> totallevel, int level) {
		if (null != networkdetails) {
			if (null != networkdetails.getChildren() && !networkdetails.getChildren().isEmpty()) {
				totallevel.put(networkdetails.getId() + "_" + level, networkdetails.getChildren().size());
				int currentParentlevel = level + 1;
			    updateparent(networkdetails, totallevel, currentParentlevel);
				
				for (NetWorkDetails network : networkdetails.getChildren()) {
						fillAllChild(network,totallevel,level);
				}
			}
		}
	}

	private static void  updateparent(NetWorkDetails networkdetails, Map<String, Integer> totallevel,
			int currentParentlevel) {
		Integer parentelements = totallevel.get(networkdetails.getParentid() + "_" + currentParentlevel);
		if (null != parentelements) {
			parentelements = parentelements + networkdetails.getChildren().size();
		}
		totallevel.put(networkdetails.getParentid() + "_" + currentParentlevel, parentelements);
	}

}
