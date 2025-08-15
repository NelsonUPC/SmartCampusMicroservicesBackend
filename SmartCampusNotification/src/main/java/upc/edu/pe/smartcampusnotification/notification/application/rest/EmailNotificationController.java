package upc.edu.pe.smartcampusnotification.notification.application.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import upc.edu.pe.smartcampusnotification.notification.application.services.EmailService;
import upc.edu.pe.smartcampusnotification.notification.domain.dto.EmailMessage;

@RestController
@RequestMapping("/teacher/notifications/email")
@RequiredArgsConstructor
public class EmailNotificationController {

    private final EmailService emailService;

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmailMessage message) {
        try {
            emailService.sendEmail(message.getParentEmail(), message.getSubject(), message.getBody());
            return ResponseEntity.ok("Correo enviado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al enviar el correo: " + e.getMessage());
        }
    }
}
