package general;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import popMusicPackage.PopMusic;


public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

//        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//        musicPlayer.playMusic();
        //System.out.println(musicPlayer.getName());
        //System.out.println(musicPlayer.getVolume());
        Music music = context.getBean("TestComponent", PopMusic.class);
        System.out.println(music.getSong());
        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        System.out.println(musicPlayer.getMusic().getSong());
        context.close();
    }
}
