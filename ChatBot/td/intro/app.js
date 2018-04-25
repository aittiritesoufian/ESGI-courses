require('dotenv').config();
var restify = require("restify");
var builder = require('botbuilder');
var inMemoryStorage = new builder.MemoryBotStorage();

//spaceX
var SpaceXAPI = require('SpaceX-API-Wrapper');
let SpaceX = new SpaceXAPI();

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
        // session.beginDialog('greetings', session.userData.profile);
        session.beginDialog('menu', session.userData.profile);
     },
    // function(session, results){
    //     if(!session.userData.profile){
    //         session.userData.profile = results.response;
    //     }
    //     session.send(`Hello ${session.userData.profile.name} ;)`);
    // }
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
]);

var menuItems = {
    "Compagny Infos": {
        item: 'dialog1'
    },
    "titi": {
        item: 'dialog2'
    },
    "tutu": {
        item: 'dialog3'
    }
}
bot.dialog('menu', [
    function(session){
        builder.Prompts.choice(session,'Please select an option', menuItems, {listStyle: 3})
    },
    function(session,results) {
        var choice = results.response.entity;
        var item = menuItems[choice].item;
        session.beginDialog(item);
    }
]);

bot.dialog('dialog1', [
    function(session){
        SpaceX.getCompanyInfo(function(err, info){
            // console.log(info);
            var adaptativeCard = {
                "type": "AdaptativeCard",
                "text": info.name,
                "attachments": [
                    {
                      "contentType": "application/vnd.microsoft.card.adaptive",
                      "content": {
                        "type": "AdaptiveCard",
                        "version": "1.0",
                        "body": [
                          {
                            "type": "TextBlock",
                            "text": info.summary,
                            "size": "large"
                          },
                          {
                            "type": "TextBlock",
                            "text": "*Sincerely yours,*"
                          },
                          {
                            "type": "TextBlock",
                            "text": "Adaptive Cards",
                            "separation": "none"
                          }
                        ],
                        "actions": [
                          {
                            "type": "Action.OpenUrl",
                            "url": "http://spacex.com/",
                            "title": "Learn More"
                          }
                        ]
                      }
                    }
                  ]
                
            }
            session.send(adaptativeCard);
        });
    }
]);

bot.dialog('dialog2', [
    function(session){
        session.send("You are inside dialog 2")
    }
]);

bot.dialog('dialog3', [
    function(session){
        session.send("You are inside dialog 3")
    }
]);