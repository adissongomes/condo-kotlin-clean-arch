package com.adissongomes.condo.app.configuration

import com.adissongomes.condo.domain.condomanager.CondoManagerServiceImpl
import com.adissongomes.condo.domain.condomanager.port.input.CondoManagerService
import com.adissongomes.condo.domain.condomanager.port.output.CondoManagerRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeansCondoManagerConfiguration {

    @Bean
    fun condoManagerService(condoManagerRepository: CondoManagerRepository): CondoManagerService =
        CondoManagerServiceImpl(condoManagerRepository)
}
