package tn.suptech.examenahmedmannainumero_sujetv.services;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;




import com.itextpdf.text.pdf.PdfWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Eleve;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Niveau;

import javax.transaction.Transactional;

import java.io.FileOutputStream;
import java.io.IOException;

import java.util.stream.Stream;

import static com.itextpdf.text.Font.BOLD;


@Service
@Transactional
public class GenerationPdfService {
    @Autowired
   private ReleveNoteService releveNoteService;
    @Autowired
   private UserService  userService;
    @Autowired
   private SemestreService semestreService;

    private void addTableHeader(PdfPTable table) {
        Stream.of("Module","Moyenne Module" ,"Matierre","Coeifficient","Moyenne Matierre")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(1);

                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }
    private void RemplirTableau(PdfPTable table,Document document, Eleve eleve, Niveau niveau) throws DocumentException {
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        releveNoteService.getReleveNoteAnuelleByEleve(eleve,niveau).getReleveNoteList().forEach(r->{
            try {

                document.add(new Paragraph(r.getSemestre().getLibelleeSemestre()));
                document.add(new Paragraph(" "));
            } catch (DocumentException e) {
                e.printStackTrace();
            }
            table.deleteBodyRows();
            addTableHeader(table);
            r.getSemestre().getDtoModuleList().forEach(m->{
                PdfPCell header = new PdfPCell();
                header.setBackgroundColor(BaseColor.LIGHT_GRAY);

                header.setPhrase(new Phrase(m.getLibelleeModule()));
                header.setRowspan(m.getDtoMatiereList().size());



               table.addCell(header);
                header.setBackgroundColor(BaseColor.LIGHT_GRAY);

                header.setPhrase(new Phrase(m.getMoyenneModule().toString()));
                header.setRowspan(m.getDtoMatiereList().size());


                table.addCell(header);

                m.getDtoMatiereList().forEach(mat->{
                   // table.addCell("");
                    table.addCell(mat.getLibelleeMatiere());
                    table.addCell(mat.getMoyenneMatiere().toString());
                    table.addCell(mat.getCoeifficient().toString());
                });


            });
            try {
                document.add(table);
            } catch (DocumentException e) {
                e.printStackTrace();
            }


        });
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        Phrase resultat = new Phrase( releveNoteService.getReleveNoteAnuelleByEleve(eleve,niveau).getMoyenneAnuelle().toString() + " : "+  releveNoteService.getReleveNoteAnuelleByEleve(eleve,niveau).getResultat());
        resultat.setFont(new Font(Font.FontFamily.TIMES_ROMAN,18,BOLD));
        Paragraph moyennePAragraphe = new Paragraph(resultat);
        moyennePAragraphe.setAlignment(Element.ALIGN_RIGHT);
        document.add(moyennePAragraphe);




    }
    public  Document genererReleveeNotesAnuelle(Eleve eleve , Niveau niveau) throws IOException, DocumentException {
        Document document1 = new Document();
        PdfWriter.getInstance(document1, new FileOutputStream("C:\\Users\\AHMED.MANAI\\Desktop\\iTextHelloWorld2.pdf"));
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 20, BOLD);
        Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.ITALIC);
        document1.open();
        font.setSize(24);
        Phrase TitreDocument = new Phrase("Relevé de Notes :",boldFont);
        Paragraph paragraph = new Paragraph(TitreDocument);
        paragraph.setAlignment(Element.ALIGN_CENTER);

        document1.add(paragraph);
        Phrase niveauTitre = new Phrase("Niveau :",boldFont);
        Phrase nomPrenom = new Phrase("Nom et Prenom : ",boldFont);
        Phrase numInc = new Phrase("Numéro  d'inscription :",boldFont);

        document1.add(new Paragraph(niveauTitre.getContent() +  niveau.getLibelleeNiveau()));
        document1.add(new Paragraph(nomPrenom.getContent() +   eleve.getNom() + " " + eleve.getPrenom()));
        document1.add(new Paragraph(numInc.getContent() +   eleve.getNumeroInscription().toString()));

        document1.add(new Paragraph("             "));
        //creation de Tableau
        PdfPTable table2 = new PdfPTable(5);
        table2.setWidths(new float[] { 10,5,10,5,5});
       //ajouter les notes
        RemplirTableau(table2,document1,eleve,niveau);

        document1.close();




    return  document1;


    }
}
