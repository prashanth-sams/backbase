package ecommerce.propertyfinderae.datasource;

public enum OR {
	CATEGORY_FIELD("form#search-form-property .search-wrapper .ms-drop ul > li[data-value='1']");
	
	
	
	String id;
	
	private OR(String sel) {
		this.id = sel;
	}
}
