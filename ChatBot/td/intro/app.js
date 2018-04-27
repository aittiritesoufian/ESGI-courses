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
        session.send("Hi !", session.message.text);
        session.beginDialog('greetings', session.userData.profile);
     },
    function(session, results){
        if(!session.userData.profile){
            session.userData.profile = results.response;
        }
        session.send(`Bienvenue sur le bot ${session.userData.profile.name} ;)`);
        session.beginDialog('menu', session.userData.profile);
    }
]).set('storage', inMemoryStorage);

//dialogues

bot.dialog('greetings', [
    // step 1
    function(session, results, next) {
        session.dialogData.profile = results || {};
        if(!session.dialogData.profile.name){
            builder.Prompts.text(session,'Quel est votre nom ?');
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

//tableau des éléments du menu
var menuItems = {
    "SpaceX - Informations de la société": {
        item: 'dialog1'
    },
    "SpaceX - Dernier lancement": {
        item: 'dialog2'
    }
}
//Dialogue du menu de sélection
bot.dialog('menu', [
    function(session){
        builder.Prompts.choice(session,'Choisissez une action à réaliser : ', menuItems, {listStyle: 3})
    },
    function(session,results) {
        var choice = results.response.entity;
        var item = menuItems[choice].item;
        session.beginDialog(item);
    },
    function(session,results) {
        session.send(results);
    }
]);

//Dialogue des infos de SpaceX
bot.dialog('dialog1', [
    function(session){
        SpaceX.getCompanyInfo(function(err, info){
            // console.log(info);
            var adaptativeCard = {
                "type": "message",
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
                            "text": info.founder
                          },
                          {
                            "type": "TextBlock",
                            "text": info.headquarters.city+", "+info.headquarters.state,
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
            session.endDialogWithResult(adaptativeCard);
        });
    }
]);

//Dialogue des prochains lancements SpaceX
const https = require('https');
bot.dialog('dialog2', [
    function(session){
        https.get('https://api.spacexdata.com/v2/launches/latest', (resp) => {
          let data = '';

          resp.on('data', (chunk) => {
            data += chunk;
          });

          resp.on('end', () => {
            data = JSON.parse(data);
            var adaptativeCard = {
                "type": "message",
                "text": "Numéro de lancement : "+data.flight_number,
                "attachments": [
                    {
                      "contentType": "application/vnd.microsoft.card.adaptive",
                      "content": {
                        "type": "AdaptiveCard",
                        "version": "1.0",
                        "body": [
                          {
                            "type": "TextBlock",
                            "text": data.details,
                            "size": "large"
                          },
                          {
                            "type": "TextBlock",
                            "text": "Date de lancement : "+data.launch_date_local,
                            "separation": "none"
                          },
                          {
                            "type": "TextBlock",
                            "text": "Site de lancement : "+data.launch_site.site_name_long,
                            "separation": "none"
                          }
                        ],
                        "actions": [
                          {
                            "type": "Action.OpenUrl",
                            "url": data.links.article_link,
                            "title": "Learn More"
                          }
                        ]
                      }
                    }
                  ]
                
            }
            session.endDialogWithResult(adaptativeCard);
          });

        }).on("error", (err) => {
          session.endDialogWithResult("Error: " + err.message);
        });
    }
]);


bot.dialog('dialog3', [
    function(session){
        session.endDialogWithResult("You are inside dialog 3")
    }
]);