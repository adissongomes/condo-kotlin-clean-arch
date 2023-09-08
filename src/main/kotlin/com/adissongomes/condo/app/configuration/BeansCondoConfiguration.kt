package com.adissongomes.condo.app.configuration

import com.adissongomes.condo.domain.condo.CondoApplicationServiceImpl
import com.adissongomes.condo.domain.condo.CondoDomainService
import com.adissongomes.condo.domain.condo.port.input.CondoService
import com.adissongomes.condo.domain.condo.port.output.CondoRepository
import com.adissongomes.condo.domain.condomanager.port.output.CondoManagerRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeansCondoConfiguration {

    @Bean
    fun condoService(condoRepository: CondoRepository,
                     condoManagerRepository: CondoManagerRepository,
                     condoDomainService: CondoDomainService): CondoService =
        CondoApplicationServiceImpl(condoDomainService, condoRepository, condoManagerRepository)
}
