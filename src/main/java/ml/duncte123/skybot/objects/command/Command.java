package ml.duncte123.skybot.objects.command;

import ml.duncte123.skybot.SkyBot;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public abstract class Command {

    /**
     * This is the action of the command, this will hold what the commands needs to to
     * @param args The command agruments
     * @param event a instance of {@link net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent GuildMessageReceivedEvent}
     */
    public abstract void executeCommand(String[] args, GuildMessageReceivedEvent event);

    /**
     * The usage instructions of the command
     * @return a String
     */
    public abstract String help();

    /**
     * This will hold the command name aka what the user puts after the prefix
     * @return The command name
     */
    public abstract String getName();

    /**
     * This wil hold any aliases that this command might have
     * @return the current aliases for the command if set
     */
    public String[] getAliases() {
        return new String[0];
    }

    /**
     * This will return our bot instance
     * @return the main class
     */
    protected SkyBot getBot() {
        return new SkyBot();
    }

    /**
     * This is a shortcut for sending messages to a channel
     * @param event a instance of {@link net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent GuildMessageReceivedEvent}
     * @param msg the message to send
     */
    protected void sendMsg(GuildMessageReceivedEvent event, String msg) {
       sendMsg(event, (new MessageBuilder()).append(msg).build());
    }

    /**
     * This is a shortcut for sending messages to a channel
     * @param event a instance of {@link net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent GuildMessageReceivedEvent}
     * @param msg the message to send
     */
    protected void sendMsg(GuildMessageReceivedEvent event, MessageEmbed msg) {
        sendMsg(event, (new MessageBuilder()).setEmbed(msg).build());
    }

    /**
     * This is a shortcut for sending messages to a channel
     * @param event a instance of {@link net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent GuildMessageReceivedEvent}
     * @param msg the message to send
     */
    protected void sendMsg(GuildMessageReceivedEvent event, Message msg) {
        event.getChannel().sendMessage(msg).queue();
    }

}