package br.com.lteixeira.msprobe.application.controller

import br.com.lteixeira.msprobe.api.GetAllProbesApi
import br.com.lteixeira.msprobe.api.model.GetAllProbesResponse
import br.com.lteixeira.msprobe.application.converter.toGetAllProbesResponse
import br.com.lteixeira.msprobe.application.usecase.GetAllProbesUseCase
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.RestController

@RestController
class GetAllProbesController(private val getAllProbesUseCase: GetAllProbesUseCase): GetAllProbesApi {
    override fun getAll(page: Int, size: Int): Page<GetAllProbesResponse> {
        return getAllProbesUseCase.execute(page, size).map { it.toGetAllProbesResponse() }
    }
}