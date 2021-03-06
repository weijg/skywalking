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

package org.skywalking.apm.plugin.spring.mvc;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The <code>PathMappingCache</code> represents a field
 *
 * @author wusheng
 */
public class PathMappingCache {
    private String classPath = "";

    private ConcurrentHashMap<Method, String> methodPathMapping = new ConcurrentHashMap<Method, String>();

    public PathMappingCache(String classPath) {
        this.classPath = classPath;
    }

    public String findPathMapping(Method method) {
        return methodPathMapping.get(method);
    }

    public void addPathMapping(Method method, String methodPath) {
        methodPathMapping.put(method, classPath + methodPath);
    }
}
