package cib.learning.monorepo.xml2rabbit.integration

import cib.learning.monorepo.xml2rabbit.service.FileXml2Db
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ImportResource
import org.springframework.integration.annotation.InboundChannelAdapter
import org.springframework.integration.annotation.Poller
import org.springframework.integration.channel.DirectChannel
import org.springframework.integration.config.EnableIntegration
import org.springframework.integration.dsl.IntegrationFlow
import org.springframework.integration.dsl.IntegrationFlows
import org.springframework.integration.file.FileReadingMessageSource
import org.springframework.messaging.MessageChannel
import java.io.File

@Configuration
@EnableIntegration
class IntegrationConfig {
    val xml= FileXml2Db()
    @Bean
    fun fileInputChannel(): MessageChannel? {
        return DirectChannel()
    }
    //@Bean
//    @InboundChannelAdapter(value = "fileInputChannel", poller= [Poller(fixedDelay = "1000")])
//    fun fileReadingMessageSource():FileReadingMessageSource{
//        val frms = FileReadingMessageSource()
//        frms.setDirectory(File("c:\\share\\in"))
//        return frms
//    }

//    @Bean()
//    @ServiceActivator (inputChannel = "fileInputChannel")
//    fun fileWritingMessageHandler():FileWritingMessageHandler {
//        val fwmh: FileWritingMessageHandler = FileWritingMessageHandler(File("c:\\share\\out"))
//        fwmh.setAutoCreateDirectory(true)
//        fwmh.setExpectReply(false)
//        return fwmh
//    }

    @Bean
    fun fileReadingFlow00(): IntegrationFlow = inputFlow()
    fun inputFlow()= IntegrationFlows.from("fileInputChannel")
        .handle(xml,"execute")
        .handle(xml,"remove")
        .channel("nullChannel")
        .get()
}