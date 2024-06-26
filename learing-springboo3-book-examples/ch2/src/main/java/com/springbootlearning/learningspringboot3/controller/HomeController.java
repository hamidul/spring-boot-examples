package com.springbootlearning.learningspringboot3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springbootlearning.learningspringboot3.model.Video;
import com.springbootlearning.learningspringboot3.service.VideoService;

@Controller
public class HomeController {
	
	private final VideoService videoService;
	
	public HomeController(VideoService videoService) {
		this.videoService = videoService;
	}

	@GetMapping("/")
	public String index(Model model) {
		//Spring framework will create this model object 
		//The model object will be available in the template engine
		model.addAttribute("videos", videoService.getVideos());
		return "index";
	}

	@PostMapping("/new-video")
	public String newVideo(@ModelAttribute Video newVideo) {
		videoService.create(newVideo);
		return "redirect:/";
	}
}