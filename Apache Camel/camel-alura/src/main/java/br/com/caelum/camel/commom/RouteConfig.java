package br.com.caelum.camel.commom;

import org.apache.camel.component.http4.HttpMethods;

public class RouteConfig {

	private HttpMethods method;
	private String url;

	public RouteConfig(HttpMethods method, String url) {
		this.method = method;
		this.url = url;
	}

	public HttpMethods getMethod() {
		return method;
	}

	public void setMethod(HttpMethods method) {
		this.method = method;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
