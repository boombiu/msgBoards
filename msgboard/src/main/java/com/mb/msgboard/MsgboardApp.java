package com.mb.msgboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class MsgboardApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(MsgboardApp.class, args);
        System.out.println( "msgboard start success!" );
    }
}
