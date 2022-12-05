package com.example.messagingstompwebsocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@RestController
public class GreetingController {
@Autowired
    private SimpMessagingTemplate template;
@Autowired
    private NotificationRepository notificationRepository;
    @CrossOrigin
    @RequestMapping(value = "/notify", method = RequestMethod.GET)
    public String getNotification() {

            List<Notifications> notifications = notificationRepository.findAllByFlagReadIsFalseAndUserToOrderBySentOnDesc("ede690b7b4d18ebaeab0d3591b6b2807da009d60");
            NotificationResponseDTO result = new NotificationResponseDTO();
            result.setNotifications(notifications);
            result.setUnreadAmount(notifications.size());

        template.convertAndSend("/topic/notification", result);

        return "Notifications successfully sent to Angular !";
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(2000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

}
