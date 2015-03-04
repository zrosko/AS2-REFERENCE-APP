package hr.as2.app.client.smartgwt.ref;

import hr.adriacomsoftware.inf.client.smartgwt.desktop.views.AS2ContextArea;
import hr.adriacomsoftware.inf.client.smartgwt.desktop.views.AS2GwtDesktop;
import hr.adriacomsoftware.inf.client.smartgwt.desktop.views.AS2NavigationPane;
import hr.as2.app.client.smartgwt.ref.models.CodeBookModel;
import hr.as2.app.client.smartgwt.ref.models.RefPerspectiveModel;
import hr.as2.app.client.smartgwt.ref.views.ReferenceView;

import java.util.ArrayList;
import java.util.List;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.Canvas;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Ref extends AS2GwtDesktop {
	@Override
	protected boolean isAuthenticationNeeded(){
		return false;
	}
	
	@Override
	protected void getNavigationPaneSections(AS2NavigationPane navigationPane) {
		navigationPane.addSection(RefPerspectiveModel.getInstance().getSectionName(), RefPerspectiveModel.getInstance());
	}
	
	@Override
	protected List<DataSource> getDropDownCacheModels() {
		List<DataSource> list = new ArrayList<DataSource>();
		list.add(CodeBookModel.getInstance());
		return list;
	}
	
	@Override
    public String getNavigationPaneHeader(){
    	return "Adriacom Software d.o.o.";
    }

	@Override
	protected Canvas getView(String name){
		if(name.equals("ref")){
			return new ReferenceView(name);
		}else if(name.equals("ulazna_posta")){
			return new ReferenceView(name);
		}else if(name.equals("izlazna_posta")){
			return new ReferenceView(name);
		}else
			return new AS2ContextArea();

	}
	
	@Override
	protected String getApplicationName() {		
		return "Refereence application";
	}

	@Override
	protected String getApplicationId() {
		return "ref";
	}
	
//	@Override
//	protected String getDefaultViewName() {
//		return "";
//	}
//	
//	protected String getDefaultViewDisplayName(){
//		return "";
//	}
	
}