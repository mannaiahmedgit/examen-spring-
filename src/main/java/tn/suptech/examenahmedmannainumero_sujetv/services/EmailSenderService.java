package tn.suptech.examenahmedmannainumero_sujetv.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.scanner.ScannerImpl;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender javaMailSender;
    public  void sendEmail(String to , String objet, String body){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("mannai.ahmed5555@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setText(body);
        simpleMailMessage.setSubject(objet);
        javaMailSender.send(simpleMailMessage);
        System.out.println("email envoyé");

    }


}
