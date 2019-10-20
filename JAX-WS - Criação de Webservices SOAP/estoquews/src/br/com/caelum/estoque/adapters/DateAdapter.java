package br.com.caelum.estoque.adapters;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date>{
	
	private String pattern;
	
	public Date unmarshal(String dateString) throws Exception{
		return new SimpleDateFormat(pattern).parse(dateString);
	}
	
	public String marshal(Date data) throws Exception{
		return new SimpleDateFormat(pattern).format(data);
	}
}
