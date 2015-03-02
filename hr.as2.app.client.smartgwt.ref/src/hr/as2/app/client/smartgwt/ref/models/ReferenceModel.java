package hr.as2.app.client.smartgwt.ref.models;

import hr.adriacomsoftware.inf.client.smartgwt.models.AS2RestJSONDataSource;
import hr.adriacomsoftware.inf.client.smartgwt.types.AS2DataSourceField;
import hr.adriacomsoftware.inf.client.smartgwt.types.AS2Field;
import hr.as2.app.common.ref.dto.ReferenceConstants;

import java.util.HashMap;

/**
 * @author zrosko@gmail.com
 *
 */
public class ReferenceModel extends AS2RestJSONDataSource implements ReferenceConstants {
	
	private static ReferenceModel instance = new ReferenceModel("ReferenceModel");
	
	public static ReferenceModel getInstance() {
		return instance;
	}
	
	public ReferenceModel(String id) {
		super(id);
		AS2DataSourceField _id = new AS2DataSourceField(REFERENCE__ID_TEST,AS2Field.PRIMARY_KEY, "Id");
		_id.setHidden(true);
		AS2DataSourceField _name = new AS2DataSourceField(REFERENCE__NAME,AS2Field.TEXT, "Name");
		this.setFields(_id,_name);
	}
	
	@Override
	public String getRemoteObject() {
		return "hr.as2.app.server.reference.facade.ReferenceFacadeServer";
	}

	@Override
	public String getTransformTo() {
		return "hr.as2.app.common.ref.dto.ReferenceVo";
	}

	@Override
	public HashMap<String, String> getAddOperationProperties() {
		HashMap<String,String> params = new HashMap<String,String>();
		params.put(AS2RestJSONDataSource.REMOTE_METHOD,"addReference");
		params.put(AS2RestJSONDataSource.REMOTE_OBJECT,getRemoteObject());
		params.put(AS2RestJSONDataSource.TRANSFORM_TO,getTransformTo());
		return params;
	}

	@Override
	public HashMap<String, String> getUpdateOperationProperties() {
		HashMap<String,String> params = new HashMap<String,String>();
		params.put(AS2RestJSONDataSource.REMOTE_METHOD,"updateReference");
		params.put(AS2RestJSONDataSource.REMOTE_OBJECT,getRemoteObject());
		params.put(AS2RestJSONDataSource.TRANSFORM_TO,getTransformTo());
		return params;
	}

	@Override
	public HashMap<String, String> getDeleteOperationProperties() {
		HashMap<String,String> params = new HashMap<String,String>();
		params.put(AS2RestJSONDataSource.REMOTE_METHOD,"deleteReference");
		params.put(AS2RestJSONDataSource.REMOTE_OBJECT,getRemoteObject());
		params.put(AS2RestJSONDataSource.TRANSFORM_TO,getTransformTo());
		return params;
	}

	@Override
	public HashMap<String, String> getFetchOperationProperties() {
		HashMap<String,String> params = new HashMap<String,String>();
		params.put(AS2RestJSONDataSource.REMOTE_METHOD,"findReference");
		params.put(AS2RestJSONDataSource.REMOTE_OBJECT,getRemoteObject());
		params.put(AS2RestJSONDataSource.TRANSFORM_TO,getTransformTo());
		return params;
	}
}
