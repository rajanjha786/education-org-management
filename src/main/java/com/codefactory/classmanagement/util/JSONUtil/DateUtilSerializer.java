package com.codefactory.classmanagement.util.JSONUtil;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DateUtilSerializer extends  JsonSerializer<Date> {

	@Override
	public void serialize(Date value, JsonGenerator gen,
			SerializerProvider serializers) throws IOException,
			JsonProcessingException {
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String date  = format.format(value);
		gen.writeString(date);
		
	}
	
	

}