package org.improving.tag;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
 import org.springframework.context.annotation.Bean;
import java.util.Scanner;
//import java.util.Random;

//auto-wiring: follow the norms so developers don't need to write as many codes
@Configuration

@ComponentScan("org.improving.tag")

public class SpringContext {
    @Bean
    public Scanner scanner() {return new Scanner(System.in);}
    //@Bean =>register the following line as a result in Spring
    //public Random getRandom() {return new Random();}
}
