package tn.suptech.examenahmedmannainumero_sujetv.web;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Eleve;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Niveau;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Semestre;
import tn.suptech.examenahmedmannainumero_sujetv.model.ReleveNote;
import tn.suptech.examenahmedmannainumero_sujetv.model.ReleveNoteAnuelle;
import tn.suptech.examenahmedmannainumero_sujetv.services.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(path="/api/bulletin")
public class BulteinController {
    private ReleveNoteService _releveNoteService;
    private UserService _userService;
    private SemestreService _semestreService;
    private NiveauService _niveauService;
    @Autowired
    private GenerationPdfService generationPdfService;
    @Autowired
    private  EmailSenderService emailSenderService;
    public BulteinController(ReleveNoteService _releveNoteService, UserService _userService, SemestreService _semestreService,NiveauService niveauService) {
        this._releveNoteService = _releveNoteService;
        this._userService = _userService;
        this._semestreService = _semestreService;
        this._niveauService=niveauService;
    }

    @RequestMapping("/byEleveBySemestre/{idEleve}/{idSemestre}")
    public ReleveNote getReleveNoteEleveSemestre(@PathVariable("idEleve") Long idEleve, @PathVariable("idSemestre") Long idSemestre){
        Eleve eleve=(Eleve) _userService.getOne(idEleve);
        Semestre semestre= _semestreService.getOne(idSemestre);
        return  _releveNoteService.getReleveNoteByEleve(eleve,semestre);

    }
    @RequestMapping("/byEleveByNiveau/{idEleve}/{idNiveau}")
    public ReleveNoteAnuelle getReleveNoteEleveNiveau(@PathVariable("idEleve") Long idEleve, @PathVariable("idNiveau") Long idNiveau){
        Eleve eleve=(Eleve) _userService.getOne(idEleve);
        Niveau niveau= _niveauService.getOne(idNiveau);
        return  _releveNoteService.getReleveNoteAnuelleByEleve(eleve,niveau);

    }

    @RequestMapping("/genererRelevee2/{idEleve}/{idNiveau}")
    public void genererReleveeNotesAnuelle (HttpServletResponse response, @PathVariable("idEleve") Long idEleve, @PathVariable("idNiveau") Long idNiveau) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        String headerKey="Content-Disposition";
        String headerValue="attachement;filename=pdf_"+"test.pdf";
        Eleve eleve=(Eleve) _userService.getOne(idEleve);
        Niveau niveau= _niveauService.getOne(idNiveau);
        Document document= generationPdfService.genererReleveeNotesAnuelle(eleve,niveau);
        response.setHeader(headerKey,headerValue);
        PdfWriter.getInstance(document,response.getOutputStream()).open();

    }
    @RequestMapping("/envoiBulleteinEleveMail/{idEleve}/{idNiveau}")
    public void envoyerBulleteinAuEleve( @PathVariable("idEleve") Long idEleve, @PathVariable("idNiveau") Long idNiveau) throws DocumentException, IOException {
        Eleve eleve=(Eleve) _userService.getOne(idEleve);
        Niveau niveau= _niveauService.getOne(idNiveau);
        Document document= generationPdfService.genererReleveeNotesAnuelle(eleve,niveau);

        emailSenderService.envoiBuleteinAnuelle(eleve.getEmail(),"Buletein Anuelle","",document);

    }


}
