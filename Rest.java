//
// To run this integrations use:
//
//     kamel run --name=restjava --dependency=camel-restlet  Rest.java
//
//
//import org.springframework.stereotype.Component;
import org.apache.camel.builder.RouteBuilder;

//@Component
public class Rest extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration()
            .component("restlet")
            .host("localhost")
            .port("8080");

        rest()
            .get("/hello")
            .to("direct:hello");

        from("direct:hello")
            .transform().simple("Hello World");
    }
}
