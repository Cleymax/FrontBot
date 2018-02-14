package fr.cleymax.frontbot;
/*
 *	MIT License
 *
 *	Copyright (c) 2018 Cleymax
 *
 *	Permission is hereby granted, free of charge, to any person obtaining a copy
 * 	of this software and associated documentation files (the "Software"), to deal
 *  	in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *	The above copyright notice and this permission notice shall be included in all
 * 	copies or substantial portions of the Software.
 *
 *	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * 	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * 	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * 	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * 	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * 	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * 	SOFTWARE.
 */

import com.vdurmont.emoji.EmojiParser;
import fr.cleymax.frontbot.events.ChatListener;
import fr.cleymax.frontbot.utils.Bot;
import fr.cleymax.frontbot.utils.Logger;
import fr.cleymax.frontbot.utils.commands.Command;
import fr.cleymax.frontbot.utils.commands.CommandParser;
import net.dv8tion.jda.core.*;
import net.dv8tion.jda.core.entities.Emote;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.impl.EmoteImpl;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Cleymax
 * @version 1.0.0
 * @description
 */


public class FrontBot extends Bot {
    private static FrontBot i;
    private final Logger logger = new Logger(getClass().getSimpleName());
    public static HashMap<String, Command> COMMANDS = new HashMap<>();
    public static final CommandParser parser = new CommandParser();
    private JDA jda;
    private JDABuilder builder;
    private boolean started;


    /**
     * @methode Main methode for the jar file.
     */
    public static void main(String[] args) {
        if (i == null) i = new FrontBot();
        try {
            i.onEnable("***");
        } catch (LoginException | RateLimitedException e) {
            e.printStackTrace();
        }
    }

    public void onEnable(String token) throws LoginException, RateLimitedException {
        builder = new JDABuilder(AccountType.BOT);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setGame(Game.playing("Attendre...."));
        builder.setAudioEnabled(true);
        builder.setToken(token);
        builder.setAudioEnabled(true);
        jda = builder.buildAsync();
        jda.addEventListener(new ChatListener());
        started = true;
        while (started) {
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            String[] part = line.split(" ");
            switch (part[0]) {
                case "stop":
                    onDisable();
                    break;
                case "roles":
                    jda.getGuilds().forEach(g -> g.getRoles().forEach(r -> logger.log(r.getName() + "--" + r.getId())));
                    break;
                case "maintenance":
                    jda.getPresence().setGame(Game.playing("En MAINTENANCE ..."));
                    jda.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
                    logger.log("MAINTENANCE", "Maintenance bien changer sur: on", CColor.CYAN);
                    break;
                case "send":
                    Message m = jda.getTextChannelById("411888976312532993").sendMessage(
                            new EmbedBuilder()
                                    .setDescription("**Spécialités Web**: HTML/CSS, Design, UX/UI, Prototypage, Javascript, jQuery")
                                    .setColor(new Color(46, 204, 113))
                                    .build()).complete();
                    m.addReaction(Emojii.HTML_CSS).queue();
                    m.addReaction(Emojii.Design).queue();
                    m.addReaction(Emojii.UX_UI).queue();
                    m.addReaction(Emojii.Prototypage).queue();
                    m.addReaction(Emojii.Javascript).queue();
                    m.addReaction(Emojii.jQuery).queue();

                    Message m1 = jda.getTextChannelById("411888976312532993").sendMessage(
                            new EmbedBuilder()
                                    .setDescription("**Spécialités GFX**: Graphisme, Photoshop, Illustator, Modélisation 3D, Motion Design")
                                    .setColor(new Color(46, 204, 113))
                                    .build()).complete();
                    m1.addReaction(Emojii.Graphisme).queue();
                    m1.addReaction(Emojii.PhotoShop).queue();
                    m1.addReaction(Emojii.Illustrator).queue();
                    m1.addReaction(Emojii.Modelisation3D).queue();
                    m1.addReaction(Emojii.Motion_Design).queue();

                    Message m2 = jda.getTextChannelById("411888976312532993").sendMessage(
                            new EmbedBuilder()
                                    .setDescription("**Autres**: Gamer, Système Admin")
                                    .setColor(new Color(46, 204, 113))
                                    .build()).complete();
                    m2.addReaction(Emojii.Gamer).queue();
                    m2.addReaction(Emojii.SysAdmin).queue();
                    break;

                default:
                    logger.log("COMMANDS", "Commande inconnue !", CColor.CYAN);
                    break;
            }
        }
    }

    public void onDisable() {
        started = false;
        logger.log("JDA", "Le bot c'est bien arrêté avec sucsès !", CColor.GREEN);
        jda.shutdown();
        System.exit(0);
    }

    public static FrontBot get() {
        return i;
    }


    public HashMap<String, Command> getCOMMANDS() {
        return COMMANDS;
    }

    public JDA getJda() {
        return jda;
    }

    public JDABuilder getBuilder() {
        return builder;
    }

    public static enum CColor {
        RESET("\u001B[0m"),
        BLACK("\u001B[30m"),
        RED("\u001B[31m"),
        GREEN("\u001B[32m"),
        YELLOW("\u001B[33m"),
        BLUE("\u001B[34m"),
        PURPLE("\u001B[35m"),
        CYAN("\u001B[36m"),
        WHITE("\u001B[37m");

        private String color;

        CColor(String color) {
            this.color = color;
        }

        public String getCode() {
            return color;
        }
    }

    public static void handleCommand(CommandParser.CommandContainer cmd) {
        if (COMMANDS.containsKey(cmd.invoke)) {
            try {
                COMMANDS.get(cmd.invoke).onExecuted(cmd.args, cmd.event);
            } catch (ParseException | IOException e) {
                e.printStackTrace();
            }
        }
    }


}
