package fr.cleymax.frontbot.utils;
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

import fr.cleymax.frontbot.FrontBot;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Cleymax
 * @version 1.0-SNAPSHOT
 * @description it's a class for manage and create logger
 */


public class Logger {

    private String className;
    private String sdf;
    private Date date;

    public Logger(String className) {
        this.className = className;
    }

    public void log(String type, String s) {
        log(type,s, FrontBot.CColor.RESET);
    }

    public void log(String type, String s, FrontBot.CColor cColor) {
        date = new Date();
        sdf = new SimpleDateFormat("[HH:mm dd/MM/YYYY] ").format(date);
        System.out.println(cColor.getCode() + sdf + "[" +className + "] [ " + type + " ]: " +s + FrontBot.CColor.RESET.getCode());
    }

    public void log(String s) {
        date = new Date();
        sdf = new SimpleDateFormat("[HH:mm dd/MM/YYYY] ").format(date);
        System.out.println(FrontBot.CColor.RESET.getCode() + sdf + "[" +className + "]: " +s+ FrontBot.CColor.RESET.getCode() );
    }
}
