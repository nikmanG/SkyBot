package me.duncte123.skybot.commands.music;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import me.duncte123.skybot.Command;
import me.duncte123.skybot.SkyBot;
import me.duncte123.skybot.audio.GuildMusicManager;
import me.duncte123.skybot.utils.AudioUtils;
import me.duncte123.skybot.utils.Functions;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class PauseCommand implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {


        if(!event.getGuild().getAudioManager().getConnectedChannel().getMembers().contains(event.getMember())){
            event.getTextChannel().sendMessage(Functions.embedField(SkyBot.au.embedTitle, "I'm sorry, but you have to be in the same channel as me to use any music related commands")).queue();
            return false;
        }

        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        AudioUtils au = SkyBot.au;

        Guild guild = event.getGuild();
        GuildMusicManager mng = au.getMusicManager(guild);
        AudioPlayer player = mng.player;

        if (player.getPlayingTrack() == null){
            event.getTextChannel().sendMessage(Functions.embedField(au.embedTitle, "Cannot pause or resume player because no track is loaded for playing.")).queue();
            return;
        }

        player.setPaused(!player.isPaused());
        if (player.isPaused()){
            event.getTextChannel().sendMessage(Functions.embedField(au.embedTitle, "The player has been paused.")).queue();
        }else{
            event.getTextChannel().sendMessage(Functions.embedField(au.embedTitle, "The player has resumed playing.")).queue();
        }
    }

    @Override
    public String help() {
        // TODO Auto-generated method stub
        return "pauses the current song";
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        // TODO Auto-generated method stub

    }

}
