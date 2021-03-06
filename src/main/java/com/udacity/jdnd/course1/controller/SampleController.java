package com.udacity.jdnd.course1.controller;

import com.udacity.jdnd.course1.model.ChatForm;
import com.udacity.jdnd.course1.model.MessageForm;
import com.udacity.jdnd.course1.service.ChatService;
import com.udacity.jdnd.course1.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class SampleController {

    MessageService messageService;
    ChatService chatService;

    public SampleController(MessageService messageService, ChatService chatService) {
        this.messageService = messageService;
        this.chatService = chatService;
    }

    @GetMapping("/homepage")
    public String getHome(@ModelAttribute("newMessage") MessageForm newMessage, Model model){
        model.addAttribute("greetings", messageService.getAllMessage());
        return "home";
    }

    @PostMapping("/homepage")
    public String postMessage(@ModelAttribute("newMessage") MessageForm newMessage,Model model){
        messageService.addMessage(newMessage.getText());
        model.addAttribute("greetings", messageService.getAllMessage());
        newMessage.setText("");
        return "home";
    }

    @GetMapping("/chat")
    public String getChat(@ModelAttribute("chatForm") ChatForm chatForm, Model model ){
        model.addAttribute("allChat", chatService.getAllChat());
        System.out.println("Get called");
        return "/chatTemplate";
    }

    @PostMapping("/chat")
    public String postChat(@ModelAttribute("chatForm") ChatForm chatForm, Model model){
        chatService.addChat(chatForm);
        model.addAttribute("allChat", chatService.getAllChat());
        chatForm.setUsername("");
        chatForm.setMessage("");
        return "/chatTemplate";
    }

    @ModelAttribute("allTypes")
    public String[] allMessageType(){ return new String[] {"say","whisper","shout"}; }

}
