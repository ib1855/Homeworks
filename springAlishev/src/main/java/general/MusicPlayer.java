package general;

import java.util.List;

public class MusicPlayer {
    private String name;
    private int volume;
    private List<Music> musicList;
    public MusicPlayer(List<Music> musicList){
        this.musicList = musicList;
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
