package fr.cleymax.frontbot.events;
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




import fr.cleymax.frontbot.Emojis;
import fr.cleymax.frontbot.FrontBot;
import fr.cleymax.frontbot.utils.Logger;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.core.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.managers.GuildController;

import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.SignStyle;
import java.util.*;
import java.util.List;

import static java.time.temporal.ChronoField.*;

/**
 * @author Cleymax
 * @description
 */


public class ChatListener extends ListenerAdapter {
    private Logger l = new Logger(getClass().getSimpleName());

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getChannelType().equals(ChannelType.PRIVATE) || e.getAuthor().isBot()) return;
        if (e.getMessage().getContentRaw().startsWith("/") && e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()) {
            FrontBot.handleCommand(FrontBot.parser.parse(e.getMessage().getContentRaw(), e));
            l.log("COMMANDS", e.getAuthor().getName() + " viens de éxecuté la command '" + e.getMessage().getContentRaw() + "' dans le serveur: " + e.getGuild().getName(), FrontBot.CColor.YELLOW);
        }
    }

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent e) {
        Guild g = e.getGuild();
        GuildController gc = g.getController();
        Member m = e.getMember();
        if (e.getUser().isBot()) return;
        if (e.getTextChannel().getIdLong() == 411888976312532993L) {
            String id = e.getReactionEmote().getId();
            if (id.contains(Emojis.HTML_CSS.get().getId())) {
                gc.addSingleRoleToMember(m, g.getRoleById("411551042942140416")).queue();
            } else if (id.contains(Emojis.DESIGN.get().getId())) {
                gc.addSingleRoleToMember(m, g.getRoleById("411550586677231626")).queue();
            } else if (id.contains(Emojis.UX_UI.get().getId())) {
                gc.addSingleRoleToMember(m, g.getRoleById("411550329541361664")).queue();
            } else if (id.contains(Emojis.PROTOTYPAGE.get().getId())) {
                gc.addSingleRoleToMember(m, g.getRoleById("411826538124673024")).queue();
            } else if (id.contains(Emojis.JAVASCRIPT.get().getId())) {
                gc.addSingleRoleToMember(m, g.getRoleById("413099785990701056")).queue();
            } else if (id.contains(Emojis.GRAPHISME.get().getId())) {
                gc.addSingleRoleToMember(m, g.getRoleById("411550164382121985")).queue();
            } else if (id.contains(Emojis.PHOTOSHOP.get().getId())) {
                gc.addSingleRoleToMember(m, g.getRoleById("411870693316362261")).queue();
            } else if (id.contains(Emojis.ILUSTRATOR.get().getId())) {
                gc.addSingleRoleToMember(m, g.getRoleById("413244017858445314")).queue();
            } else if (id.contains(Emojis.MODELISATION_3D.get().getId())) {
                gc.addSingleRoleToMember(m, g.getRoleById("411550423594565642")).queue();
            } else if (id.contains(Emojis.MOTION_DESIGN.get().getId())) {
                gc.addSingleRoleToMember(m, g.getRoleById("413244640771178497")).queue();
            } else if (id.contains(Emojis.GAMER.get().getId())) {
                gc.addSingleRoleToMember(m, g.getRoleById("412217147700412426")).queue();
            } else if (id.contains(Emojis.SYSADMIN.get().getId())) {
                gc.addSingleRoleToMember(m, g.getRoleById("413069951147048989")).queue();
            }
            l.log("ROLE", "Add role to " + m.getEffectiveName() + " the role: " + e.getReactionEmote().getName());
        } else if (e.getTextChannel().getIdLong() == 411841451790696448L) {
            Message message = e.getChannel().getMessageById(e.getMessageId()).complete();
            Message ma = e.getTextChannel().getMessageById(e.getTextChannel().getLatestMessageId()).complete();


            Map<Long, String> dow = new HashMap<>();
            dow.put(1L, "Lundi");
            dow.put(2L, "Mardi");
            dow.put(3L, "Mercredi");
            dow.put(4L, "Jeudi");
            dow.put(5L, "Vendredi");
            dow.put(6L, "Samedi");
            dow.put(7L, "Dimanche");
            Map<Long, String> moy = new HashMap<>();
            moy.put(1L, "Janvier");
            moy.put(2L, "Février");
            moy.put(3L, "Mars");
            moy.put(4L, "Avril");
            moy.put(5L, "Mai");
            moy.put(6L, "Juin");
            moy.put(7L, "Juillet");
            moy.put(8L, "Août");
            moy.put(9L, "Septembre");
            moy.put(10L, "Octobre");
            moy.put(11L, "Novembre");
            moy.put(12L, "Décembre");
            DateTimeFormatter ok = new DateTimeFormatterBuilder()
                    .parseCaseInsensitive()
                    .parseLenient()
                    .optionalStart()
                    .appendText(DAY_OF_WEEK, dow)
                    .appendLiteral(" ")
                    .optionalEnd()
                    .appendValue(DAY_OF_MONTH, 1, 2, SignStyle.NOT_NEGATIVE)
                    .appendLiteral(" ")
                    .appendText(MONTH_OF_YEAR, moy)
                    .appendLiteral(" ")
                    .appendValue(YEAR, 4)
                    .appendLiteral(", ")
                    .appendValue(HOUR_OF_DAY, 2)
                    .appendLiteral(':')
                    .appendValue(MINUTE_OF_HOUR, 2)
                    .toFormatter(Locale.GERMANY);
            g.getTextChannelById("411841231618834442").sendMessage(
                    new EmbedBuilder()
                            .setDescription(message.getContentRaw())
                            .setTitle(message.getAuthor().getName(), message.getAuthor().getAvatarUrl())
                            .setColor(new Color(41, 128, 185))
                            .setFooter(ma.getCreationTime().format(ok), FrontBot.get().getJda().getSelfUser().getAvatarUrl())
                            .build()
            ).queue();
            Member author = message.getMember();
            if(author== null) return;
            gc.addSingleRoleToMember(author, g.getRoleById("411549614588690433")).queue();
            gc.removeSingleRoleFromMember(author, g.getRoleById("411577303181557760")).queue();
            l.log("JOIN", "Welcome to " + author.getEffectiveName(), FrontBot.CColor.PURPLE);

            message.clearReactions().queue();
        }

    }

    @Override
    public void onMessageReactionRemove(MessageReactionRemoveEvent e) {
        Guild g = e.getGuild();
        GuildController gc = g.getController();
        Member m = e.getMember();
        if (e.getUser().isBot()) return;
        if (e.getTextChannel().getIdLong() == 411888976312532993L) {
            String id = e.getReactionEmote().getId();
            if (id.contains(Emojis.HTML_CSS.get().getId())) {
                gc.removeSingleRoleFromMember(m, g.getRoleById("411551042942140416")).queue();
            } else if (id.contains(Emojis.DESIGN.get().getId())) {
                gc.removeSingleRoleFromMember(m, g.getRoleById("411550586677231626")).queue();
            } else if (id.contains(Emojis.UX_UI.get().getId())) {
                gc.removeSingleRoleFromMember(m, g.getRoleById("411550329541361664")).queue();
            } else if (id.contains(Emojis.PROTOTYPAGE.get().getId())) {
                gc.removeSingleRoleFromMember(m, g.getRoleById("411826538124673024")).queue();
            } else if (id.contains(Emojis.JAVASCRIPT.get().getId())) {
                gc.removeSingleRoleFromMember(m, g.getRoleById("413099785990701056")).queue();
            } else if (id.contains(Emojis.GRAPHISME.get().getId())) {
                gc.removeSingleRoleFromMember(m, g.getRoleById("411550164382121985")).queue();
            } else if (id.contains(Emojis.PHOTOSHOP.get().getId())) {
                gc.removeSingleRoleFromMember(m, g.getRoleById("411870693316362261")).queue();
            } else if (id.contains(Emojis.ILUSTRATOR.get().getId())) {
                gc.removeSingleRoleFromMember(m, g.getRoleById("413244017858445314")).queue();
            } else if (id.contains(Emojis.MODELISATION_3D.get().getId())) {
                gc.removeSingleRoleFromMember(m, g.getRoleById("411550423594565642")).queue();
            } else if (id.contains(Emojis.MOTION_DESIGN.get().getId())) {
                gc.removeSingleRoleFromMember(m, g.getRoleById("413244640771178497")).queue();
            } else if (id.contains(Emojis.GAMER.get().getId())) {
                gc.removeSingleRoleFromMember(m, g.getRoleById("412217147700412426")).queue();
            } else if (id.contains(Emojis.SYSADMIN.get().getId())) {
                gc.removeSingleRoleFromMember(m, g.getRoleById("413069951147048989")).queue();
            }
            l.log("ROLE", "Remove role to " + m.getEffectiveName() + " the role: " + e.getReactionEmote().getName());
        }

    }

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent e) {
        e.getGuild().getController().addSingleRoleToMember(e.getMember(), e.getGuild().getRoleById("411577303181557760")).queue();
    }

    private Color randomColor() {
        List<Color> colors = new ArrayList<>();
        colors.add(new Color(26, 188, 156));
        colors.add(new Color(46, 204, 113));
        colors.add(new Color(52, 152, 219));
        colors.add(new Color(155, 89, 182));


        colors.add(new Color(39, 174, 96));
        colors.add(new Color(41, 128, 185));
        colors.add(new Color(142, 68, 173));

        colors.add(new Color(241, 196, 15));
        colors.add(new Color(230, 126, 34));
        colors.add(new Color(231, 76, 60));
        colors.add(new Color(236, 240, 241));
        colors.add(new Color(149, 165, 166));


        colors.add(new Color(243, 156, 18));
        colors.add(new Color(211, 84, 0));

        colors.add(new Color(192, 57, 43));
        colors.add(new Color(189, 195, 199));
        colors.add(new Color(127, 140, 141));
        Random r = new Random();
        return colors.get(r.nextInt(colors.size()));
    }

}
