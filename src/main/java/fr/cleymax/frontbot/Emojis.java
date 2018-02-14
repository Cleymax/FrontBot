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

import net.dv8tion.jda.core.entities.Emote;
import net.dv8tion.jda.core.entities.Guild;


/**
 * @author Cleymax
 * @version 1.0.0
 * @description Enum for all Emoji
 */

public enum Emojis {

    HTML_CSS("411548953935347724", "411928637357686784"),
    DESIGN("411548953935347724","411928860976873472"),
    UX_UI("411548953935347724","411928933315903490"),
    PROTOTYPAGE("411548953935347724","411928775593295873"),
    JAVASCRIPT("411548953935347724","412570005180514304"),
    GRAPHISME("411548953935347724","411929032741879808"),
    PHOTOSHOP("411548953935347724","411928705435435010"),
    ILUSTRATOR("411548953935347724","411928746648666113"),
    MODELISATION_3D("411548953935347724","412570027527634946"),
    MOTION_DESIGN("411548953935347724","412571157221343244"),
    GAMER("411548953935347724","412569969142792202"),
    SYSADMIN("411548953935347724","412570049002471424");
    private String guild_id, emote_id;


    Emojis(String guild_id, String emote_id) {
        this.guild_id = guild_id;
        this.emote_id = emote_id;
    }

    public Emote get(){
        return FrontBot.get().getJda().getGuildById(guild_id).getEmoteById(emote_id);
    }

}