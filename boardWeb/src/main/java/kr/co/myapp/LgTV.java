package kr.co.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV {
	@Autowired
	@Qualifier("sony")
	//@Resource(name="sony")
	private Speaker speaker;

	public LgTV() {
		System.out.println("LgTV 객체생성");
	}

	@Override
	public void powerOn() {
		System.out.println("LgTV---전원 켠다.");

	}

	@Override
	public void powerrOff() {
		System.out.println("LgTV---전원 끈다.");

	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}

}
