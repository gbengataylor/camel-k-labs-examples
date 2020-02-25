import org.apache.camel.builder.RouteBuilder;

public class JavaHello extends RouteBuilder {
  @Override
  public void configure() throws Exception {
                from("timer:tick")
                    .setBody(constant("Hello"))
                    .log("${body}");
  }
}
