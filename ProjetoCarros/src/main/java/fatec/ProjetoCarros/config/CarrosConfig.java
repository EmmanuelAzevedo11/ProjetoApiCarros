package fatec.ProjetoCarros.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarrosConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Projeto Carros - FATEC") // Título da API
                        .description("API desenvolvida para o gerenciamento de um galpão de carros (CRUD).") // Descrição
                        .version("1.0.0") // Versão da API
                        .contact(new Contact() // Informações de Contato
                                .name("Emmanuel Forcinetti Azevedo")
                                .email("emmanuel.azevedo@fatec.sp.gov.br")
                                .name("Pedro Augusto Amgarten Alves")
                                .email("pedro.alves20@fatec.sp.gov.br")
                                .name("Pedro Gabriel dos Santos")
                                .email("pedro.santos282@fatec.sp.gov.br\n")));
    }

}
