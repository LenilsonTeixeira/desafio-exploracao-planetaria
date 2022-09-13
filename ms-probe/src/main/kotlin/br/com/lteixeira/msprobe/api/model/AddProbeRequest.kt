package br.com.lteixeira.msprobe.api.model

import javax.validation.constraints.NotBlank

data class AddProbeRequest(@field:NotBlank val name: String)
