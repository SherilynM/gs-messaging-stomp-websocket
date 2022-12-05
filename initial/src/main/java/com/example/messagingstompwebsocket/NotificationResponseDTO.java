package com.example.messagingstompwebsocket;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationResponseDTO {
    List<Notifications> notifications;
    int unreadAmount;
}
