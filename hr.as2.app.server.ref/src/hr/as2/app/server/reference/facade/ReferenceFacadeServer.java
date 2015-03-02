package hr.as2.app.server.reference.facade;

import hr.as2.app.common.ref.dto.ReferenceConstants;
import hr.as2.app.common.ref.dto.ReferenceRs;
import hr.as2.app.common.ref.dto.ReferenceVo;
import hr.as2.inf.common.core.AS2Context;

public final class ReferenceFacadeServer implements ReferenceConstants {

	private static ReferenceFacadeServer _instance = new ReferenceFacadeServer();
	private static ReferenceRs as2_rs;

	public static ReferenceFacadeServer getInstance() {
		return _instance;
	}

	private ReferenceFacadeServer() {
		AS2Context.setSingletonReference(this);
		as2_rs = new ReferenceRs();
		ReferenceVo row = new ReferenceVo();
		row.setIdTest("100");
		row.setName("Name one hundres");
		as2_rs.addRow(row);    		
		row = new ReferenceVo();
		row.setIdTest("200");
		row.setName("Name two hundred");
		as2_rs.addRow(row); 
	}
	
	public ReferenceVo addReference(ReferenceVo value)  {
		//ReferenceJdbc dao = new ReferenceJdbc();
		//dao.daoCreate(value);
		value.setIdTest(as2_rs.size()+1+"");
		as2_rs.addRow(value);
		return value;
	}
	
	public ReferenceVo updateReference(ReferenceVo value)  {
		//ReferenceJdbc dao = new ReferenceJdbc();
		//dao.daoStore(value);
		as2_rs.deleteRowWithKey(REFERENCE__ID_TEST,value.getIdTest());
		as2_rs.addRow(value);
		return value;
	}
	public ReferenceVo deleteReference(ReferenceVo value)  {
		//ReferenceJdbc dao = new ReferenceJdbc();
		//dao.daoRemove(value);
		as2_rs.deleteRowWithKey(REFERENCE__ID_TEST,value.getIdTest());
		return value;
	}

	public ReferenceRs findReference(ReferenceVo value)  {
		//ReferenceJdbc dao = new ReferenceJdbc();
		//return dao.daoFindTest(value);
		return as2_rs;
	}
	public ReferenceVo loadReference(ReferenceVo value)  {
		ReferenceVo row = new ReferenceVo();
		row.setIdTest("100");
		row.setName("Name one hundres");
		return row;
	}
}
