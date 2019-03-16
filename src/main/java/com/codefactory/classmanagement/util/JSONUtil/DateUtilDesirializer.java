package com.codefactory.classmanagement.util.JSONUtil;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DateUtilDesirializer extends JsonDeserializer<Date> {

	@Override
	public Date deserialize(JsonParser jasonParser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		java.util.Date utilDate;
		String strDate = null;
		java.sql.Date sqlDate = null;
		try {
			strDate = jasonParser.readValueAs(String.class);
			if(strDate != null && !strDate.equals("")){
				utilDate = format.parse(strDate);
				sqlDate = new java.sql.Date(utilDate.getTime());
				return sqlDate;
			}
			
			
		} catch (ParseException e) {
			
			// If the dateformat is in ISO std
			if(strDate != null && !strDate.equals("")) {
				try {
					utilDate = df1.parse(strDate);
					sqlDate = new java.sql.Date(utilDate.getTime());
					return sqlDate;
				} catch (ParseException e1) {
					
					throw new IOException("Failed to parse Date");
				}
			}
			
		}
		
		return null;
		
	}

}