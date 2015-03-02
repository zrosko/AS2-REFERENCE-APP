package hr.as2.app.server.reference.da.jdbc;

import hr.adriacomsoftware.app.server.services.da.jdbc.KPIJdbc;
import hr.as2.app.common.ref.dto.ReferenceRs;
import hr.as2.app.common.ref.dto.ReferenceVo;
import hr.as2.inf.common.exceptions.AS2DataAccessException;

import java.sql.PreparedStatement;

public final class ReferenceJdbc extends KPIJdbc {
	public ReferenceJdbc() {
		setTableName("reference");
	}

	public ReferenceRs daoFindTest(ReferenceVo value) {
		try {
			PreparedStatement pstmt = getConnection().getPreparedStatement("SELECT * FROM dbo.reference");
			pstmt.setMaxRows(0);
			ReferenceRs j2eers = new ReferenceRs(transformResultSet(pstmt.executeQuery()));
			pstmt.close();
			return j2eers;
		} catch (Exception e) {
			throw new AS2DataAccessException(e);
		}
	}

}