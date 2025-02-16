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

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.AfterDeploymentValidation;
import javax.enterprise.inject.spi.AnnotatedMember;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessProducerField;
import javax.enterprise.inject.spi.ProcessProducerMethod;

import com.codahale.metrics.health.HealthCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HealthCheckExtension implements Extension {

    private static Logger logger = LoggerFactory.getLogger(HealthCheckExtension.class);

    static {
        logger.info("YYYYYYYYYYYYYYYYY 0");
    }

    public HealthCheckExtension() {
        logger.info("YYYYYYYYYYYYYYYYY 0-1");
    }

    private final Map<Bean<?>, AnnotatedMember<?>> healthChecks = new HashMap<>();

    private void healthCheckProducerField(@Observes ProcessProducerField<? extends HealthCheck, ?> ppf) {
        logger.info("YYYYYYYYYYYYYYYYY 1");
        healthChecks.put(ppf.getBean(), ppf.getAnnotatedProducerField());
    }

    private void healthCheckProducerMethod(@Observes ProcessProducerMethod<? extends HealthCheck, ?> ppm) {
        logger.info("YYYYYYYYYYYYYYYYY 2");
        healthChecks.put(ppm.getBean(), ppm.getAnnotatedProducerMethod());
    }

    private void defaultHealthCheckRegistry(@Observes AfterBeanDiscovery abd, BeanManager manager) {
        logger.info("YYYYYYYYYYYYYYYYY 3");
    }

    private void configuration(@Observes AfterDeploymentValidation adv, BeanManager manager) {
        logger.info("YYYYYYYYYYYYYYYYY 4");
    }
}