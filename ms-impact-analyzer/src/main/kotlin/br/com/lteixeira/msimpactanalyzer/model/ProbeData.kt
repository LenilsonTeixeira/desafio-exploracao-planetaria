package br.com.lteixeira.msimpactanalyzer.model

import br.com.lteixeira.msimpactanalyzer.document.Probe

data class ProbeData(val totalElements: Long, val probes: List<Probe>)
