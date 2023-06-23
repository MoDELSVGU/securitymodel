/**************************************************************************
Copyright 2019 Vietnamese-German-University
Copyright 2023 ETH Zurich

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

@author: hoangnguyen (hoang.nguyen@inf.ethz.ch)
***************************************************************************/

package modeling.security.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SMUtils {

	public static JSONArray getAttributes(JSONArray context, String className) {
		JSONArray attributes = new JSONArray();
		for (Object entity : context) {
			if (((JSONObject) entity).containsKey("class")) {
				if (((JSONObject) entity).get("class").equals(className)) {
					if (((JSONObject) entity).containsKey("attributes")) {
						attributes = (JSONArray) ((JSONObject) entity).get("attributes");
					}

				}
			}
		}
		return attributes;
	}

	/* className is the name of the UMLclass (i.e., not an UMLassociation */
	@SuppressWarnings("unchecked")
	public static JSONArray getAssociationsFromClass(JSONArray context, String className) {
		JSONArray associations = new JSONArray();
		for (Object object : context) {
			if (((JSONObject) object).containsKey("association")) {
				JSONArray classes = (JSONArray) ((JSONObject) object).get("classes");
				JSONArray ends = (JSONArray) ((JSONObject) object).get("ends");
				for (int index_class = 0; index_class < classes.size(); index_class++) {
					if (classes.get(index_class).equals(className)) {
						JSONObject resource = new JSONObject();
						resource.put("name", ends.get(index_class));
						resource.put("association", ((JSONObject) object).get("association"));
						associations.add(resource);
					}
				}
			}

		}
		return associations;
	}

	public static boolean isAssociation(JSONArray context, String className, String endName) {
		boolean result = false;
		for (Object object : context) {
			if (((JSONObject) object).containsKey("association")) {
				JSONArray ends = (JSONArray) ((JSONObject) object).get("ends");
				for (int index_end = 0; index_end < ends.size(); index_end++) {
					if (ends.get(index_end).equals(endName)) {
						result = true;
						break;
					}
				}
			}
		}

		return result;
	}

	// super
	public static String getSuperClass(JSONArray context, String entityName) {
		// System.out.println(entityName);
		String superClass = null;
		for (Object entity : context) {
			if (((JSONObject) entity).get("class").equals(entityName)) {
				if (((JSONObject) entity).containsKey("super")) {
					superClass = (String) ((JSONObject) entity).get("super");
					break;
				}
			}
		}
		return superClass;
	}

	// super
	public static boolean isSuperKey(JSONArray context, String columnName) {
		boolean result = false;
		for (Object entity : context) {
			if (((JSONObject) entity).containsKey("class")) {
				if (((JSONObject) entity).containsKey("super")) {
					String superClass = (String) ((JSONObject) entity).get("super");
					if (superClass.equals(columnName)) {
						result = true;
					}
				}
			}
		}
		return result;
	}

	// super
	public static boolean isSuper(JSONArray context, String entityName, String attributeName) {
		boolean result = false;
		for (Object entity : context) {
			if (((JSONObject) entity).get("class").equals(entityName)) {
				if (((JSONObject) entity).containsKey("super")) {
					String superClass = (String) ((JSONObject) entity).get("super");
					if (superClass.equals(attributeName)) {
						result = true;
					}
				}
			}
		}
		return result;
	}

	public static boolean isParameter(JSONArray parameters, String columnName) {
		boolean result = false;
		if (parameters == null || parameters.isEmpty())
			return result;
		for (Object par : parameters) {
			if (((JSONObject) par).containsKey("name")) {
				if (((JSONObject) par).get("name").equals(columnName)) {
					result = true;
				}
			}
		}
		return result;
	}
}
