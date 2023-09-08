package com.adissongomes.condo.app.configuration

import com.adissongomes.condo.domain.condo.CondoServiceImpl
import com.adissongomes.condo.domain.condo.port.input.CondoService
import com.adissongomes.condo.domain.condo.port.output.CondoRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeansCondoConfiguration {

    @Bean
    fun condoService(condoRepository: CondoRepository): CondoService =
        CondoServiceImpl(condoRepository)
}
