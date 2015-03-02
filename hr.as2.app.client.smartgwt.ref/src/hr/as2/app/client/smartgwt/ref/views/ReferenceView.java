package hr.as2.app.client.smartgwt.ref.views;

import hr.adriacomsoftware.inf.client.smartgwt.core.AS2ClientContext;
import hr.adriacomsoftware.inf.client.smartgwt.types.AS2Field;
import hr.adriacomsoftware.inf.client.smartgwt.types.AS2FormItem;
import hr.adriacomsoftware.inf.client.smartgwt.types.AS2ListGridField;
import hr.adriacomsoftware.inf.client.smartgwt.views.AS2DynamicForm;
import hr.adriacomsoftware.inf.client.smartgwt.views.AS2ListGrid;
import hr.adriacomsoftware.inf.client.smartgwt.views.rosko.AS2SpreadSheetMWindow;
import hr.adriacomsoftware.inf.client.smartgwt.views.rosko.AS2View2;
import hr.as2.app.client.smartgwt.ref.models.CodeBookModel;
import hr.as2.app.client.smartgwt.ref.models.ReferenceModel;
import hr.as2.app.common.ref.dto.ReferenceConstants;

import java.util.ArrayList;
import java.util.List;

import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickHandler;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

/**
 * @author astrikoman
 *
 */ 
public class ReferenceView extends AS2View2 implements  ReferenceConstants {
	
	//private HLayout rollOverCanvas;

	public ReferenceView(String name) {
		super(name);
	}
	@Override
	public void customWindowPreferences() {
		use_form=false;
		use_listgrid=true;
		use_search_form=true;
	}
	
	@Override
	public DataSource getModel() {
		return ReferenceModel.getInstance();
	}
	
//	@Override
//	protected LinkedHashMap<String, LinkedHashMap<String, String>> getSifrarnikValueMaps() {
//		LinkedHashMap<String, LinkedHashMap<String, String>> mapa = new LinkedHashMap<>();
//		LinkedHashMap<String, String> naziv_vrste = new LinkedHashMap<>();
//		naziv_vrste.put("URA", "URA");
//		mapa.put("naziv", naziv_vrste);
//		LinkedHashMap<String, String> status_dokumenta = new LinkedHashMap<>();
//		status_dokumenta.put("Novi", "Novi");
//		status_dokumenta.put("Plaćeno", "Plaćeno");
//		status_dokumenta.put("Odobreno", "Odobreno");
//		mapa.put("status_dokumenta", status_dokumenta);
//		return mapa;
//	}

	@Override
	public DataSource getSifrarnikModel() {
		return CodeBookModel.getInstance();
	}
	
	@Override
	public AS2DynamicForm getDynamicForm() {
		return null;
	}
	@Override
	public AS2DynamicForm getSearchForm() {
		return super.getSearchForm();
	}
	
	@Override
	public AS2ListGrid getListGrid() {
		final AS2ListGrid listGrid = new AS2ListGrid(true){			
			@Override
			protected Canvas getRollOverCanvas(Integer rowNum, Integer colNum) {
				return getRolloverCanvas(rowNum,colNum,this);
			}
		};
		listGrid.setDataSource(getModel());
		listGrid.setWidth100();
		listGrid.setHeight100();
		listGrid.setShowResizeBar(false);
						
		Criteria criteria = new Criteria( "aplikacija",AS2ClientContext.getSessionValue(AS2ClientContext.APPLICATION_ID));
		listGrid.setCriteria(criteria);
		
		AS2ListGridField _id = new AS2ListGridField(REFERENCE__ID_TEST,"8%");
		AS2ListGridField _name = new AS2ListGridField(REFERENCE__NAME,"20%");
		_name.setWidth("8%");
		AS2ListGridField _test =  new AS2ListGridField("test",AS2Field.COMBO);
		_test.setWidth("8%");
		listGrid.setFields(_id,_name,_test);
		//listGrid.setDropDownModel(getSifrarnikModel(),_id);
		// summary
		listGrid.setShowGridSummary(true);
		listGrid.setShowGroupSummary(true);  
		listGrid.setShowGroupSummaryInHeader(true);  
		listGrid.setShowGridSummaryFields(false,_id,_name,_test);
		listGrid.setShowGroupSummaryFields(false,_id,_name,_test);
		//handlers
		listGrid.addRecordDoubleClickHandler(new RecordDoubleClickHandler() {
			@Override
			public void onRecordDoubleClick(RecordDoubleClickEvent event) {
				if(_listGrid.getSelectedRecord()!=null){
						new ReferenceMWindow(ReferenceView.this,_listGrid.getSelectedRecord());
				}
			}
		});
		return listGrid;
	}
	
	protected ToolStrip getToolStrip(){
		ToolStrip toolStrip = super.getToolStrip();
		toolStrip.setMembers(toolbarAdd, toolbarPreview, toolbarDelete, toolbarDelete, toolbarFilter, toolbarRefresh);
		return toolStrip;
	}
	@Override
	protected void actionToolbarAdd(ClickEvent event) {
		new AS2SpreadSheetMWindow("rbac_korisnik", new Criteria("aplikacija","pis"));
		//new ReferenceMWindow(ReferenceView.this,null);
	}
	@Override
	protected void actionToolbarPreview(ClickEvent event) {
		new ReferenceMWindow(ReferenceView.this,_listGrid.getSelectedRecord());
	}

	@Override
	protected String getRecordIdName() {
		return REFERENCE__ID_TEST;
	}
	@Override
	public AS2FormItem[] getSearchFormItems() {
		List<AS2FormItem> items = new ArrayList<AS2FormItem>();
		AS2FormItem name = new AS2FormItem("name",AS2Field.TEXT,"Name","*");
		name.getField().setTitleOrientation(TitleOrientation.TOP);
		items.add(name);
		AS2FormItem oib = new AS2FormItem("oib",AS2Field.TEXT,"OIB","*");
		oib.getField().setTitleOrientation(TitleOrientation.TOP);
		items.add(oib);
		AS2FormItem jmbg = new AS2FormItem("jmbg",AS2Field.TEXT,"JMBG","*");
		jmbg.getField().setTitleOrientation(TitleOrientation.TOP);
		items.add(jmbg);
		AS2FormItem maticni_broj = new AS2FormItem("maticni_broj",AS2Field.TEXT,"Matični broj","*");
		maticni_broj.getField().setTitleOrientation(TitleOrientation.TOP);
		maticni_broj.getField().setSaveOnEnter(false);
		items.add(maticni_broj);
		AS2FormItem naziv = new AS2FormItem("naziv",AS2Field.TEXT,"Naziv","*");
		naziv.getField().setTitleOrientation(TitleOrientation.TOP);
		items.add(naziv);
		AS2FormItem trazi_sve = new AS2FormItem("trazi_sve",AS2Field.TEXT,"Sadrži","*");
		trazi_sve.getField().setTitleOrientation(TitleOrientation.TOP);
		items.add(trazi_sve);
		AS2FormItem[] formItems = new AS2FormItem[items.size()];
		items.toArray(formItems);
		return formItems;
	}
	@Override
	public void windowLayout() {
			this.addMembers(_searchForm,_toolBar, _listGrid,_listGrid.getStatusBar());
	}
}
