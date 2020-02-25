//
// To run this integrations use:
//
//     kamel run --name=withrestjs --dependency=camel-undertow rest.js
//

// ****************
//
// Setup
//
// ****************

l = components.get('log')
l.exchangeFormatter = function(e) {
    return "log - body=" + e.in.body + ", headers=" + e.in.headers
}

c = restConfiguration()
c.component = 'undertow'
c.port = 8080

// ****************
//
// Functions
//
// ****************

function proc(e) {
    e.getIn().setHeader('RandomValue', Math.floor((Math.random() * 100) + 1))
}

// ****************
//
// Route
//
// ****************

rest()
    //.path('/say/hello')
    .path('/')
    .produces("text/plain")
    .get().route()
        .to("direct:hello");

from("direct:hello")
        .transform().constant("Hello World");
        //.log('{body}');
/*
from('timer:js?period=1s')
    .routeId('js')
    .setBody()
        .constant('Hello Camel K')
    .process(proc)
    .to('log:info')
*/
