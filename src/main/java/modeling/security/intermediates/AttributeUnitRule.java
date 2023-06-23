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

public class AttributeUnitRule extends SecUnitRule {
    private String entity;
    private String attribute;

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public AttributeUnitRule(String action, String role, List<AuthorizationConstraint> auths,
        String entity, String attribute) {
        super(action, role, auths);
        this.entity = entity;
        this.attribute = attribute;
    }

    public AttributeUnitRule(String action, String role, List<AuthorizationConstraint> auths) {
        super(action, role, auths);
    }

}
