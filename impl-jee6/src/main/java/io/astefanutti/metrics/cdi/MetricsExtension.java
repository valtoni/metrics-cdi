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

import com.codahale.metrics.Metric;
import com.codahale.metrics.annotation.CachedGauge;
import com.codahale.metrics.annotation.Counted;
import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Gauge;
import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.AfterDeploymentValidation;
import javax.enterprise.inject.spi.AnnotatedMember;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;
import javax.enterprise.inject.spi.ProcessProducerField;
import javax.enterprise.inject.spi.ProcessProducerMethod;
import javax.enterprise.util.AnnotationLiteral;
import java.util.HashMap;
import java.util.Map;

public class MetricsExtension implements Extension {

    private static final AnnotationLiteral<Default> DEFAULT = new AnnotationLiteral<Default>(){};

    private final Map<Bean<?>, AnnotatedMember<?>> metrics = new HashMap<>();

    private static Logger logger = LoggerFactory.getLogger(MetricsExtension.class);

    static {
        logger.info("XXXXXXX 0");
    }

    public MetricsExtension() {
        logger.info("XXXXXXX 0-1");
    }

    private void addInterceptorBindings(@Observes BeforeBeanDiscovery bbd, BeanManager manager) {
        logger.info("XXXXXXX 2");
    }

    private Class[] targetAnnotations = new Class[] {
            CachedGauge.class, Counted.class, ExceptionMetered.class, Gauge.class, Metered.class, Timed.class
    };

    private <X> void metricsAnnotations(@Observes ProcessAnnotatedType<X> pat) {
        logger.info("XXXXXXX 3");
    }

    private void metricProducerField(@Observes ProcessProducerField<? extends Metric, ?> ppf) {
        logger.info("XXXXXXX 4");
    }

    private void metricProducerMethod(@Observes ProcessProducerMethod<? extends Metric, ?> ppm) {
        logger.info("XXXXXXX 5");
    }

    private void defaultMetricRegistry(@Observes AfterBeanDiscovery abd, BeanManager manager) {
        logger.info("XXXXXXX 6");
    }

    private void configuration(@Observes AfterDeploymentValidation adv, BeanManager manager) {
        logger.info("XXXXXXX 7");
    }
}