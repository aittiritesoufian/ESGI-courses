require('dotenv').config();
var restify = require("restify");
var builder = require('botbuilder');

//server
var server = restify.createServer();
server.listen(process.env.PORT, function(){
    console.log("%s listening to %s", server.name, server.url);
})

var connector = new builder.ChatConnector({
    appId : process.env.MICROSOFT_APP_ID,
    appPassword : process.env.MICROSOFT_APP_PASSWORD
});
server.post('/api/messages', connector.listen());

var bot = new builder.UniversalBot(connector, function(session) {
    session.send("You said %s", session.message.text);    
});

