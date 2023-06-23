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

package modeling.security.intermediates;

import java.util.List;

public abstract class SecUnitRule {
    private String action;
    private String role;
    private List<AuthorizationConstraint> auths;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public SecUnitRule(String action, String role, List<AuthorizationConstraint> auths) {
        this.action = action;
        this.role = role;
        this.auths = auths;
    }

    public SecUnitRule() {
    }

    public List<AuthorizationConstraint> getAuths() {
        return auths;
    }

    public void setAuths(List<AuthorizationConstraint> auths) {
        this.auths = auths;
    }

}
