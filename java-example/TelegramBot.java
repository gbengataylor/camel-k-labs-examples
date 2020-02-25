import org.apache.camel.builder.RouteBuilder;

public class TelegramBot extends RouteBuilder {
/*

kamel run --property camel.component.telegram.authorization-token=$TOKEN TelegramBot.java
*/
    @Override
    public void configure() throws Exception {

        from("telegram:bots")
            .choice()
                .when()
                    .simple("${in.body} != null")
                    .to("direct:response1");

        from("direct:response1")
            .log("Incoming message from Telegram is ${in.body}")
            // .setBody()
            //     .simple("You  said ${in.body}?")
            //     .to("telegram:bots");
                .choice()
                    .when(simple("${bodyAs(java.lang.String)} contains \"#camelkrocks\""))
                       .setBody(simple("Did somebody say #camelkrocks? Of course it does!"))
                    //   .to("telegram:bots")
                   // adding this else that echoes
                    .otherwise()
                        .setBody(simple("You said ${in.body} ?"))
                     //   .to("telegram:bots")
                    .end()
                    .to("telegram:bots") ;
    }
}
