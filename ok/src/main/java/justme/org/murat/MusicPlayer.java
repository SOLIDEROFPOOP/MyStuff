package justme.org.murat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

/*@Component*/
public class MusicPlayer {
    private SongList songList;
    @Value("${musicPlayer.name}")
    public String name;
    @Value("${musicPlayer.volume}")
    public Integer volume;
    Random random = new Random();
    /*@Autowired
    @Qualifier("rockMusic")*/
    /*private Music music1;*/
    /*@Autowired
    @Qualifier("classicalMusic")*/
    /*private Music music2;*/
    public void playMusic(){
        System.out.println(songList.songs.get(random.nextInt(songList.songs.size())).getSong());
        System.out.println((songList.songs.get(random.nextInt(songList.songs.size()))).getSong());
    }
    public MusicPlayer(SongList songList){
        this.songList = songList;
    }
}
