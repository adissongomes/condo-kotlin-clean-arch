package com.adissongomes.condo.app.configuration

import com.adissongomes.condo.domain.condomanager.CondoManagerServiceImpl
import com.adissongomes.condo.domain.condomanager.port.input.CondoManagerService
import com.adissongomes.condo.domain.condomanager.port.output.CondoManagerRepository
import com.adissongomes.condo.domain.condomanager.usecase.CreateCondoManagerUsecase
import com.adissongomes.condo.domain.condomanager.usecase.GetCondoManagerByIdUsecase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeansCondoManagerConfiguration {

    @Bean
    fun createCondoManagerUsecase(condoManagerRepository: CondoManagerRepository): CreateCondoManagerUsecase =
        CreateCondoManagerUsecase(condoManagerRepository)

    @Bean
    fun getCondoManagerByIdUsecase(condoManagerRepository: CondoManagerRepository): GetCondoManagerByIdUsecase =
        GetCondoManagerByIdUsecase(condoManagerRepository)

    @Bean
    fun condoManagerService(
        createCondoManagerUsecase: CreateCondoManagerUsecase,
        getCondoManagerByIdUsecase: GetCondoManagerByIdUsecase
    ): CondoManagerService =
        CondoManagerServiceImpl(createCondoManagerUsecase, getCondoManagerByIdUsecase)
}
