package br.com.lteixeira.msprobe.application.instrument

import br.com.lteixeira.msprobe.application.helper.MetricHelper
import io.micrometer.core.instrument.Counter
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.stereotype.Component

@Component
class Counter(val meterRegistry: MeterRegistry) {

    fun count(metric: MetricHelper) {
        Counter.builder(metric._name)
            .description(metric.description)
            .register(this.meterRegistry).increment()
    }
}