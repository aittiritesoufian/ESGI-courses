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
        if(session.userData.name){
            session.endDialog(`Hello ${session.userData.name} ;)`);
        } else {
            session.endDialog(`Hello ${results.response} ;)`);
        }
    }
]);

//dialogues

bot.dialog('greetings', [
    // step 1
    function(session, args, next) {
        if(session.userData.name){
            next();
        } else {
            builder.Prompts.text(session,'what is your name ?')
        }
    },
    // step 2
    function(session,results) {
        if(session.userData.name == null){
            session.userData.name = results.response;
            session.save();
        }
        session.endDialogWithResult(results);
    }
])