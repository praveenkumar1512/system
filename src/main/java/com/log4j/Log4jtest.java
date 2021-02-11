package com.log4j;

import org.apache.log4j.Logger;

public class Log4jtest
{
	/*--------------------------use logger------------------------*/
    public final static Logger logger = Logger.getLogger(Log4jtest.class);
    public  static  void logger_function(String a)
    {
        logger.info(a);
    }
}