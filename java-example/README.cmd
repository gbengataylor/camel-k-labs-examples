# camel-k-labs-examples

create a bot using instructions here - https://www.nicolaferraro.me/2016/05/27/creating-a-telegram-bot-in-5-minutes-with-apache-camel/

set token
```
TOKEN=<token>
```

run TelegramBot

```
kamel run --property camel.component.telegram.authorization-token=$TOKEN hastagbot.groovy
```

to add TOKEN as a property via the vscode plugin or secret see https://developers.redhat.com/blog/2019/09/30/sending-a-telegram-with-apache-camel-k-and-visual-studio-code/