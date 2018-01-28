package co.kr.myhome.command.service;

import co.kr.myhome.command.base.CommandService;

public class MediaCommandService extends CommandService{

	public MediaCommandService() throws Exception {
		super("media");
	}
	
	public void play() throws Exception{
		this.command("play");
	}

	public void next() throws Exception{
		this.command("next");
	}

	public void prev() throws Exception{
		this.command("prev");
	}
	
	public void volueDown() throws Exception{
		this.command("volueDown");
	}

	public void volueUp() throws Exception{
		this.command("volueUp");
	}
	
	public void play_pause() throws Exception{
		this.command("play_pause");
	}
	
	public void runItunes() throws Exception{
		this.command("itunes");
	}
}
