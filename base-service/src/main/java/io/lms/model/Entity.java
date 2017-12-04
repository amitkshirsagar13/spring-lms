package io.lms.model;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.GsonBuilder;

/**
 * 
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName DatasyncMicroService
 * &#64;class Entity
 * Creation date: Jan 24, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

public class Entity {

	@Override
	public String toString() {
		return new GsonBuilder().setPrettyPrinting().addSerializationExclusionStrategy(new ExclusionStrategy() {

			@Override
			public boolean shouldSkipField(FieldAttributes arg0) {
				return arg0.getName().contains("logger") ? true : false;
			}

			@Override
			public boolean shouldSkipClass(Class<?> arg0) {
				return false;
			}
		}).create().toJson(this);
	}

	public String toStringNoPretty() {
		return new GsonBuilder().addSerializationExclusionStrategy(new ExclusionStrategy() {

			@Override
			public boolean shouldSkipField(FieldAttributes arg0) {
				return arg0.getName().contains("logger") ? true : false;
			}

			@Override
			public boolean shouldSkipClass(Class<?> arg0) {
				return false;
			}
		}).create().toJson(this);
	}
}
