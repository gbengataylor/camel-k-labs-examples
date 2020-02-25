from("timer:tick?period=3s")
  .setBody().constant("Modified Hello World from Camel K-gbenga!!!")
  .to("log:message")
