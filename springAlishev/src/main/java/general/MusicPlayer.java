package general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class MusicPlayer {
    private String name;
    private int volume;
    private List<Music> musicList;

    public Music getMusic() {
        return music;
    }

    @Autowired
    public void setMusic(@Qualifier("musicBeanRock") Music music) {
        this.music = music;
    }

    private Music music;
    public MusicPlayer(List<Music> musicList, Music music){
        this.musicList = musicList;
        this.music = music;
    }

    public MusicPlayer() {
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void playMusic(){
        for (Music music: musicList
             ) {
            System.out.println("Playing: "  + music.getSong());
        }
    }

}
