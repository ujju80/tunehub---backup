package com.kodnest.tunehub.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.tunehub.entity.PlayList;
import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.service.PlayListService;
import com.kodnest.tunehub.service.SongService;

@Controller
public class PLayListController {
	
	@Autowired
	SongService songService;
	
	@Autowired
	PlayListService playListService;
	

	@GetMapping("/createplaylists")
	public String createplaylists (Model model) {
		List<Song> songList = songService.fetchAllSongs();
		model.addAttribute("songs" , songList);
		return "createplaylist";
	}
	
	@PostMapping("/addplaylist")
	public String addplaylist(@ModelAttribute PlayList playList) {
		playListService.addplaylist(playList);
		
		List<Song> songList = playList.getSongs();
		for(Song s: songList ) {
			s.getPlaylists().add(playList);
			
		}
		return "adminhome";
	}
	
	@GetMapping("/viewplaylists")
	public String viewplaylists(Model model) {
		List<PlayList> allplaylists = playListService.fetchAllPlaylists();
		model.addAttribute("allplaylists", allplaylists);
		return "displayplaylist";
				
				
	}
	
}
