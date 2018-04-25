require('dotenv').config();
var restify = require("restify");
var builder = require('botbuilder');
var inMemoryStorage = new builder.MemoryBotStorage();

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
        session.beginDialog('greetings', session.userData.profile);
    },
    function(session, results){
        if(!session.userData.profile){
            session.userData.profile = results.response;
        }
        session.send(`Hello ${session.userData.profile.name} ;)`);
    }
]).set('storage', inMemoryStorage);

//dialogues

bot.dialog('greetings', [
    // step 1
    function(session, results, next) {
        session.dialogData.profile = results || {};
        if(!session.dialogData.profile.name){
            builder.Prompts.text(session,'what is your name ?');
        } else {
            next();
        }
    },
    // step 2
    function(session,results) {
        if(results.response){
            session.dialogData.profile.name = results.response;
        }
        session.endDialogWithResult({response: session.dialogData.profile});
    }
])