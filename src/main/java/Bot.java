import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.telegrambots.bots.DefaultBotOptions;

import static org.telegram.abilitybots.api.objects.Locality.ALL;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

public class Bot extends AbilityBot {
    Bot(String botToken, String botUserName,DefaultBotOptions options){
        super(botToken,botUserName, options);
    }

    @Override
    public int creatorId() {
        return 0;
    }

    public Ability replyToStart() {
        return Ability
                .builder()
                .name("start")
                .info(BotConstants.START_DESCRIPTION)
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx ->  silent.send("Привет!", ctx.chatId()))
                .build();
    }

    public Ability replyToSetting() {
        return Ability
                .builder()
                .name("settings")
                .info(BotConstants.SETTINGS)
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx ->  silent.send("Настройки!", ctx.chatId()))
                .build();
    }

    public Ability replyToMyId() {
        return Ability
                .builder()
                .name("myId")
                .info(BotConstants.SETTINGS)
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx ->  silent.send("your id is " + String.valueOf(ctx.user().id()), ctx.chatId()))
                .build();
    }



}
