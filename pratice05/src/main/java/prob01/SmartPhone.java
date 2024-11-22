package prob01;

public class SmartPhone extends MusicPhone {
	@Override
	public void execute(String function) {
		if (function.equals("앱")) {
			startApp();
			return;
		}
		super.execute(function);
	}

	@Override
	protected void playMusic() {
		System.out.println("다운로드해서 음악 재생");
	}

	public void startApp() {
		System.out.println("앱실행");
	}
}
