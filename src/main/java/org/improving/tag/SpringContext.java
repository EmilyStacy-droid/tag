package org.improving.tag;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//auto-wiring: follow the norms so developers don't need to write as many codes
@Configuration

@ComponentScan("org.improving.tag")//scan the package whose classes have a component and memorize it

public class SpringContext {
}
