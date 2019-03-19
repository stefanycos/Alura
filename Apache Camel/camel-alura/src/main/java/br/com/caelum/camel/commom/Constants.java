package br.com.caelum.camel.commom;

public class Constants {
	
	private Constants() {
		
	}

	public static final String LOG_BODY = "${body}";
	public static final String LOG_ID = "${id}";
	
	public static final String ITEM_URL = "http4://localhost:8080/webservices/ebook/item";
	public static final String FINANCEIRO_URL = "http4://localhost:8080/webservices/financeiro";
	
	public static final String XPATH_SPLIT_PEDIDO = "/pedido/itens/item";
	public static final String XPATH_FILTER_PEDIDO = "/item/formato[text() = 'EBOOK']";
	
	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

}
