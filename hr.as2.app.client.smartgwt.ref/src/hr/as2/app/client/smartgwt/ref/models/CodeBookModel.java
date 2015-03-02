package hr.as2.app.client.smartgwt.ref.models;

import hr.adriacomsoftware.inf.client.smartgwt.core.AS2ClientContext;
import hr.adriacomsoftware.inf.client.smartgwt.models.AS2RestJSONDataSource;
import hr.adriacomsoftware.inf.client.smartgwt.types.AS2DataSourceField;
import hr.adriacomsoftware.inf.client.smartgwt.types.AS2Field;
import hr.as2.app.common.ref.dto.CodeBookConstants;

import java.util.HashMap;

/**
 * @author zrosko@gmail.com
 *
 */
public class CodeBookModel extends AS2RestJSONDataSource implements CodeBookConstants {
	
	private static CodeBookModel instance = new CodeBookModel("CodeBookModel");
	
	public static CodeBookModel getInstance() {
		return instance;
	}
	
	public CodeBookModel(String id) {
		super(id);
		AS2DataSourceField id_sif = new AS2DataSourceField(SIFRARNIK__ID,AS2Field.PRIMARY_KEY, "Id");
		AS2DataSourceField vrsta = new AS2DataSourceField(SIFRARNIK__VRSTA,AS2Field.TEXT, "Vrsta");
		AS2DataSourceField rb = new AS2DataSourceField(SIFRARNIK__RB,AS2Field.INTEGER, "Rb");
		AS2DataSourceField id_sifre = new AS2DataSourceField(SIFRARNIK__ID_SIFRE,AS2Field.TEXT, "Id šifre");
		AS2DataSourceField naziv_sifre = new AS2DataSourceField(SIFRARNIK__NAZIV_SIFRE, AS2Field.TEXT,"Naziv šifre");
		AS2DataSourceField aplikacija = new AS2DataSourceField(SIFRARNIK__APLIKACIJA, AS2Field.TEXT,"Aplikacija");
		this.setFields(id_sif,vrsta,rb,id_sifre,naziv_sifre,aplikacija);
		this.setCacheAllData(true);
		this.setCacheMaxAge(24*60*60);
	}
	@Override
	public String getRemoteObject() {
		return "hr.adriacomsoftware.app.server.obrasci.facade.DokumentFacadeServer";//TODO
	}

	@Override
	public String getTransformTo() {
		return "hr.as2.inf.common.data.AS2Record";//TODO
	}
	
//	@Override
//	public HashMap<String, String> getDefaultProperties(){
//		HashMap<String,String> params = new HashMap<String,String>();
//		params.put(AS2RestJSONDataSource.APLIKACIJA,"pis");
//		return params;
//	}
	@Override
	public HashMap<String, String> getAddOperationProperties() {
		HashMap<String,String> params = new HashMap<String,String>();
		params.put(AS2RestJSONDataSource.REMOTE_METHOD,"dodajUraSifrarnik");
		params.put(AS2RestJSONDataSource.REMOTE_OBJECT,getRemoteObject());
		params.put(AS2RestJSONDataSource.TRANSFORM_TO,getTransformTo());
		return params;
	}

	@Override
	public HashMap<String, String> getUpdateOperationProperties() {
		HashMap<String,String> params = new HashMap<String,String>();
		params.put(AS2RestJSONDataSource.REMOTE_METHOD,"azurirajUraSifrarnik");
		params.put(AS2RestJSONDataSource.REMOTE_OBJECT,getRemoteObject());
		params.put(AS2RestJSONDataSource.TRANSFORM_TO,getTransformTo());
		return params;
	}

	@Override
	public HashMap<String, String> getDeleteOperationProperties() {
		HashMap<String,String> params = new HashMap<String,String>();
		params.put(AS2RestJSONDataSource.REMOTE_METHOD,"brisiUraSifrarnik");
		params.put(AS2RestJSONDataSource.REMOTE_OBJECT,getRemoteObject());
		params.put(AS2RestJSONDataSource.TRANSFORM_TO,getTransformTo());
		return params;
	}

	@Override
	public HashMap<String, String> getFetchOperationProperties() {
		HashMap<String,String> params = new HashMap<String,String>();
		params.put(AS2RestJSONDataSource.REMOTE_METHOD,"procitajSifrarnik");
		params.put(AS2RestJSONDataSource.REMOTE_OBJECT,getRemoteObject());
		params.put(AS2RestJSONDataSource.TRANSFORM_TO,getTransformTo());
		params.put("aplikacija",AS2ClientContext.getSessionValue(AS2ClientContext.APPLICATION_ID));
		return params;
	}
	
}


