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

import modeling.security.utils.SecResourceFactory;

public class Rule {
    private List<Role> roles;
    private List<Action> actions;
    private List<Resource> resources;
    private List<Auth> auth;

    public Rule(JSONObject authEntityJSON) {
        roles = convertRoles((JSONArray) authEntityJSON.get("roles"));
        actions = convertActions((JSONArray) authEntityJSON.get("actions"));
        resources = convertResources(
            (JSONArray) authEntityJSON.get("resources"));
        auth = convertAuth((JSONArray) authEntityJSON.get("auth"));
    }

    private List<Auth> convertAuth(JSONArray authsJSON) {
        List<Auth> auths = new ArrayList<Auth>();
        for (Object authJSON : authsJSON) {
            auths.add(new Auth(authJSON));
        }
        return auths;
    }

    private List<Resource> convertResources(JSONArray resourcesJSON) {
        List<Resource> resources = new ArrayList<Resource>();
        for (Object resourceJSON : resourcesJSON) {
            resources.add(SecResourceFactory.create(resourceJSON));
        }
        return resources;
    }

    private List<Action> convertActions(JSONArray actionsJSON) {
        List<Action> actions = new ArrayList<Action>();
        for (Object actionJSON : actionsJSON) {
            actions.add(Action.getAction((String) actionJSON));
        }
        return actions;
    }

    private List<Role> convertRoles(JSONArray rolesJSON) {
        List<Role> roles = new ArrayList<Role>();
        for (Object roleJSON : rolesJSON) {
            roles.add(new Role((String) roleJSON));
        }
        return roles;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public List<Auth> getAuth() {
        return auth;
    }

    public void setAuth(List<Auth> auth) {
        this.auth = auth;
    }

    public Rule(List<Role> roles, List<Action> actions,
        List<Resource> resources, List<Auth> auth) {
        super();
        this.roles = roles;
        this.actions = actions;
        this.resources = resources;
        this.auth = auth;
    }

    public Rule() {
    }
}


