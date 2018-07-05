import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;

import org.telegram.telegrambots.api.methods.BotApiMethod;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.DefaultBotOptions;

import java.util.function.Predicate;
import static org.telegram.abilitybots.api.objects.Locality.ALL;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

public class Bot extends AbilityBot {
    Bot(String botToken, String botUserName, DefaultBotOptions options) {
        super(botToken, botUserName, options);
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
                .action(ctx -> silent.send("run!", ctx.chatId()))
                .build();
    }

    public Ability replyToSetting() {
        String playWithMe = "play with me";
        return Ability
                .builder()
                .name("settings")
                .info(BotConstants.SETTINGS)
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx ->  silent.send("hi!",ctx.chatId()))
                .build();
    }


    public Ability replyToMyId() {
        return Ability
                .builder()
                .name("myId")
                .info(BotConstants.SETTINGS)
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx -> silent.send("your id is " + String.valueOf(ctx.user().id()), ctx.chatId()))
                .build();
    }

    public Ability replyToQueue(){
        return Ability
                .builder()
                .name("qu")
                .info(BotConstants.SETTINGS)
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx -> silent.send("queue: " + String.valueOf(controller.getQueueSize()), ctx.chatId())
                )
                .build();
    }

    public Ability replyToUpQueue(){
        return Ability
                .builder()
                .name("upQ")
                .info(BotConstants.SETTINGS)
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx -> {
                    controller.queueSize = 1000;
                    silent.send("queue: " + String.valueOf(controller.getQueueSize()), ctx.chatId());
                })
                .build();
    }

   private QueueController controller = new QueueController();

}
