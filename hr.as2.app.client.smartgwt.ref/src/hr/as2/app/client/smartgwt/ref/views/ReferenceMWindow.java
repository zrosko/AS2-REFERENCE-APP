package hr.as2.app.client.smartgwt.ref.views;

import hr.adriacomsoftware.inf.client.smartgwt.types.AS2Field;
import hr.adriacomsoftware.inf.client.smartgwt.types.AS2FormItem;
import hr.adriacomsoftware.inf.client.smartgwt.views.AS2DynamicForm;
import hr.adriacomsoftware.inf.client.smartgwt.views.AS2Window;
import hr.adriacomsoftware.inf.client.smartgwt.views.rosko.AS2View2;
import hr.as2.app.common.ref.dto.ReferenceConstants;

import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;

/**
 * @author zrosko@gmail.com
 *
 */
public class ReferenceMWindow extends AS2Window implements ReferenceConstants {	
	//private AS2FormItem _test;
	
	public ReferenceMWindow(AS2View2 parent, Record record) {
		super(parent,record);
	}
	@Override
	public DataSource getModel() {
		return _parent_view.getModel();
	}
	@Override
	public void customWindowPreferences(){
		this.setWidth(600);
		this.setHeight(400);
	}
	
	@Override
	public DataSource getSifrarnikModel() {
		return _parent_view.getSifrarnikModel();
	}
	@Override
	protected Criteria initCriteria(){
		return new Criteria(REFERENCE__ID_TEST,_record.getAttribute(REFERENCE__ID_TEST));
	}
	@Override
	protected String getInitRemoteMethod(){
		return "loadReference";
	}
	@Override
	public AS2DynamicForm getDynamicForm() {		
		AS2DynamicForm form = new AS2DynamicForm(2);
		form.setColWidths("30%", "80%");
		form.setAutoFetchData(false);
		form.setSaveOnEnter(false);
		form.setWrapItemTitles(false);
		form.setWidth100();
		form.setPadding(5);
		form.setStyleNameGray();
		form.setCanSubmit(true);
		AS2FormItem _id = new AS2FormItem(REFERENCE__ID_TEST,AS2Field.INTEGER);
		_id.getField().setVisible(false);
		AS2FormItem _name = new AS2FormItem(REFERENCE__NAME, AS2Field.TEXT,"Name");
//		_test = new  AS2FormItem("test",AS2Field.FORM_RADIOGROUP, "Test");
//		_test.setDefaultValue("Y");
//		_test.setVertical(false);
		_name.getField().setWidth(300);
		_name.getField().setHint("Name hint...");
		form.setDataSource(_dataSource);
		form.setFields(_id,_name);
		form.setRequiredFields(_name);
		form.focusInItem(_name);
		//form.setDropDownModel(getSifrarnikModel(), _name);
		form.setDefaultButton(_button_spremi);
		
		//handlers
//		_id.getField().addChangedHandler(new ChangedHandler() {
//			@Override
//			public void onChanged(ChangedEvent event) {
//				String value = event.getItem().getValue().toString();
//				if(value.equalsIgnoreCase("5"))
//					_test.getField().setValue("Five");
//				else
//					_test.getField().setValue("Other");
//			}
//		});
		
		return form;
	}

	@Override
	public String getWindowFormTitleNew() {
		return "<b style=\"color:black;font-size:10pt;\">New entity</b>";
	}
	@Override
	public String getWindowFormTitleUpdate() {
		return  "<b style=\"color:black;font-size:10pt;\">Podaci za dokument broj: "
				+ _record.getAttribute(REFERENCE__ID_TEST)
				+ "</b></br>Vrsta dokumenta: "
				+ _record.getAttributeAsString(REFERENCE__NAME);
	}
}
