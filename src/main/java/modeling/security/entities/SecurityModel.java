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

package modeling.security.entities;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SecurityModel {
	private List<String> userClass;
	private List<Rule> rules;

	public List<Rule> getRules() {
		return rules;
	}

	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}

	@Override
	public String toString() {
		return "SecPolicyModel [rules=" + rules + "]";
	}

	public SecurityModel(List<Rule> rules) {
		this.rules = rules;
	}

	public SecurityModel(Object object) throws Exception {

		if (!(object instanceof JSONArray))
			throw new Exception();

		@SuppressWarnings("unchecked")
		List<JSONObject> securityModel = (JSONArray) object;

		List<Rule> rules = new ArrayList<Rule>();
		for (Object entityJSON : securityModel) {
			rules.add(new Rule((JSONObject) entityJSON));
		}
		this.rules = rules;
	}

	public SecurityModel() {
	}

	public List<String> getUserClass() {
		return userClass;
	}

	public void setUserClass(List<String> userClass) {
		this.userClass = userClass;
	}
}
