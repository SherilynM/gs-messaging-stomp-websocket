package com.example.messagingstompwebsocket;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="Notifications")
public class Notifications implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    @Column(name = "id",columnDefinition = "CHAR(36)",nullable = false)// character set ascii
    private String id;
    @Column(name = "title",columnDefinition = ("VARCHAR (128)"))
    private String title;
    @Column(name = "msg",nullable = false)
    @Lob
    private String msg;
    @Column(name = "user_from",columnDefinition = ("CHAR (40)"),nullable = false)//debe pertenecer al circulo de contactos de user_to
    private String userFrom;
    @Column(name = "user_to",columnDefinition = ("CHAR (40)"),nullable = false)//debe pertenecer al circulo de contactos de user_from
    private String userTo;
    @CreatedDate
    @Column(name = "sent_on",columnDefinition = ("DATETIME"),nullable = false)
    private Date sentOn;
    @Column(name = "flag_read",columnDefinition = ("BIT (1)"),nullable = false)
    private boolean flagRead;
}
