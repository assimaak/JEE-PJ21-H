package fil.sra.projet.model;

import fil.sra.projet.dao.Status;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="operations")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    long id;

    String type;
    int value;
    @Temporal(TemporalType.TIMESTAMP)
    Date dateStart ;
    @Temporal(TemporalType.TIMESTAMP)
    Date dateEnd ;

    @ManyToMany
    List<Article> articles ;



    public  List<Article> getArticles(){
        return articles;
    }

    public int getValue(){
        return value;
    }

    public int setValue(int value){
        return this.value=value;
    }




}
