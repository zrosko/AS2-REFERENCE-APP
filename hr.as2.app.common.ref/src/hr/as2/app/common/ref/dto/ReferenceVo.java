package hr.as2.app.common.ref.dto;

import hr.as2.inf.common.data.AS2Record;

/**
 * Reference application test value object.
 */
public class ReferenceVo extends AS2Record implements ReferenceConstants {
	private static final long serialVersionUID = 1L;

	public ReferenceVo() {
		super();
	}

	public ReferenceVo(AS2Record value) {
		super(value);
	}

	public void setIdTest(String value) {
		set(REFERENCE__ID_TEST, value);
	}
	
	public void setName(String value) {
		set(REFERENCE__NAME, value);
	}
	
	public String getIdTest() {
		return get(REFERENCE__ID_TEST);
	}
	
	public String getName() {
		return get(REFERENCE__NAME);
	}
}