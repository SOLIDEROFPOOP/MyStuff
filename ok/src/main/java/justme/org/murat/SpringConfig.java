package justme.org.murat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Configuration
@ComponentScan("justme.org.murat")
@PropertySource("classpath:musicplayer.properties")
public class SpringConfig {
    @Bean
    public ClassicalMusic classicalMusic(){
        return new ClassicalMusic();
    }
    @Bean
    public RockMusic rockMusic(){
        return new RockMusic();
    }
    @Bean
    public MusicPlayer musicPlayer(){
        return new MusicPlayer(songList());
    }
    @Bean
    public Computer computer(){
        return new Computer(musicPlayer());
    }
    @Bean
    public HipHopMusic hipHopMusic(){
        return new HipHopMusic();
    }
    @Bean
    public ArrayList<Music> musicList(){
        return new ArrayList<>(){{
            add(hipHopMusic());
            add(rockMusic());
            add(classicalMusic());
        }};
    }
    @Bean
    public SongList songList(){
        return new SongList(musicList());
    }
}
