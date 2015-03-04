package hr.as2.app.client.smartgwt.ref.models;

import hr.adriacomsoftware.inf.client.smartgwt.desktop.perspective.xml.AS2NavigationPaneSectionDaoModel;

public class RefPerspectiveModel extends AS2NavigationPaneSectionDaoModel {
	public static final String DEFAULT_PERSPECTIVE_NAME = "ref";
	public static final String DEFAULT_PERSPECTIVE_DISPLAY_NAME = "Reference application";
	
	private static RefPerspectiveModel instance = new RefPerspectiveModel("RefPerspectiveModel");
	public static RefPerspectiveModel getInstance() {
		return instance;
	}

	public RefPerspectiveModel(String id) {
		super(id);
	}

	public String getSectionName() {
		return DEFAULT_PERSPECTIVE_DISPLAY_NAME;
	}

	@Override
	public String getDefaultPerspectiveName() {
		return DEFAULT_PERSPECTIVE_NAME;
	}
}
