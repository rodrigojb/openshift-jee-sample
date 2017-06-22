package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;


@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
//        mostrarAsciiArtInicial();
        levantarMongo();
        LOG.info("Mongo levantado.");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    private static Class<Application> applicationClass = Application.class;


    private static void levantarMongo() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
        MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
    }

//    private static void mostrarAsciiArtInicial() {
//        final File workspacePath = getWorkspacePath();
//        final File asciiLogo = new File(workspacePath.getAbsolutePath() + "/src/main/resources/asciiart.txt");
//        try {
//            final String logoAscii = org.apache.commons.io.FileUtils.readFileToString(asciiLogo);
//            LOG.info("Iniciando:\n" + logoAscii);
//        } catch (final IOException e) {
//            LOG.error("Falló la carga del ascii logo, ignorando");
//        }
//
//    }
//
//    private static File getWorkspacePath() {
//        return new File(".").getAbsoluteFile();
//    }
}