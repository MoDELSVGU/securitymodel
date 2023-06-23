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

import org.json.simple.JSONObject;

public class Auth {

    private String ocl;
    private String sql;

    public Auth(Object object) {
        JSONObject authJSON = (JSONObject) object;
        this.ocl = (String) authJSON.get("ocl");
        this.sql = (String) authJSON.get("sql");
    }

    public String getOcl() {
        return ocl;
    }

    public void setOcl(String ocl) {
        this.ocl = ocl;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

}
