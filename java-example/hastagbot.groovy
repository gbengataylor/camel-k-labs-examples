//kamel run --property camel.component.telegram.authorization-token=$TOKEN hastagbot.groovy

from("telegram:bots")
    .choice()
        .when()
            .simple('${in.body} != null')
            .to("direct:response1")

from("direct:response1")
    .log('Incoming message from Telegram is ${in.body}')
    .setBody()
        .simple('You said  \"${in.body}\"? ')
        .to("telegram:bots")