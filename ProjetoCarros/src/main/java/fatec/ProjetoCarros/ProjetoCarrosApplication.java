package fatec.ProjetoCarros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "API de Carros",
                version = "1.0",
                description = "Documentação da API do ProjetoCarros"
        )
)
public class ProjetoCarrosApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjetoCarrosApplication.class, args);
    }
}

