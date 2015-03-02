package hr.as2.app.common.ref.dto;

import hr.as2.inf.common.data.AS2Record;
import hr.as2.inf.common.data.AS2RecordList;

import java.util.Iterator;

public class ReferenceRs extends AS2RecordList {
	private static final long serialVersionUID = 1L;

	public ReferenceRs() {
		super();
	}

	public ReferenceRs(AS2RecordList set) {
		super(); // rows not set inside super constructor
		setColumnNames(set.getColumnNames());
		setColumnSizes(set.getColumnSizes());
		setMetaData(set.getMetaData());
		Iterator<AS2Record> E = set.getRows().iterator();
		while (E.hasNext()) {
			AS2Record row = E.next();
			ReferenceVo vo = new ReferenceVo(row);
			this.addRow(vo);
		}
	}
}