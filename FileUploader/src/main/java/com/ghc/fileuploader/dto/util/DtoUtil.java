package com.ghc.fileuploader.dto.util;

import com.google.gson.GsonBuilder;

public class DtoUtil {
	public static String toString(Object object){
		return new GsonBuilder().setPrettyPrinting().create().toJson(object);
	}
}
