require('dotenv').config();
var restify = require("restify");
var builder = require('botbuilder');

//server
var server = restify.createServer();
server.listen(process.env.PORT, function(){
    console.log("%s listening to %s", server.name, server.url);
})

//Connector
var connector = new builder.ChatConnector({
    appId : process.env.MICROSOFT_APP_ID,
    appPassword : process.env.MICROSOFT_APP_PASSWORD
});
server.post('/api/messages', connector.listen());

//Universal bot
var bot = new builder.UniversalBot(connector, [
    function(session) {
        session.send("You said %s", session.message.text);
        session.beginDialog('greetings');
    },
    function(session, results){
        session.endDialog(`Hello ${results.response} ;)`);
    }
]);

//dialogues

bot.dialog('greetings', [
    // step 1
    function(session) {
        builder.Prompts.text(session,'what is your name ?')
    },
    // step 2
    function(session,results) {
        session.endDialogWithResult(results);
    }
])