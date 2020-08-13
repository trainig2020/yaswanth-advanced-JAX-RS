package org.yaswanth.rest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

@Provider
public class MyDateConverterProvider implements ParamConverterProvider {

	@Override
	public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
		 
		if (rawType.getName().equals(MyDate.class.getName())) {
			
			 return new ParamConverter<T>() {

				@Override
				public T fromString(String value) {
					Calendar requsetdate = Calendar.getInstance();
					if ("tommorow".equalsIgnoreCase(value)) {
						requsetdate.add(Calendar.DATE, 1);
					}
					else if ("yesterday".equalsIgnoreCase(value)) {
						requsetdate.add(Calendar.DATE, -1);
					}
					
					MyDate date = new MyDate();
					date.setDate(requsetdate.get(Calendar.DATE));
					date.setMonth(requsetdate.get(Calendar.MONTH));
					date.setYear(requsetdate.get(Calendar.YEAR));
				   return rawType.cast(date);	
				}
				

				@Override
				public String toString(T myvalue) {
					if(myvalue == null) {
						return null;
					}
					return myvalue.toString();
				}
				 
			 };
		 }
		return null;
	}

}
