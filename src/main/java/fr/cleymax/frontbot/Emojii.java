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

public class Emojii {

    private static Guild g = FrontBot.get().getJda().getGuildById("411548953935347724");

    public static  Emote HTML_CSS = g.getEmoteById("411928637357686784");
    public static  Emote Design = g.getEmoteById("411928860976873472");
    public static  Emote UX_UI = g.getEmoteById("411928933315903490");
    public static  Emote Prototypage = g.getEmoteById("411928775593295873");
    public static  Emote Javascript = g.getEmoteById("412570005180514304");
    public static  Emote jQuery = g.getEmoteById("412569985542520834");
    public static  Emote Graphisme = g.getEmoteById("411929032741879808");
    public static  Emote PhotoShop = g.getEmoteById("411928705435435010");
    public static  Emote Illustrator = g.getEmoteById("411928746648666113");
    public static  Emote Modelisation3D = g.getEmoteById("412570027527634946");
    public static  Emote Motion_Design = g.getEmoteById("412571157221343244");
    public static  Emote Gamer = g.getEmoteById("412569969142792202");
    public static  Emote SysAdmin = g.getEmoteById("412570049002471424");
}