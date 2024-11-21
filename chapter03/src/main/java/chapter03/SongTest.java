package chapter03;

public class SongTest {

	public static void main(String[] args) {
//		Song song = new Song();
//		
//		song.setTitle("좋은 날");
//		song.setArtist("아이유");
//		song.setAlbum("Real");
//		song.setComposer("이민수");
//		song.setYear(2010);
//		song.setTrack(3);
		
		// 생성자를 통한 객체 초기화 
		Song song1 = new Song("좋은 날","아이유", "Real", "이민수", 2010, 3);
		song1.show();
		
		Song song2 = new Song("Ditto", "뉴진스");
		song2.show();

	}

}
