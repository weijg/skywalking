/*
 * Copyright 2017, OpenSkywalking Organization All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Project repository: https://github.com/OpenSkywalking/skywalking
 */

package org.skywalking.apm.plugin.jdbc.connectionurl.parser;

import org.skywalking.apm.plugin.jdbc.ConnectionInfo;

/**
 * {@link URLParser#parser(String)} support parse the connection url, such as Mysql, Oracle, H2 Database.
 * But there are some url cannot be parsed, such as Oracle connection url with multiple host.
 *
 * @author zhangxin
 */
public class URLParser {

    private static final String MYSQL_JDBC_URL_PREFIX = "jdbc:mysql";
    private static final String ORACLE_JDBC_URL_PREFIX = "jdbc:oracle";
    private static final String H2_JDBC_URL_PREFIX = "jdbc:h2";

    public static ConnectionInfo parser(String url) {
        ConnectionURLParser parser = null;
        if (url.startsWith(MYSQL_JDBC_URL_PREFIX)) {
            parser = new MysqlURLParser(url);
        } else if (url.startsWith(ORACLE_JDBC_URL_PREFIX)) {
            parser = new OracleURLParser(url);
        } else if (url.startsWith(H2_JDBC_URL_PREFIX)) {
            parser = new H2URLParser(url);
        }
        return parser.parse();
    }
}
