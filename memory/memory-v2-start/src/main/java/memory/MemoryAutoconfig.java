package memory;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@ConditionalOnProperty(name = "memory", havingValue = "on")
public class MemoryAutoconfig {

    @Bean
    MemoryController memoryController() {
        return new MemoryController(memoryFinder());
    }

    @Bean MemoryFinder memoryFinder(){
        return new MemoryFinder();
    }
}
