/**
 * Copyright © 2013 Antonin Stefanutti (antonin.stefanutti@gmail.com)
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
 */
package io.astefanutti.metrics.cdi;

public interface InterceptorPriority {

    /**
     * Start of range for early interceptors defined by
     * platform specifications.
     */
    int PLATFORM_BEFORE = 0;

    /**
     * Start of range for early interceptors defined by
     * extension libraries.
     */
    int LIBRARY_BEFORE = 1000;

    /**
     * Start of range for interceptors defined by
     * applications.
     */
    int APPLICATION = 2000;

    /**
     * Start of range for late interceptors defined by
     * extension libraries.
     */
    int LIBRARY_AFTER = 3000;

    /**
     * Start of range for late interceptors defined by
     * platform specifications.
     */
    int PLATFORM_AFTER = 4000;


}
