package tn.suptech.examenahmedmannainumero_sujetv.services;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.scanner.ScannerImpl;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;

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



    public void envoiBuleteinAnuelle(String emailEleve, String subject, String body, Document document) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailEleve));
                mimeMessage.setFrom(new InternetAddress("mannai.ahmed5555@gmail.com"));
                mimeMessage.setSubject(subject);
                mimeMessage.setText(body);

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PdfWriter.getInstance(document, baos);

                MimeBodyPart messageBodyPart = new MimeBodyPart();
                messageBodyPart.setText("veillez trouver ci-joint ");
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(messageBodyPart);

                messageBodyPart = new MimeBodyPart();

                DataSource source = new ByteArrayDataSource(baos.toByteArray(), "application/pdf");
                messageBodyPart.setDataHandler(new DataHandler(source));
                messageBodyPart.setFileName("bultein.pdf");
                multipart.addBodyPart(messageBodyPart);

                mimeMessage.setContent(multipart);

                javaMailSender.send(mimeMessage);



            }
        };

    }



}
