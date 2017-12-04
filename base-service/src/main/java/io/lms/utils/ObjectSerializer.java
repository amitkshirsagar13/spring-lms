package io.lms.utils;

import org.springframework.stereotype.Component;

import com.fatboyindustrial.gsonjodatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

/**
 * 
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName DatasyncMicroService
 * &#64;class ObjectSerializer
 * Creation date: Dec 30, 2016
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

@Component
public class ObjectSerializer {

	private static final Gson gson = Converters.registerDateTime(new GsonBuilder()).create();

	public String serialize(Object object) {
		return gson.toJson(object);
	}

	public String serialize(Object object, Class klass) {
		return gson.toJson(object, klass);
	}

	public <T> T deserialize(String string, Class<T> klass) {
		return gson.fromJson(string, klass);
	}

	public <T> T deserialize(JsonElement element, Class<T> klass) {
		return gson.fromJson(element, klass);
	}

	public Gson gson() {
		return gson;
	}

	public JsonElement serializeToTree(Object object, Class klass) {
		return gson.toJsonTree(object, klass);
	}
}
