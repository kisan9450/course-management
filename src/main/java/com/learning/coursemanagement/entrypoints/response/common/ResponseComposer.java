package com.learning.coursemanagement.entrypoints.response.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.Objects;

/**
 * Common Response Composer class for JSON and REST response construction.
 */
public class ResponseComposer {

	protected ResponseComposer() {
	}

	public static String createJSONStringForResponse(RestResponse response) {

		Gson gson = new GsonBuilder().create();
		return gson.toJson(response);
	}

	public static <T> RestResponse<T> createRestResponse(List<T> data) {
		RestResponse<T> response = new RestResponse<>();
		if (Objects.isNull(data)) {
			response.setData(List.of());
		}
		else {
			response.setData(data);
		}

		return response;
	}

}
